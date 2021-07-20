<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
    fieldset {
		width : 300px;
		margin : 0 auto;
    }
    
    label {
		display : inline-blick;
        width : 70px;
    }
</style>
</head>
<body>

<%
Cookie [] cookies = request.getCookies();

String saveid = "";
String loginChk = "";

if(cookies != null) {
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("id")){
			saveid = cookie.getValue();
			loginChk = "checked='checked'";
			break;
		}
	}
}
%>
<fieldset>
	<legend>로그인</legend>
	<form method = "post" action = "testLogin.jsp">
		<label for = "userid">아이디 :&nbsp; </label>
		<input type = "text" name = "id" id = "userid" value='<%=saveid %>'><br>
		<label for = "userpwd">암 &nbsp; 호 :&nbsp; </label>
		<input type = "password" name = "pwd" id = "userpwd"><br>
		<input type="checkbox" name="loginChk" value="loginChk" <%=loginChk%>>아이디 저장<br>
		<input type = "submit" value = "로그인">
	</form>
</fieldset> 
</body>
</html>