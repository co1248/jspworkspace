<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
<style>
	td {
		text-align : center;
	}
</style>
</head>
<body>
<div id = "wrap" align = "center">
<table width="500px">
    <tr>
		<td colspan = "4" style = "border:white; text-align:center" >
			<p>MVC게시판</p>
		</td>
		    <c:choose>
		        <c:when test = "${listcount == 0}">
						<td>
		              <p>등록된 글이 없습니다.</p>
		              </td>
		 	</c:when>
		 	<c:otherwise>
		 <td>
		   </p>글 개수 :  ${listcount}</p>
		</td>
	</tr>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th></tr>
	<c:forEach var="board" items="${boardlist }">
	<tr>
		<td>${board.num } </td>
		<td>
			<a href = "./BoardDetailAction.bo?num=${board.num}">${board.subject}</a>
		</td>
		<td>${board.name } </td>
		<td><fmt:formatDate value = "${board.date}"/></td>
		<td>${board.readcount } </td>
	</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	<tr>
		<td colspan = "5" style = "border:white; text-align:right" >
			<a href = "BoardWrite.bo">[글쓰기]</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>