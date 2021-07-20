<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%

Cookie[] ck = request.getCookies();
if(ck != null){
    for(Cookie c : ck){
        if(c.getName().equals("username")){
            c.setMaxAge(0);
            response.addCookie(c);
        }
    }
}
%>
<script>
    alert("로그 아웃 되었습니다.");
    location.href = "loginForm.jsp"
</script>
</body>
</html>