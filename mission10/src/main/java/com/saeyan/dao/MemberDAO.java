package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//c Read u d
	public List<MemberVO> selectAllMembers() {
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from member order by code desc";
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setCode(rs.getInt("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setPoster(rs.getString("poster"));
				mVo.setSynopsis(rs.getString("synopsis"));
				list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//create r u d
	public void insertMembers(MemberVO mVo) {
		String sql = "insert into member VALUES (member__seq.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getTitle());
			pstmt.setInt(2, mVo.getPrice());
			pstmt.setString(3, mVo.getDirector());
			pstmt.setString(4, mVo.getActor());
			pstmt.setString(5, mVo.getPoster());
			pstmt.setString(6, mVo.getSynopsis());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	//c Read u d
    public MemberVO selectMemberByCode(String code) {
    	String sql = "select * from member where code = ?";
    	MemberVO mVo = null;
    	try {
    		Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs= pstmt.executeQuery();
				if(rs.next()) {
					mVo = new MemberVO();
					mVo.setCode(rs.getInt("code"));
					mVo.setTitle(rs.getString("title"));
					mVo.setPrice(rs.getInt("price"));
					mVo.setDirector(rs.getString("director"));
					mVo.setActor(rs.getString("actor"));
					mVo.setPoster(rs.getString("poster"));
					mVo.setSynopsis(rs.getString("synopsis"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return mVo;
    }
  //c r Update d
  	public void updateMember(MemberVO mVo) {
  		String sql = "update member set title = ?, price = ?, director = ?, actor = ?, synopsis = ?, poster = ? where code = ?";
  		Connection conn = null;
  		PreparedStatement pstmt = null;
  		try {
  			conn = DBManager.getConnection();
  			pstmt = conn.prepareStatement(sql);
  			pstmt.setString(1, mVo.getTitle());
  			pstmt.setInt(2, mVo.getPrice());
  			pstmt.setString(3, mVo.getDirector());
  			pstmt.setString(4, mVo.getActor());
  			pstmt.setString(5, mVo.getSynopsis());
  			pstmt.setString(6, mVo.getPoster());
  			pstmt.setInt(7, mVo.getCode());
  			pstmt.executeUpdate();//쿼리문 실행한다.
  		} catch (Exception e) {
  			e.printStackTrace();
  		} finally {
  			DBManager.close(conn, pstmt);
  		}
  	}
  //c r u Delete
 	public void deleteMember(String code) {
  		String sql = "delete member where code = ?";
  		Connection conn = null;
  		PreparedStatement pstmt = null;
  		try {
  			conn = DBManager.getConnection();
  			pstmt = conn.prepareStatement(sql);
  			pstmt.setString(1, code);
  			pstmt.executeUpdate();//쿼리문 실행한다.
  		} catch (Exception e) {
  			e.printStackTrace();
  		} finally {
  			DBManager.close(conn, pstmt);
  		}
  	}
}
