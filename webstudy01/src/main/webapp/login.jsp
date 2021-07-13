<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
    String id = (String)session.getAttribute("id"); //세션객체에서 아이디성분을 읽어올 수 있다.
%>
<body>
<%
    if(id == null) {
    	
    
%>
    로그인 해주세요.
<%
	} else {
%>
	<%= id %>님 환영합니다.
<%
    }
%>
	<form action = "login" method = "post">
		아이디 : <input name = "id"><br>
		비밀번호 : <input type = "password" name = "passwd"><br>
		<input type = "submit" value = "로그인">
	</form>
</body>
</html>