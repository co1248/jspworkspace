<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
<link rel = "stylesheet" type = "text/css" href = "css/movie.css">
</head>
<body>
<div id = "wrap" align = "center">
<h1>정보 상세</h1>
<form action = "moviedetail.do" method = "post" >
<table>
	<tr>
		<td>
			<c:choose>
				<c:when test = "${empty member.poster }">
					<img src="images/noimage.gif">
				</c:when>
				<c:otherwise>
					<img src="images/${member.poster }">
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<table>
				<tr>
					<th style = "width:80px">제 목 </th>
					<td>${member.title }</td>
				</tr>
				<tr>
					<th>가 격 </th>
					<td>${member.price }원</td>
				</tr>
				<tr>
					<th>감 독 </th>
					<td>${member.director }원</td>
				</tr>
				<tr>
					<th>배 우 </th>
					<td>${member.actor }원</td>
				</tr>
				<tr>
					<th>시놉시스 </th>
					<td><div style = "height: 220px; width: 100%">${member.synopsis }</div></td>
				</tr>
				<tr>
					<th>사진 </th>
					<td><a href = "moviedown.do?file_name=${member.poster}">${member.poster }</a></td>
					
				</tr>
			</table>
		</td>
	</tr>
</table>
<br>
<input type = "hidden" name = "code" value = "${member.code }">
<input type = "button" value = "글쓰기" onclick = "location.href='moviewrite.do'">
<input type = "button" value = "목록" onclick = "location.href='movielist.do'">
</form>
</div>
</body>
</html>