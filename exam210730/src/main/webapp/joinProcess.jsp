<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection" %>
<%@ page import ="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import ="java.sql.PreparedStatement" %>
<%@ page import ="javax.servlet.http.HttpSession" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn = null;
PreparedStatement pstmt = null;
String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
String id = request.getParameter("id");
String password = request.getParameter("password");
String  name = request.getParameter("name");
Integer age = Integer.parseInt(request.getParameter("age"));
String gender = request.getParameter("gender");
String email = request.getParameter("email");
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
	conn = ds.getConnection();
	
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	pstmt.setString(3, name);
	pstmt.setInt(4, age);
	pstmt.setString(5, gender);
	pstmt.setString(6, email);
	
	pstmt.executeUpdate();
	
	//HttpSession session = request.getSession();

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
<%

if(session.getAttribute("loginUser") != null) {
	response.sendRedirect("loginForm.jsp");
}
response.sendRedirect("member_list.jsp");
%> 

</body>
</html>