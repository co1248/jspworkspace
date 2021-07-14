<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    int num = 123456789;
    public int reverse() {
    	int reverse = 0;
		while(num !=0){
			reverse = reverse * 10 + num % 10;
			num /= 10;
        }
		return reverse;
	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% out.print(num + "의 리버스 값은 " + reverse()); %>
</body>
</html>