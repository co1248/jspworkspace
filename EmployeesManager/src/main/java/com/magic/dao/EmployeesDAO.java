package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO;
import com.magic.dao.EmployeesDAO;

public class EmployeesDAO {
	private static EmployeesDAO instance = new EmployeesDAO();

	private EmployeesDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
	 	Connection conn  = null;
		Context initContext = null;
		try { 
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/oracleDB");
			conn = ds.getConnection();
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public int userCheck(String id, String pass, String lev) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where id = ?";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					if(rs.getString("lev").equals(lev)) {
						result = 2; //운영자
						if(rs.getString("lev").equals("B")) {
							result = 3; //일반회원
						}
					} else { //레벨 불일치
						result = 1;
					}
				} else { //비밀번호 불일치
					result = 0;
				}
			} else { //아이디 불일치
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public EmployeesVO getMember(String id) {
		EmployeesVO empVo = null;
		String sql = "select * from employees where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				empVo = new EmployeesVO();
				empVo.setId(rs.getString("id"));
				empVo.setPass(rs.getString("pass"));
				empVo.setName(rs.getString("name"));
				empVo.setLev(rs.getString("lev"));
				empVo.setEnter(rs.getDate("enter"));
				empVo.setGender(rs.getInt("gender"));
				empVo.setPhone(rs.getString("phone"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return empVo;
	}
	public int updateMember(EmployeesVO empVo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update employees set pass = ?, name = ?, lev = ? , gender = ?, phone = ? where id = ?";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empVo.getPass());
			pstmt.setString(2, empVo.getName());
			pstmt.setString(3, empVo.getLev());
			pstmt.setInt(4, empVo.getGender());
			pstmt.setString(5, empVo.getPhone());
			pstmt.setString(6, empVo.getId());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public void insertMember(EmployeesVO empVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into employees values (?,?,?,?,sysdate,?,?)";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empVo.getId());
			pstmt.setString(2, empVo.getPass());
			pstmt.setString(3, empVo.getName());
			pstmt.setString(4, empVo.getLev());
			pstmt.setInt(5, empVo.getGender());
			pstmt.setString(6, empVo.getPhone());

			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<EmployeesVO> getListAll() {
		EmployeesVO empVo = null;
		ArrayList<EmployeesVO> list =  new ArrayList<EmployeesVO>();
		String sql = "select * from employees";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				empVo = new EmployeesVO();
				empVo.setId(rs.getString("id"));
				empVo.setPass(rs.getString("pass"));
				empVo.setName(rs.getString("name"));
				empVo.setLev(rs.getString("lev"));
				empVo.setEnter(rs.getDate("enter"));
				empVo.setGender(rs.getInt("gender"));
				empVo.setPhone(rs.getString("phone"));
				
				list.add(empVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
