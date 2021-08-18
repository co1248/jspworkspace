<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%--  <%@ page import="java.util.*" %>  --%>
<%@ page import="net.board.db.*" %> 
<%-- <%
List<BoardBean> boardList = (List<BoardBean>)request.getAttribute("boardList");
int listcount = ((Integer)request.getAttribute("listcount")).intValue();
%> --%>
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
<table width= 50% cellpadding = "0" cellspacing = "0">
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
	<tr>
		<td width = "8%" height = "26"><div align = "center">번호</div></td>
		<td width = "50%" height = "26"><div align = "center">제목</div></td>
		<td width = "14%" height = "26"><div align = "center">작성자</div></td>
		<td width = "17%" height = "26"><div align = "center">날짜</div></td>
		<td width = "11%" height = "26"><div align = "center">조회수</div></td>
	</tr>
	<c:forEach var="board" items="${boardlist }">
	<tr>
		<td width = "8%" height = "26">${board.num } </td>
		<td width = "50%" height = "26">
			<a href = "./BoardDetailAction.bo?num=${board.num}">${board.subject}</a>
		</td>
		<td width = "14%" height = "26">${board.name } </td>
		<td width = "17%" height = "26"><fmt:formatDate value = "${board.date}"/></td>
		<td width = "11%" height = "26">${board.readcount } </td>
	</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	<tr>
		<td colspan = "5" style = "border:white; text-align:right" >
			<a href = "./BoardWrite.bo">[글쓰기]</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>