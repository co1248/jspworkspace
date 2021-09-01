package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.CartVO;

import util.DBManager;

public class CartDAO {
	private static CartDAO instance = new CartDAO();
	private CartDAO() {
	}
	public static CartDAO getInstance() {
		return instance;
	}
	
	public void inserCart(CartVO cartVO) {
		String sql = "insert into cart (cseq, id, pseq, quantity) values (cart_seq.nextval,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, cartVO.getId());
		      pstmt.setInt(2, cartVO.getPseq());
		      pstmt.setInt(3, cartVO.getQuantity());
		      pstmt.executeUpdate();
			} catch (Exception e) {
			      e.printStackTrace();
			} finally {
			  DBManager.close(conn, pstmt);
			}
	}
	public ArrayList<CartVO> listCart(String userId) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		String sql= "select * from cart_view where id = ? order by cseq desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, userId);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	    	  CartVO cartVO = new CartVO();
	    	  cartVO.setCseq(rs.getInt("cseq"));
	    	  cartVO.setId(rs.getString("id"));
	    	  cartVO.setPseq(rs.getInt("pseq"));
	    	  cartVO.setMname(rs.getString("mname"));
	    	  cartVO.setPname(rs.getString("pname"));
	    	  cartVO.setQuantity(rs.getInt("quantity"));
	    	  cartVO.setPrice2(rs.getInt("price2"));
	    	  cartVO.setIndate(rs.getTimestamp("indate"));
	          cartList.add(cartVO);
	      }
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}
		return cartList;	
	}
}
