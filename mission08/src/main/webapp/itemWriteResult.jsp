<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.DriverManager" %>
<%@ page import ="java.sql.PreparedStatement" %>
<%@ page import ="java.sql.Connection" %>
<%@ page import = "mission08.ItemBean" %>
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
	String sql = "insert into item values(?, ?, ?)";
	ItemBean ib = new ItemBean();
	
	ib.setName(request.getParameter("name"));
	ib.setPrice(Integer.parseInt(request.getParameter("price")));
	ib.setDescription(request.getParameter("description"));
	
try { 
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "TIGER";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, uid, pass);
	pstmt = conn.prepareStatement(sql);

	pstmt.setString(1, ib.getName());
	pstmt.setInt(2, ib.getPrice());	
	pstmt.setString(3, ib.getDescription());

	pstmt.executeUpdate();
} catch (Exception e){
	e.printStackTrace();
} finally {
	try {
		if(pstmt != null) {
			pstmt.close();
		}
		if(conn != null) {
			conn.close();
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
}
%>
<a href = "itemWrite.jsp">결과 보기</a>
</body>
</html>