<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test='${param.loginCheck == "user"}'>
<c:set var = "userid" value = "${param.userid}" scope = "request" ></c:set>
<c:redirect url = "userMain.jsp?userid=${param.userid} "></c:redirect>
</c:if>
<c:if test = '${param.loginCheck == "manager"}'>
<c:set var = "userid" value = "${param.userid}" scope = "request" ></c:set>
<c:redirect url = "managerMain.jsp?userid=${param.userid}"></c:redirect>
</c:if>
</body>
</html>