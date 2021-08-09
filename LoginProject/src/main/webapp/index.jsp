<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String id = (String)session.getAttribute("id");
	if(id != null) {%>
		<p><%=id %>님 로그인 하셨습니다.</p>
		<a href = "logout" >로그아웃</a>
	<% } else {%>
		<a href = "loginForm.html" >로그인</a>
	<%}%>
</body>
</html>