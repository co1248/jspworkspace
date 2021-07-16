<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String name = request.getParameter("name");
    String address = request.getParameter("address");
    String tel = request.getParameter("tel");
    String hobby = request.getParameter("hobby");

	if(name != null){
		out.print(name + "님의 주소는 " + address + ", 전화번호는 " + tel + ", 취미는 " + hobby + "입니다.");
	}else{
%>
<form action="./template.jsp" method="get">
    <h1>회원가입</h1>
    <label for = "name">회원명 : </label>
    <input name = "name" id = "name"><br>
    <label for = "address">주소 : </label>
    <input name = "address" id = "address"><br>
    <label for = "tel">전화번호 : </label>
    <input type = "tel" name = "tel" id = "tel"><br>
    <label for = "hobby">취미 : </label>
    <input name = "hobby" id = "hobby"><br>
    <input type = "hidden" name = "page" value = "join">
    <input type = "submit" value = "회원가입">
</form>

<%}%>