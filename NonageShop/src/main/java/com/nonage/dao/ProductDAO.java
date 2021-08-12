package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {
	}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//New Item
    public ArrayList<ProductVO> listNewProduct() {
    	
    	ArrayList<ProductVO> productList =  new ArrayList<ProductVO>();
    	String sql = "select * from new_pro_view";
    	Connection conn = null;
    	PreparedStatement pstmt =  null;
    	ResultSet rs = null;
    	
    	
    	try {
    		conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery(sql);
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
    		    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		DBManager.close(conn, pstmt, rs);
    	}
		return productList;
    }
	//best Item
    public ArrayList<ProductVO> listBestProduct() {
    	
    	ArrayList<ProductVO> productList =  new ArrayList<ProductVO>();
    	String sql = "select * from best_pro_view";
    	Connection conn = null;
    	PreparedStatement pstmt =  null;
    	ResultSet rs = null;
    	
    	
    	try {
    		conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery(sql);
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				product.setImage(rs.getString("image"));
				productList.add(product);
			}
    		    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		DBManager.close(conn, pstmt, rs);
    	}
		return productList;
    }
}
