<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%="Hello" %> <!-- 표현식 --><!--  out.print쓰면 스크립트릿-->
    <br>
    ${"Hello" } <!-- 표현언어 -->
    <br>
    ${10 }<br>
    ${7.6 }<br>
    \${5+2 } : ${5+2 }<br>
    \${5/2 } : ${5/2 }<br>
	\${5 div 2 } : ${5 div 2  }<br>
    \${5 mod 2 } : ${5 mod 2 }<br>
    \${5 > 2 } : ${5 > 2 }<br>
    \${5 gt 2 } : ${5 gt 2 }<br>
    \${(5 > 2) ? 5 : 2 } : ${(5 > 2) ? 5 : 2 }<br>
    \${(5 > 2) || (2 < 10) } : ${(5 > 2) || (2 < 10)} <br>
    <%
    String input = null;
    %>
    \${empty input } : ${empty input }<br>
</body>
</html>