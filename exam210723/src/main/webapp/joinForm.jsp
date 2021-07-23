<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form  method = "post" action = "joinChk.jsp">
    <Fieldset   style="width : 300px; margin : 15px;">
        <h2 align= "center">회원정보 입력</h2><br>
        <table align= "center" >
            <tr>
                <td>아이디:</td>
                <td><input type = "text" name = "userid"></td>
            </tr>
            <tr>
                <td>비밀번호:</td>
                <td><input type = "password" name = "pwd"></td>
            </tr>
            <tr>
                <td>이름:</td>
                <td><input type = "text" name = "name"></td>
            </tr>
            <tr>
                <td>성별:</td>
                <td align="center">
                    <input type = "radio" name = "gender" value = "1" checked>남
                    <input type = "radio" name = "gender" value = "2">여
                </td>
            </tr>
            <tr>
                <td>나이:</td>
                <td><input type = "text" name = "age"></td>
            </tr>
            <tr>
                <td>이메일주소:</td>
                <td><input type = "text" name = "email"></td>
            </tr>
            <tr>
                <td  align="right" ><input type = "submit" value = "가입"></td>
                <td  align="left" ><input type = "reset" value = "다시작성"></td>
            </tr>
        </table>
    </Fieldset>
    </form>
</body>
</html>