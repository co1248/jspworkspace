<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align = "center" width = "550">
		<tr>
			<td colspan = "2" align = "center" >
				<h3>사원 정보</h3>
				<div style = "color:red">${message }</div>
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${empVo.id }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${empVo.pass }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${empVo.name }</td>
		</tr>
		<tr>
			<td>권한</td>
			<td><c:choose>
			    <c:when test = '${empVo.lev == "A" }'>운영자</c:when>
			    <c:otherwise>일반회원</c:otherwise>			
			</c:choose></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><c:choose>
			    <c:when test = '${empVo.gender == "1" }'>남자</c:when>
			    <c:otherwise>여자</c:otherwise>			
			</c:choose></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${empVo.phone }</td>
		</tr>
		<tr>
			<td colspan="2" align = "center">
				<input type="button" value="메인 페이지로 이동" onclick = "location.href = 'main.jsp'">
			</td>
		</tr>
	</table>
</body>
</html>