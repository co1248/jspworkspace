<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from student";
	ResultSetMetaData rsmd = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
		conn = ds.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rsmd = rs.getMetaData();
			
		out.print("컬럼 수 : " + rsmd.getColumnCount()+ "<br>");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			out.print(i + "번째 컬럼명 :" + rsmd.getColumnName(i) + ", ");
			out.print(i + "번째 컬럼타입 :" + rsmd.getColumnTypeName(i) + "<br>");
		}
	
	}catch(Exception e){
		out.print("<h3>데이터 가져오기 실패</h3>");
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