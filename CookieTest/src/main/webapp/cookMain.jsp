<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String language = "korea";
String cookie = request.getHeader("Cookie");
if(cookie != null) {
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies) {
		if(c.getName().equals("language")) {
			language = c.getValue();
		}
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
<% if(language.equals("korea")) { %>
<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>
<% } else {%>
<h3>Hello. This is Cookie example.</h3>
<%} %>
<form action = "cookieExanple2.jsp" method = "post">
	<input type = "radio" name = "language" value = "korea" <%if(language.equals("korea")) { %>checked <%} %> >한국어 페이지 보기
	<input type = "radio" name = "language" value = "english" <%if(language.equals("english")) { %>checked <%} %> >영어 페이지 보기
	<input type = "submit" value = "설정">
</form>
</body>
</html>