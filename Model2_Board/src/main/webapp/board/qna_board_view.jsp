<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.db.*" %> 
<% BoardBean board = (BoardBean)request.getAttribute("boarddata"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
</head>
<body>
	<table width="500px">
	    <tr align = "center" valign = "middle">
	        <td colspan = "5">MVC게시판</td>
		</tr>
		<tr>
			<td height = "16"><div align = "center">제 목&nbsp;&nbsp;</div></td>
			<td height = "16"><%=board.getSubject() %></td>
		</tr>
		<tr bgcolor = "cccccc">
			<td colspan = "2" style = "height : 1px"></td>
		</tr>
		<tr>
			<td height = "250"><div align = "center">내 용&nbsp;&nbsp;</div></td>
			<td height = "250"><%=board.getContent( )%></td>
		</tr>
		<tr>
			<td height = "16"><div align = "center">첨부파일</div></td>
			<td height = "16"><%=board.getFile() %></td>
		</tr>
		<tr bgcolor = "cccccc">
			<td colspan = "2" style = "height : 1px"></td>
		</tr>
		<tr>
			<td colspan = "2">&nbsp;</td>
		</tr>
		<tr align = "center" valign = "middle">
			<td colspan = "5"><a href="./BoardList.bo">[목록]</a></td>
		</tr>
	</table>
</body>
</html>