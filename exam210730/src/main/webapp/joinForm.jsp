<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src= "member.js"></script>
</head>
<body>
	<form name="frm" action = "joinProcess.jsp" method="post">
		<table border=1>
			<tr>
				<td colspan="2" align="center">
					<b><font size=5>회원가입 페이지</font></b>
				</td>
			</tr>
			<tr>
				<td><lableb for="id">아이디 :</lable> </td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>나이 : </td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>성별 : </td>
				<td>
					<input type="radio" name="gender" value="남">남자
					<input type="radio" name="gender" value="여">여자
				</td>
			</tr>
			<tr>
				<td>이메일 주소 : </td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="#" onclick="return joinCheck()">회원가입</a>
					<a href="javascript:frm.reset()">다시작성</a>
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>