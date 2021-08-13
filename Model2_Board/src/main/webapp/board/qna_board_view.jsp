<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import="net.board.db.*" %> 
<% BoardBean board = (BoardBean)request.getAttribute("boarddata"); %>
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
	<table  width="500px" >
	    <tr>
	        <td colspan = "2" style = "border:white; text-align:center" >
			    <p>MVC게시판</p>
		    </td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=board.getSubject()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=board.getContent() %></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><%=board.getFile() %></td>
		</tr>
		<tr>
			<td colspan = "2"><a href="./BoardList.bo">[목록]</a></td>
		</tr>
	</table>
</div>
</body>
</html>