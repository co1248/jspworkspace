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
       //�ڹ� �ڵ带 �ۼ� �� �� �ִ�.
       int num1 = 10;
       int num2 = 20;
       int add = num1 + num2;
    %>
    <%=  num1%> + <%=  num2 %> = <%= add %>
</body>
</html>