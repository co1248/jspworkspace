<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String lang = request.getParameter("language");

	Cookie cookie = new Cookie("language", lang);
	cookie.setMaxAge(60*60);
	response.addCookie(cookie);
%>
<script>
    location.href = "cookMain.jsp";
</script>