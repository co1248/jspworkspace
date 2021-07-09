<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <%
       //자바 코드를 작성 할 수 있다.
       int num1 = 10;
       int num2 = 20;
       int add = num1 + num2;
    %>
    <%=  num1%> + <%=  num2 %> = <%= add %>
</body>
</html>