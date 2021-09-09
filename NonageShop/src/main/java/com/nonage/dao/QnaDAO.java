package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.dto.QnaVO;

import util.DBManager;

public class QnaDAO {
	private QnaDAO() {
	}
	private static QnaDAO instance = new QnaDAO();
	
	public static QnaDAO getInstance() {
		return instance;
	}
	
	public ArrayList<QnaVO> listQna(String id) {
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		String sql = "select * from qna where id = ? order by qseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		  conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	   
	      while(rs.next()) {
	    	  QnaVO qnaVO = new QnaVO();
	    	  qnaVO.setQseq(rs.getInt("qseq"));
	    	  qnaVO.setSubject(rs.getString("subject"));
	    	  qnaVO.setContent(rs.getString("content"));
	    	  qnaVO.setReply(rs.getString("reply"));
	    	  qnaVO.setId(rs.getString("id"));
	    	  qnaVO.setRep(rs.getString("rep"));
	    	  qnaVO.setIndate(rs.getTimestamp("indate"));
	    	  qnaList.add(qnaVO);
	      }
	      
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
		  DBManager.close(conn, pstmt, rs);
		}	
		return qnaList;
	}
}