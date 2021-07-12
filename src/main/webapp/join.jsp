<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
   <form method = "get" action="JoinServlet">
       <label for = "name">이름</label>
	   <input type="text" name="name" value = "성윤정" required><br>
	   <label for = "no">주민등록번호</label>
	   <input type="text" name="no" value = "890719" required>-<input type="text" name="no2" value = "2012123"><br>
	   
	   아이디 <input type="text" name="id" value = "pinksung" required><br>
	   비밀번호 <input type="password" name="pw" value = "1234" required><br>
	   비밀번호 확인 <input type="password" name="pw2" value = "1234" required><br>
	   이메일 <input type="text" name="email" value = "pinksung">@ <input type="text" name="email2">
	   <select id = "email3" name = "email3">
		   <option value="nate.com" selected>nate.com</option>
		   <option value="naver.com">naver.com</option>
		   <option value="gmail.com">gmail.com</option>
	   </select><br>
	   우편번호 <input type="text" name="postNo" value = "321-212"><br>
       주소 <input type="text" name="add" value = "서울시 송파구 잠실2동"><input type="text" name="add2" value = "엘스 아파트 201동 1203호"><br>
       핸드폰번호 <input type="tel" name="phone" value = "010-2321-2312"><br>
       직업 
		<select id = "job" name = "job" size = "3" multiple = "multiple">
			<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
			<option value="언론">언론</option>
			<option value="공무원" selected>공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
			<option value="교육">교육</option>
		</select> <br>
		메일/SMS정보 수신 
		<input type = "radio" id= "chk_nail" name = "chk_nail" value= "yes" checked>수신
		<input type = "radio" id= "chk_nail" name = "chk_nail" value= "no">거부<br>
		관심분야 
		<input type = "checkbox" name = interest" value = "생두">생두
		<input type = "checkbox" name = "interest" value = "원두" checked>원두
		<input type = "checkbox" name = "interest" value = "로스팅">로스팅
		<input type = "checkbox" name = "interest" value = "핸드드립" checked>핸드드립
		<input type = "checkbox" name = "interest" value = "에스프레소" checked>에스프레소
		<input type = "checkbox" name = "interest" value = "창업">창업<br>
		<input type = "submit" value="회원가입"> <input type = "reset" value="취소">
   </form>
</body>
</html>