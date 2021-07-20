<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" class = "com.mission.javabeans.ItemBean"/>
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
            <td>상품명 </td>
            <td><jsp:getProperty name = "member" property = "name" /></td>
        </tr>
        <tr>
            <td>가격 </td>
            <td><jsp:getProperty name = "member" property = "price" /></td>
        </tr>
        <tr>
            <td>설명 </td>
            <td><jsp:getProperty name = "member" property = "description" /></td>
        </tr>
    </table>
</body>
</html>