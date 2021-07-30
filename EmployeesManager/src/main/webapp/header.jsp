<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 a {
     text-decoration : none;
 }
 td {
     border : 1px solid black;
     width : 200px;
     text-align : center;
 }
 
 .login:hover {
                background-color: pink;
            }
</style>
</head>
<body>
	<table align = "center">
		<tr>
		    <!--로그인 전 화면-->
		    <c:if test = "${empty loginUser }">
			<td></td>
			<td></td>
			<td class="login"><a href = "login.do">로그인</a></td>
			<td style = "width:300px">사원등록<br><span style = "color:red">(관리자로 로그인 후 사용 가능)</span></td>
			<td>마이페이지<br><span style = "color:red">(로그인 후 사용 가능)</span></td>
			</c:if>
			
			<!--로그인 후 화면-->
			<c:if test = "${!empty loginUser }">
			<td>${loginUser.name }님 반갑습니다.</td>
			<td>레벨 : ${loginUser.lev }</td>
			<td  class="login"><a href = "logout.do">로그아웃</a></td>
			<c:choose>
			    <c:when test = "${result == 2 }">
			        <td  class="login"><a href = "custom.do">사원등록</a></td>
			    </c:when>
			    <c:when test = "${result == 3 }">
			        <td style = "width:300px">사원등록<br><span style = "color:red">(관리자로 로그인 후 사용 가능)</span></td>
			    </c:when>
			</c:choose>
			<td  class="login"><a href = "mypage.do">마이페이지</a></td>
			</c:if>
		</tr>
	</table>
</body>
</html>