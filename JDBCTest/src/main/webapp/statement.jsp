<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	String sql = "insert into student (num, name) values (7, '홍길동')";
	Statement stmt = null;

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
		conn = ds.getConnection();
		
		stmt = conn.createStatement();
		
		int result = stmt.executeUpdate(sql); //executeQuery() : select
		if(result != 0) {
			out.print("<h3>레코드 삽입 성공</h3>");
		}
	
	}catch(Exception e){
		out.print("<h3>레코드 삽입 실패</h3>");
		e.printStackTrace();
	} finally {
		try {
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
</body>
</html>