<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
    int age = Integer.parseInt(request.getParameter("age"));
    if(age <= 19) {
%>   
<script>
	alert("19세 미만 입장 불가")
</script>
<% } else {
	request.setAttribute("name", "홍길동");
	RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
	dispatcher.forward(request, response);
   }
%>
</head>
<body>

</body>
</html>