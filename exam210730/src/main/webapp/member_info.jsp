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
String sql = "select * from member where id = ?";
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
	conn = ds.getConnection();
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,request.getParameter("id"));
	
	rs = pstmt.executeQuery(); //결과받기
	rsmd = rs.getMetaData(); //메타정보
	out.print("<table border = '1' align = 'center'>");
	out.print("<tr align = 'center'>");
	
	out.print("<td>아이디:   </td>");
	out.print("<td>rs.getString(1)</td>");
	out.print("</tr>");
	out.print("<tr>");
	
	out.print("<td>비밀번호:   </td>");
	out.print("<td>rs.getString(2)</td>");
	out.print("</tr>");
	out.print("<tr>");
	
	out.print("<td>이름:   </td>");
	out.print("<td>rs.getString(3)</td>");
	out.print("</tr>");
	out.print("<tr>");
	
	out.print("<td>나이:   </td>");
	out.print("<td>rs.getInt(4)</td>");
	out.print("</tr>");
	out.print("<tr>");
	
	out.print("<td>성별:   </td>");
	out.print("<td>rs.getString(5)</td>");
	out.print("</tr>");
	out.print("<tr>");
	
	out.print("<td>이메일:   </td>");
	out.print("<td> rs.getString(6)</td>");
	out.print("</tr>");
	out.print("</table>");
	pstmt.executeUpdate();
	
}catch(Exception e) {
	e.printStackTrace();
}finally {
	try {
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}catch(Exception e) {
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