<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    td {
        text-align = "center"
    }
</style>
</head>
<body>
    <form action = "custom.do" method = "post" name = "frm">
        <table align = "center" width = "550">
			<tr>
				<td colspan = "2">사원등록</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "id" ></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pass" ></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td><select name = "lev" >
					<option value = "A" selected="selected">운영자</option>
					<option value = "B">일반회원</option>
				</select></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><select name = "gender">
					<option value = "1" selected="selected">남자</option>
					<option value = "2">여자</option>
				</select></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type = "text" name = "phone"></td>
			</tr>
			<tr>
				<td colspan="2" align = "center">
					<input type="submit" value="등록" >
					<input type="reset" value="취소">
					<input type="button" value="메인 페이지로 이동" onclick = "location.href = 'main.jsp'">
				</td>
			</tr>
        </table>
    </form>
</body>
</html>