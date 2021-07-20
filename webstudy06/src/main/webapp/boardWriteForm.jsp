<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action="boardWrite.jsp">
    <h2>게시판 글쓰기</h2>
    <table>
        <tr>
            <td>작성자 </td>
            <td><input type = "text" name = "name" size = "20"></td>
        </tr>
        <tr>
            <td>비밀번호 </td>
            <td><input type = "password" name = "pass" size = "20">(게시물 수정 삭제시 필요합니다.)</td>
        </tr>
        <tr>
            <td>이메일 </td>
            <td><input type = "text" name = "email" size = "40"></td>
        </tr>
        <tr>
            <td>글 제목 </td>
            <td><input type = "text" name = "title" size = "60"></td>
        </tr>
        <tr>
            <td>글 내용 </td>
            <td><input type = "text" name = "content" size = "70" height="300"></td>
        </tr>
        
        <tr>
            <td><input type = "submit" value = "등록"></td>
            <td><input type = "reset" value = "다시작성"></td>
        </tr>
    </table>
</form>
</body>
</html>