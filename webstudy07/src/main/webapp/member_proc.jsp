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
<% request.setCharacterEncoding("UTF-8"); %>
<h2>JSTL을 적용한 페이지</h2>
<jsp:useBean id="member" class = "com.saeyan.javabeans.MemberBean"/>
<c:set target = "${member }" property = "name" value = "${param.name }"></c:set>
이름 : ${member.getName() }<br>
<c:set target = "${member }" property = "userid" value = "${param.userid}"></c:set>
아이디 : ${member.userid }<br>
<c:set target = "${member }" property = "pwd" value = "${param.pwd }"></c:set>
비밀번호 : ${member.pwd }<br>
<c:set target = "${member }" property = "email" value = "${param.email }"></c:set>
이메일 : ${member.email }<br>
<c:set target = "${member }" property = "phone" value = "${param.phone }"></c:set>
전화번호 : ${member.phone }<br>
<c:set target = "${member }" property = "admin" value = "${param.admin }"></c:set>
등급 : 
<c:choose>
    <c:when test = "${member.admin == 0}">일반회원 </c:when>
    <c:otherwise>관리자 </c:otherwise>
</c:choose>
</body>
</html>