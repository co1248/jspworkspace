<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null; //컬럼정보 가져오기위한 메타데이터
	String sql = "select id, name, age, gender, email from member";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
		conn = ds.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		
		
			rs = pstmt.executeQuery(); //결과받기
			rsmd = rs.getMetaData(); //메타정보
	
			out.print("<table border = '1'align = 'center' >");
			out.print("<tr align = 'center'>");
			out.print("<td colspan = '5'>");
			out.print("회원목록");
			out.print("</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>");out.print("아이디");out.print("</td>");
			out.print("<td>");out.print("이름");out.print("</td>");
			out.print("<td>");out.print("나이");out.print("</td>");
			out.print("<td>");out.print("성별");out.print("</td>");
			out.print("<td>");out.print("이메일");out.print("</td>");			
			out.print("</tr>");
			while(rs.next()){ //rs.next()읽어올 레코드가 있으면 true
			  out.print("<tr>");
			  out.print("<td>");out.print("<a href = "member_info?id=" + rs.getString(1) + ">");out.print(rs.getString(1));out.print("</a>");out.print("</td>");
			  out.print("<td>");out.print(rs.getString(2));out.print("</td>");
			  out.print("<td>");out.print(rs.getInt(3));out.print("</td>");
			  out.print("<td>");out.print(rs.getString(4));out.print("</td>");
			  out.print("<td>");out.print(rs.getString(5));out.print("</td>");
			  out.print("</tr>");
			}
			out.print("</table>");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>