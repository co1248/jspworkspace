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
	String sql = request.getParameter("sql");
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oracleDB");
		conn = ds.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		
		if(sql.startsWith("select")){
			rs = pstmt.executeQuery(); //결과받기
			rsmd = rs.getMetaData(); //메타정보
	
			out.print("<table border = '1'>");
			out.print("<tr>");
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				out.print("<td>");
				out.print(rsmd.getColumnName(i));
				out.print("</td>");
			}
			out.print("</tr>");
		
			while(rs.next()){ //rs.next()읽어올 레코드가 있으면 true
				out.print("<tr>");
				for (int i = 1; i <= rsmd.getColumnCount(); i++)  {
					out.print("<td>");
					
					if(rsmd.getColumnTypeName(i) == "NUMBER") {
						out.print(rs.getInt(i));
					} else if (rsmd.getColumnTypeName(i) == "VARCHAR2") {
						out.print(rs.getString(i));
					} else if (rsmd.getColumnTypeName(i) == "CHAR") {
						out.print(rs.getString(i));
					}else  {
						out.print(rs.getDate(i));
					}
					out.print("</td>");
				}
				out.print("</tr>");
			}
			out.print("</table>");
		}else if(sql.startsWith("delete")){
			int result = pstmt.executeUpdate();
			if(result != 0) {
				out.print("데어트 삭제 성공");
			}
		} else if(sql.startsWith("insert")){
			int result = pstmt.executeUpdate();
			if(result != 0) {
				out.print("데이터 삽입 성공");
			}
		} else if(sql.startsWith("update")){
			int result = pstmt.executeUpdate();
			if(result != 0) {
				out.print("데이터 수정 성공");
			}
		} else { 
			out.print("오류입니다.");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		try {
			if(rs != null) {
				rs.close();
			}
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