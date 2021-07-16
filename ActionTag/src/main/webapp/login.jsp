<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

	if(id != null){
		out.print(id + "님 로그인 하셨습니다.");
	}else{
%>
<h1>로그인</h1>
<form action="./template.jsp" method="get">
	아이디 : <input type="text" name="id"/><br>
	비밀번호 : <input type="text" name="passwd"><br>
	<input type = "hidden" name = "page" value = "login">
	<input type = "submit" value="로그인"/>
</form>

<%}%>