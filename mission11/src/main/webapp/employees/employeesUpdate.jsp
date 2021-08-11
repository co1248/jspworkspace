<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<link rel = "stylesheet" type = "text/css" href = "css/shopping.css">
<script type="text/javascript" src = "script/employees.js"></script>
</head>
<body>
<div id = "wrap" align = "center">
	<h1>정보 수정</h1>
	<form name = "frm" method = "post" action = "EmployeesServlet">
		<input type = "hidden" name = "command" value = "employees_update">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type = "text" name = "id" value = "${employees.id}" readonly></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pass" value = "${employees.pass}" ></td>
			</tr>
		    <tr>
				<th>이름</th>
				<td><input type = "text" name = "name" value = "${employees.name}" ></td>
			</tr>
			<tr>
				<th>권한</th>
				<td><select name = "lev">
				    <c:choose>
				        <c:when test="${employees.lev == 'A'}">
							<option value = "A" selected>운영자</option>
							<option value = "B">일반회원</option>
					     </c:when>
					     <c:otherwise>
							 <option value = "A">운영자</option>
							 <option value = "B" selected>일반회원</option>
					     </c:otherwise>
					 </c:choose>
				</select></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><select name = "gender">
				    <c:choose>
				        <c:when test="${employees.gender == '1'}">
							<option value = "1" selected>남자</option>
							<option value = "2">여자</option>
					     </c:when>
					     <c:otherwise>
							<option value = "1">남자</option>
							<option value = "2" selected>여자</option>
					     </c:otherwise>
					 </c:choose>
				</select></td>
			<tr>
				<th>전화번호</th>
				<td><input type = "text" name = "phone" value = "${employees.phone}" ></td>
			</tr>
		</table>
		<br><br>
		<input type = "submit" value = "확인" onclick = "return employeesCheck()">
		<input type = "reset" value = "취소">
		<input type = "button" value = "목록" onclick = "location.href='EmployeesServlet?command=employees_list'">
	</form>
</div>
</body>
</html>