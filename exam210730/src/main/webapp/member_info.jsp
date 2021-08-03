<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	String info_id=request.getParameter("id");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
			Context init = new InitialContext();
			DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/oracleDB");
			conn = ds.getConnection();
			
			pstmt=conn.prepareStatement("SELECT * FROM member WHERE id=?");
			pstmt.setString(1,info_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {%>
			<table border=1 width=300>	
				<tr>
					<td>아이디 : </td><td><%=rs.getString("id") %></td>
				</tr>
				<tr>
					<td>비밀번호 : </td><td><%=rs.getString("password") %></td>
				</tr>
				<tr>
					<td>이름 : </td><td><%=rs.getString("name") %></td>
				</tr>
				<tr>
					<td>나이 : </td><td><%=rs.getInt("age") %></td>
				</tr>
				<tr>
					<td>성별 : </td><td><%=rs.getString("gender") %></td>
				</tr>
				<tr>
					<td>이메일 주소 : </td><td><%=rs.getString("email") %></td>
				</tr>
				<tr>
					<td colspan=2><a href="member_list.jsp">리스트 돌아가기</a></td>
				</tr>
			</table>
		
		<%} 
			
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
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