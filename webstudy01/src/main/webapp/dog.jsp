<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>당신이 좋아하는 강아지를 선택 하세요.</h1>
	<form method ="post" action = "ChoiceDogServlet">
		<input type = "checkbox" name = "dog" value = "pu">푸들
		<input type = "checkbox" name = "dog" value = "jin">진돗개
		<input type = "checkbox" name = "dog" value = "pung">풍산개
		<input type = "checkbox" name = "dog" value = "sap">삽살개
		<input type = "submit" value = "선택">
	</form>
</body>
</html>