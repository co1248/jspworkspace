package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nonage.dto.AddressVO;

import util.DBManager;

public class AddressDAO {
	private AddressDAO() {
		
	}
	
	private static AddressDAO instance = new AddressDAO();
	
	public static AddressDAO getInstance() {
		return instance;
	}

	public List<AddressVO> selectAddressByDong(String dong) {
		// TODO Auto-generated method stub
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		String sql = "select * from address where dong like '%'||?||'%'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, dong);
		      rs = pstmt.executeQuery();
		      
		      while(rs.next()) {
		    	  AddressVO address = new AddressVO();
		    	  address.setZipNum(rs.getString("zip_num"));
		    	  address.setSido(rs.getString("sido"));
		    	  address.setGugun(rs.getString("gugun"));
		    	  address.setDong(rs.getString("dong"));
		    	  address.setZipCode(rs.getString("zip_code"));
		    	  address.setBunji(rs.getString("bunji"));
		    	  list.add(address);
		      }
			} catch (Exception e) {
			      e.printStackTrace();
			} finally {
			  DBManager.close(conn, pstmt, rs);
			}
		
		return list;		
	}
}
