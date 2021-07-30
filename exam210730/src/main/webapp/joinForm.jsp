<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="member.js"></script>
</head>
<body>
<form action = "joinProcess.jsp" name = "frm">
 <table border = "1" align = "center">
   <tr>
   <td colspan="2" align="center"><h1>회원가입 페이지</h1></td>
  </tr>
  <tr>
   <td>아이디:   </td>
   <td><input type = "text" name = "id" size = "20"></td>
  </tr>
  <tr>
   <td>비밀번호:   </td>
   <td><input type = "password" name = "password" size = "20"></td>
  </tr>
  <tr>
   <td>이름:    </td>
   <td><input type = "text" name = "name" size = "20"></td>
  </tr> 
  <tr>
   <td>나이:    </td>
   <td><input type = "text" name = "age" size = "5"></td>
  </tr> 
  <tr>
   <td>성별:   </td>
   <td>
    <input type = "radio" name = "gender" value = "1" checked = "checked"> 남자
    <input type = "radio" name = "gender" value = "2"> 여자
   </td>  
  </tr> 
  <tr>
   <td>이메일  </td>
   <td><input type = "text" name = "email" size = "30"></td>
  </tr>
  <tr>
   <td colspan="2" align="center">
     <input type = "submit"  value = "회원가입" onclick="return joinCheck()">
     <input type = "reset"  value = "다시작성">
   </td>
  </tr>
 </table>
</form>
</body>
</html>