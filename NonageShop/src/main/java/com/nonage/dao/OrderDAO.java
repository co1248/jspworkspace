package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.CartVO;
import com.nonage.dto.OrderVO;

import util.DBManager;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();
	private OrderDAO() {
	}
	public static OrderDAO getInstance() {
		return instance;
	}
	public int insertOrder(ArrayList<CartVO> cartList, String id) {
		int maxOseq = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		  conn = DBManager.getConnection();
		  String insertOrder = "insert into orders(oseq, id) values(orders_seq.nextval, ?)";
	      pstmt = conn.prepareStatement(insertOrder);
	      pstmt.setString(1, id);
	      pstmt.executeUpdate();
	      pstmt.close();
	      
	      String selectMaxOseq = "select max(oseq) from orders";
	      pstmt = conn.prepareStatement(selectMaxOseq);
	      rs = pstmt.executeQuery();
	      if(rs.next()) {
	    	  maxOseq = rs.getInt(1);
	      }
	      
	      for(CartVO cartVO : cartList) {
	    	   insertOrderDetail(cartVO, maxOseq);
	      }
	
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}	
		return maxOseq;
	}
	public void insertOrderDetail(CartVO cartVO, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			  conn = DBManager.getConnection();
			  String insertOrderDetail = "insert into order_detail(odseq, oseq, pseq, quantity) values(order_detail_seq.nextval, ?, ?, ?)";
		      pstmt = conn.prepareStatement(insertOrderDetail);
		      pstmt.setInt(1, maxOseq);
		      pstmt.setInt(2, cartVO.getPseq());
		      pstmt.setInt(3, cartVO.getQuantity());
		      pstmt.executeUpdate();
		      pstmt.close();
		      
		      String updateCartResult = "update cart set result = 2 where cseq = ?";
		      pstmt = conn.prepareStatement(updateCartResult);
		      pstmt.setInt(1, cartVO.getCseq());
		      pstmt.executeUpdate();
		      
			} catch (Exception e) {
			      e.printStackTrace();
			} finally {
			  DBManager.close(conn, pstmt);
			}	
	}
	public ArrayList<OrderVO> listOrderById(String id, String result, int oseq) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select * from order_view where id = ? and result like '%'||?||'%' and oseq = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, id);
	      pstmt.setString(2, result);
	      pstmt.setInt(3, oseq);
	      rs = pstmt.executeQuery();
	   
	      while(rs.next()) {
	    	  OrderVO orderVO = new OrderVO();
	    	  orderVO.setOdseq(rs.getInt("odseq"));
	    	  orderVO.setOseq(rs.getInt("oseq"));
	    	  orderVO.setId(rs.getString("id"));
	    	  orderVO.setIndate(rs.getTimestamp("indeate"));
	    	  orderVO.setMname(rs.getString("mname"));
	    	  orderVO.setZipNum(rs.getString("zipNum"));
	    	  orderVO.setAddress(rs.getString("address"));
	    	  orderVO.setPhone(rs.getString("phone"));
	    	  orderVO.setPseq(rs.getInt("pseq"));
	    	  orderVO.setPname(rs.getString("pname"));
	    	  orderVO.setQuantity(rs.getInt("quantity"));
	    	  orderVO.setPrice2(rs.getInt("price2"));
	    	  orderVO.setResult(rs.getString("result"));
	    	  orderList.add(orderVO);
	      }
	      
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}	
		return orderList;
	}
}
