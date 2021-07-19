<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>
<%
Cookie[] ck = request.getCookies();
String str = null;
if(ck != null) {
		for(Cookie c : ck) {
			str = URLDecoder.decode(c.getValue(), "UTF-8");
		}
	if(str.toString() != "pinksung" ) {
	response.sendRedirect("loginForm.jsp");
	}		
		
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
유료콘텐츠
</body>
</html>