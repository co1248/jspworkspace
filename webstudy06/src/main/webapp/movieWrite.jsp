<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" class = "com.mission.javabeans.MovieBean"/>
<jsp:setProperty name="member" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력 완료된 정보</h2>
    <table>
        <tr>
            <td>제목 </td>
            <td><jsp:getProperty name = "member" property = "title" /></td>
        </tr>
        <tr>
            <td>가격 </td>
            <td><jsp:getProperty name = "member" property = "price" />원</td>
        </tr>
        <tr>
            <td>감독 </td>
            <td><jsp:getProperty name = "member" property = "director" /></td>
        </tr>
        <tr>
            <td>출연배우 </td>
            <td><jsp:getProperty name = "member" property = "actor" /></td>
        </tr>
        <tr>
            <td>시놉시스 </td>
            <td><jsp:getProperty name = "member" property = "synopsis" /></td>
        </tr>
        <tr>
            <td>장르 </td>
            <td><jsp:getProperty name = "member" property = "genre" /></td>
        </tr>
    </table>
</body>
</html>