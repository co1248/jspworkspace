<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="join" class = "com.human2.JoinBean"/>
<jsp:setProperty name="join" property="*"/>

<table>
	<tr>
		<td>아이디: </td>
		<td><jsp:getProperty name = "join" property = "userid" /></td>
	</tr>
	<tr>
		<td>비밀번호: </td>
		<td><jsp:getProperty name = "join" property = "pwd" /></td>
	</tr>
	<tr>
		<td>이름: </td>
		<td><jsp:getProperty name = "join" property = "name" /></td>
	</tr>
	
	<tr>
		<td>성별: </td>
		<td><jsp:getProperty name = "join" property = "gender" /></td>
	</tr>
	<tr>
		<td>나이: </td>
		<td><jsp:getProperty name = "join" property = "age" /></td>
	</tr>
	<tr>
		<td>이메일주소: </td>
		<td><jsp:getProperty name = "join" property = "email" /></td>
	</tr>	
</table>
</body>
</html>