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
<h1>리스트</h1>
<table class = "list">
	<tr>
		<td colspan = "6" style = "border:white; text-align:right" >
			<a href = "moviewrite.do">정보등록</a>
		</td>
	</tr>
	<tr><th>제목</th><th>감독</th><th>배우</th><th>가격</th><th>파일</th><th>수정</th><th>삭제</th></tr>
	<c:forEach var="member" items="${movielist}">
	<tr class = "record">
		<td>
		    <a href = "moviedetail.do?code=${member.code}">${member.title }</a>
		</td>
		<td>${member.director } </td>
		<td>${member.actor } </td>
		<td>${member.price } 원 </td>
		<td align = "center"><a  class="thumb" href = "moviedown.do?file_name=${member.poster}"><img src="images/${member.poster }" style = "width:20px; height:20px; "></a></td>
		<td>
			<a href = "movieupdate.do?code=${member.code}">정보 수정</a>
		</td>
		<td>
			<a href = "moviedelete.do?code=${member.code}">정보 삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>