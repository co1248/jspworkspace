<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;
	String sql = "select empno, ename, e.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno";

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
		while(rs.next()) { //정보 가져오기
			out.print("<tr>");
				out.print("<td>");
				out.print(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(3));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}catch(Exception e){
		out.print("<h3>데이터 조회에 실패하였습니다. </h3>");
		e.printStackTrace();
	} finally {
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