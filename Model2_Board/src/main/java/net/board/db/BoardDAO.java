package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleBoard");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}
	//글의 개수 구하기
	public int getListCount() {
		int x = 0;
		String sql = "select count(*) from board";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery(sql);
			
			if(rs.next()) {
				x =  rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException e){e.printStackTrace();} 
            if(pstmt != null) try{pstmt.close();}catch(SQLException e){e.printStackTrace();} 
            if(con != null) try{con.close();}catch(SQLException e){e.printStackTrace();} 
		}
		return x;
	}
	
	//글 목록 보기
	public List getBoardList(){
		
		String sql = "select * from board order by board_num desc";
		List list = new ArrayList();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery(sql);
			while(rs.next()) {
				BoardBean board = new BoardBean(); 
				board.setNum(rs.getInt("BOARD_NUM")); 
                board.setName(rs.getString("BOARD_NAME")); 
                board.setPass(rs.getString("BOARD_PASS")); 
                board.setSubject(rs.getString("BOARD_SUBJECT")); 
                board.setContent(rs.getString("BOARD_CONTENT")); 
                board.setFile(rs.getString("BOARD_FILE")); 
                board.setReadcount(rs.getInt("BOARD_READCOUNT")); 
                board.setDate(rs.getDate("BOARD_DATE")); ;
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException e){e.printStackTrace();} 
            if(pstmt != null) try{pstmt.close();}catch(SQLException e){e.printStackTrace();} 
            if(con != null) try{con.close();}catch(SQLException e){e.printStackTrace();} 
		}
		return list;
		
	}
	
	//글 내용 보기.
	public BoardBean getDetail(int num) throws Exception{
		BoardBean board = null; 
			
		try{ 
			con = ds.getConnection();
            pstmt = con.prepareStatement("select * from board where BOARD_NUM=?"); 
            pstmt.setInt(1, num); 
            rs= pstmt.executeQuery(); 
             
            if(rs.next()){ 
                board = new BoardBean(); 
                board.setNum(rs.getInt("BOARD_NUM")); 
                board.setName(rs.getString("BOARD_NAME")); 
                board.setPass(rs.getString("BOARD_PASS")); 
                board.setSubject(rs.getString("BOARD_SUBJECT")); 
                board.setContent(rs.getString("BOARD_CONTENT")); 
                board.setFile(rs.getString("BOARD_FILE")); 
                board.setReadcount(rs.getInt("BOARD_READCOUNT")); 
                board.setDate(rs.getDate("BOARD_DATE")); 
            } 
        }catch(Exception e){ 
        	e.printStackTrace();
        }finally{ 
			if(rs != null) try{rs.close();}catch(SQLException e){e.printStackTrace();} 
            if(pstmt != null) try{pstmt.close();}catch(SQLException e){e.printStackTrace();} 
            if(con != null) try{con.close();}catch(SQLException e){e.printStackTrace();} 
        } 
        return board; 
	}
	
	//글 등록
	public boolean boardInsert(BoardBean board){
		int num = 0;
        String sql = null;        
        int result = 0;
              
        try{ 
        	con = ds.getConnection();
        	pstmt = con.prepareStatement("select max(board_num) from board"); 
            rs = pstmt.executeQuery();             
             
            if(rs.next()) {      
                num = rs.getInt(1)+1; 
            }else{     
                num = 1; 
            } 
            
            sql="insert into board values(?,?,?,?,?,?,0,sysdate)";             
            pstmt = con.prepareStatement(sql); 
            pstmt.setInt(1, num); 
            pstmt.setString(2, board.getName()); 
            pstmt.setString(3, board.getPass()); 
            pstmt.setString(4, board.getSubject()); 
            pstmt.setString(5, board.getContent()); 
            pstmt.setString(6, board.getFile());         
            result = pstmt.executeUpdate(); 
            if(result!=0){ 
                return true; 
            }             
        }catch(Exception e){ 
        	e.printStackTrace();
        }finally{ 
        	if(rs != null) try{rs.close();}catch(SQLException e){e.printStackTrace();} 
            if(pstmt != null) try{pstmt.close();}catch(SQLException e){e.printStackTrace();} 
            if(con != null) try{con.close();}catch(SQLException e){e.printStackTrace();} 
        } 
        return false;        
	}
	

	//조회수 업데이트
	public void setReadCountUpdate(int num) throws Exception{
		String sql="update board set BOARD_READCOUNT = BOARD_READCOUNT + 1 where BOARD_NUM="+num;         
		try{ 
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql); 
			pstmt.executeUpdate(); 
		} catch(SQLException e){ 
			e.printStackTrace();
		} finally{ 
            if(pstmt != null) try{pstmt.close();}catch(SQLException e){e.printStackTrace();} 
            if(con != null) try{con.close();}catch(SQLException e){e.printStackTrace();}  
		} 
	}
}
