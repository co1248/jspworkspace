<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<%
//실제로는 DB에서 가져와야하는 값
String id = "pinksung";
String pwd = "1234";
String name = "성윤정";

if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ) {
	Cookie c = new Cookie("username", URLEncoder.encode(name, "UTF-8"));
	c.setMaxAge(60*60);
	response.addCookie(c);
	Cookie c2 = new Cookie("id", URLEncoder.encode(id, "UTF-8"));
	c2.setMaxAge(60*60);
	response.addCookie(c2);
%>
<h2>성공적으로 로그인하셨습니다.</h2>
<p><a href = "main.jsp">들어가기</a>
<%
} else {
%>
<h2>로그인에 실패했습니다.</h2>
<p><a href = "loginForm.jsp">되돌아가기</a>
<%
}
%>