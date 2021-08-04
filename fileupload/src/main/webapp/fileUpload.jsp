<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import ="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import ="java.util.Enumeration" %>
<%
String savePath = "upload";
int uploadFileSizeLimit = 5*1024*1024;
String encType = "UTF-8";
String uploadFilePath = request.getRealPath("/upload");

String name = "";
String subject = "";
String filename1 = "";
String filename2 = "";
String origfilename1 = "";
String origfilename2 = "";

try {
	MultipartRequest multi = new MultipartRequest (
			request, //request객체
			uploadFilePath,//서버상의 실제 디렉토리
			uploadFileSizeLimit,//최대 업로드 파일 크기
			encType,//인코딩 방법
			new DefaultFileRenamePolicy());
	
	name = multi.getParameter("name");
	subject = multi.getParameter("subject");
	
	Enumeration files = multi.getFileNames();
	
	String file1 = (String)files.nextElement();
	filename1 = multi.getFilesystemName(file1);
	origfilename1 = multi.getOriginalFileName(file1);
	String file2 = (String)files.nextElement();
	filename2 = multi.getFilesystemName(file2);
	origfilename2 = multi.getOriginalFileName(file2);
	
} catch (Exception e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name = "filecheck" action = "filecheck.jsp" method = "post">
    <input type = "hidden" name = "name" value = <%=name %>>
    <input type = "hidden" name = "subject" value = <%=subject %>>
    <input type = "hidden" name = "filename1" value = <%=filename1 %>>
    <input type = "hidden" name = "filename2" value = <%=filename2 %>>
    <input type = "hidden" name = "origfilename1" value = <%=origfilename1 %>>
    <input type = "hidden" name = "origfilename2" value = <%=origfilename2 %>>
</form>
<a href = "#" onclick = "javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
</body>
</html>