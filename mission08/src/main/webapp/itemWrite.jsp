<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.DriverManager" %>
<%@ page import ="java.sql.ResultSet" %>
<%@ page import ="java.sql.Statement" %>
<%@ page import ="java.sql.Connection" %>
<%@ page import = "mission08.ItemBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
<h2>입력 완료 된 정보</h2>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ItemBean ib = new ItemBean();
	String sql = "select * from item";
	

try {
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "TIGER";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, uid, pass);
	stmt = conn.createStatement();
	
	rs = stmt.executeQuery(sql);
	
	out.println("<table border = '1'>");
	while(rs.next()) {
		ib.setName(rs.getString(1));
		ib.setPrice(rs.getInt(2));
		ib.setDescription(rs.getString(3));
		
		out.println("<tr>");
		out.println("<td>" + ib.getName() + "</td>");
		out.println("<td>" + ib.getPrice() + "</td>");
		out.println("<td>" + ib.getDescription() + "</td>");
		out.println("</tr>");
		
	}
	out.println("</table>");
	} catch (Exception e){
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
</body>
</html>