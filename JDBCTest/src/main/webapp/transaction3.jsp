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
	ResultSetMetaData rsmd = null;
	String sql = request.getParameter("cho");
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
		conn = ds.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		rsmd = rs.getMetaData();

		out.print("<table border = '1'>");
		out.print("<tr>");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			out.print("<td>");
			out.print(rsmd.getColumnName(i));
			out.print("</td>");
		}
		out.print("</tr>");
		out.print("<tr>");
		while(rs.next()){
			for (int i = 1; i <= rsmd.getColumnCount(); i++)  {
				out.print("<td>");
				
				if(rsmd.getColumnTypeName(i) == "NUMBER") {
					out.print(rs.getInt(i));
				} else if (rsmd.getColumnTypeName(i) == "VARCHAR2") {
					out.print(rs.getString(i));
				} else  {
					out.print(rs.getDate(i));
				}
				out.print("</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		try {
			rs.close();
			pstmt.close();
			conn.close();
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