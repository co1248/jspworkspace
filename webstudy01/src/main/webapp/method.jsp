<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <form method="get" action="MethodServlet">
        <input type = "submit" value = "get방식의 호출" >
    </form>
    
    <br>
    <a href = "http://localhost:8181/webstudy01/MethodServlet">get방식 호출</a>
    <br>
    
     <form method="post" action="MethodServlet">
        <input type = "submit" value = "post방식의 호출" >
    </form>
</body>
</html>