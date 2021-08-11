package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.EmployeesVO;

import util.DBManager;

public class EmployeesDAO {
	private EmployeesDAO() {
	}
	
	private static EmployeesDAO instance =  new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	public List<EmployeesVO> selectAllEmployees() {
		String sql = "select * from employees";
		List<EmployeesVO> list = new ArrayList<EmployeesVO>();
		Connection  conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				EmployeesVO eVo = new EmployeesVO();
				eVo.setId(rs.getString("id"));
				eVo.setPass(rs.getString("pass"));
				eVo.setName(rs.getString("name"));
				eVo.setLev(rs.getString("lev"));
				eVo.setEnter(rs.getDate("enter"));
				eVo.setGender(rs.getString("gender"));
				eVo.setPhone(rs.getString("phone"));
				list.add(eVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public void insertEmployee(EmployeesVO eVo) {
		String sql = "insert into employees values (?, ?, ?, ?, sysdate, ?, ?)";
		Connection  conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getId());	
			pstmt.setString(2, eVo.getPass());
			pstmt.setString(3, eVo.getName());
			pstmt.setString(4, eVo.getLev());
			pstmt.setString(5, eVo.getGender());
			pstmt.setString(6, eVo.getPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public EmployeesVO selectOneEmployeeById(String id) {
		String sql = "select * from employees where id = ?";
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeesVO eVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				eVo = new EmployeesVO();
				eVo.setId(rs.getString("id"));
				eVo.setPass(rs.getString("pass"));
				eVo.setName(rs.getString("name"));
				eVo.setLev(rs.getString("lev"));
				eVo.setEnter(rs.getDate("enter"));
				eVo.setGender(rs.getString("gender"));
				eVo.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return eVo;
	}
	public void updateEmployees(EmployeesVO eVo) {
		String sql = "update employees set pass = ?, name = ?, lev = ?, gender = ?, phone = ? where id = ?";	
		Connection  conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getPass());
			pstmt.setString(2, eVo.getName());
			pstmt.setString(3, eVo.getLev());
			pstmt.setString(4, eVo.getGender());
			pstmt.setString(5, eVo.getPhone());
			pstmt.setString(6, eVo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void deleteEmployee(String id) {
		String sql = "delete employees where id = ?";
				
		Connection  conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
