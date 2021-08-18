<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
<script type = "text/javascript">
    function addboard() {
    	boardform.submit();
    }
</script>
</head>
<body>
	<form name = "boardform" action="./BoardAddAction.bo" method = "post" enctype="multipart/form-data" >
	<table>
			<tr align = "center" walign = "middle">
				<td colspan="5"> MVC게시판</td>
			</tr>
			<tr>
				<td height = "16"><div align = "cender">글쓴이</div></td>
				<td><input type = "text" name = "name" size = "10"></td>
			</tr>
			<tr>
				<td height = "16"><div align = "cender">비밀번호</div></td>
				<td><input type = "password" name = "pass" size = "10"></td>
			</tr>
			<tr>
				<td height = "16"><div align = "cender">제 목</div></td>
				<td><input type="text" name="subject" size="50" ></td>
			</tr>
			<tr>
				<td height = "16"><div align = "cender">내 용</div></td>
				<td><textarea cols = "65" rows = "15" name = "content"></textarea></td>
			</tr>
			<tr>
				<td height = "16"><div align = "cender">파일 첨부</div></td>
				<td><input type="file" name = "uploadFile"></td>
			</tr>
			<tr bgcolor = "cccccc">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr align = "center" walign = "middle">
				<td colspan="5">
					<a href="javascript:addboard()">[등록]</a> &nbsp;&nbsp;&nbsp; 
					<a href="javascript:history.go(-1)">[뒤로]</a>            
				</td>
			</tr>
        </table>
	</form>
</div>
</body>
</html>