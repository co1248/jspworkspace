<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="board" class = "net.board.db.BoardBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
</head>
<body>
	<form name = "frm" action="./BoardAddAction.bo" method = "post" enctype="multipart/form-data" >
	<table>
			<tr>
				<td colspan="2"> MVC게시판</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type = "name" name = "name"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pass"></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="subject" size="50" ></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea cols = "70" rows = "15" name = "content"></textarea></td>
			</tr>
			<tr>
				<th>파일 첨부</th>
				<td><input  name = "uploadFile" type="file"></td>
			</tr>
			<tr>
		<td colspan="5">
            <a href="javascript:document.frm.submit();">[등록]</a> &nbsp;&nbsp;   
            <a href="BoardList.bo">[뒤로]</a>            
        </td>
        </tr>
        </table>
	</form>
</div>
</body>
</html>