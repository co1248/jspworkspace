package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
						result = 2; //���
						if(rs.getString("lev").equals("B")) {
							result = 3; //�Ϲ�ȸ��
						}
					} else { //���� ����ġ
						result = 1;
					}
				} else { //��й�ȣ ����ġ
					result = 0;
				}
			} else { //���̵� ����ġ
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
	
}
