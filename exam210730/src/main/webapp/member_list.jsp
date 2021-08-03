<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
			Context init = new InitialContext();
			DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/oracleDB");
			conn = ds.getConnection();
			
			pstmt=conn.prepareStatement("SELECT * FROM member");
			rs=pstmt.executeQuery();
			%>
			<table border=1 width=500>
			<tr align=center>
				<td colspan="5">회원 목록</td>
			</tr>
			<tr align=center>
				<td>아이디</td><td>이름</td><td>나이</td><td>성별</td><td>이메일</td>
			</tr>
			
			<%while(rs.next()){%>
				<tr align=center>
					<td>
						<a href="member_info.jsp?id=<%=rs.getString("id") %>">
							<%=rs.getString("id") %>
						</a>
					</td>
					<td><%=rs.getString("name") %></td>
					<td><%=rs.getInt("age") %></td>
					<td><%=rs.getString("gender") %></td>
					<td><%=rs.getString("email") %></td>
				</tr>
			<%} %>
		</table>
	<%	
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