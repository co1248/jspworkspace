<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<form method = "post" action = "requestTest1.jsp">
    <h2>Request 예제입니다.</h2>
    <table border = "1" width = "400">
        <tr>
            <td> 이름 </td>
            <td> <input type = "text" name = "name" size = "20" value = "홍길동"> </td>
        </tr>
        <tr>
            <td> 성별 </td>
            <td> 
                남<input type = "radio" name = "gender" value = "male" checked = "checked"> 
                여<input type = "radio" name = "gender" value = "female" >
            </td>
        </tr>
        <tr>
            <td> 취미 </td>
            <td>
                독서<input type = "checkbox" name = "hobby" value = "독서" checked = "checked">
                게임<input type = "checkbox" name = "hobby" value = "게임" checked = "checked">
                TV시청<input type = "checkbox" name = "hobby" value = "TV시청" checked = "checked">
                축구<input type = "checkbox" name = "hobby" value = "축구">
                기타<input type = "checkbox" name = "hobby" value = "기타">
            </td>
        </tr>
        <tr>
            <td colspan = "2"> <input type = "submit" value = "전송"> </td>    
        </tr>
    </table>
</form>
</body>
</html>