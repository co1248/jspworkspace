package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	
	private static MemberDAO memberInstance = new MemberDAO();

	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberInstance;
	}
	
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
	 	DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/OracleDB");
	 	Connection conn = ds.getConnection();
		return conn;
	}
	
	public int userCheck(String userid, String pwd) {
		
		int result = -1;
		String sql = "select pwd from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1) != null && rs.getString(1).equals(pwd) ) {
					return 1;
				}else {
					return 0;
				}
			}else {
				return -1;
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
	
	public MemberVO getMember(String userid) {
		
		MemberVO mVo = null;
		String sql = "select * from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getShort("admin"));
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
		return mVo;	
	}
}
