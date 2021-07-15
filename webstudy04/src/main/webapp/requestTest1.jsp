<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
    
    <h2>Request 예제입니다.</h2>
    <table border = "1" width = "400">
        <tr>
            <td> 이름 </td>
            <td> <%= request.getParameter("name") %> </td>
        </tr>
        <tr>
            <td> 성별 </td>
            <td> 
                <%if(request.getParameter("gender").equals("male")) { %> 남자 <%} else {%> 여자 <%} %>
            </td>
        </tr>
        <tr>
            <td> 취미 </td>
            <td>
                <%
                String hob[] = request.getParameterValues("hobby");
                if(hob == null) {
        			out.print("선택항목없음");
        		} else {
        			for(String hobby : hob) {  
        				out.print(hobby+ " ");
        			}
        		}
                %>
            </td>
        </tr>
    </table>
</form>
</body>
</html>