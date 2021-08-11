<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 관리</title>
<link rel = "stylesheet" type = "text/css" href = "css/shopping.css">
</head>
<body>
<div id = "wrap" align = "center">
<h1>리스트</h1>
<table class = "list">
	<tr>
		<td colspan = "5" style = "border:white; text-align:right" >
			<a href = "EmployeesServlet?command=employees_write_form">정보등록</a>
		</td>
	</tr>
	<tr><th>아이디</th><th>이름</th><th>권한</th><th>성별</th><th>전화번호</th></tr>
	<c:forEach var="employees" items="${employeesList }">
	<tr class = "record">
		<td>${employees.id } </td>
		<td>
			<a href = "EmployeesServlet?command=employees_view&id=${employees.id}">${employees.name}</a>
		</td>
		<td><c:choose>
			<c:when test = "${employees.lev == 'A'}">운영자</c:when>
		    <c:otherwise>일반회원</c:otherwise>
		</c:choose></td>
		<td><c:choose>
			<c:when test = "${employees.gender == '1'}">남자</c:when>
		    <c:otherwise>여자</c:otherwise>
		</c:choose></td>
		<td>${employees.phone } </td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>