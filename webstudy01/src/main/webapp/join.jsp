<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style type="text/css">
        label {
            width : 160px;
            display : inline-block;
            float : left
        }
        
        #button {
            text-align : center;
        }
    </style>
    <script type="text/javascript" src = "join.js" charset="utf-8">
    </script>
</head>
<body>	
   <form name = "frm" id = "reg_frm" action="JoinServlet">
       <label for = "name">이름</label><span style = "color:red;">*</span>
	   <input type="text" name="name" value = "성윤정" required><br>
	   
	   <label>주민등록번호</label><span style = "color:red;">*</span>
	   <input type="text" name="jumin_1" value = "890719" required>-
	   <input type="text" name="jumin_2" value = "2012123" required><br>
	   
	   <label for = "id">아이디</label><span style = "color:red;">*</span>
	   <input type="text" name="id" value = "pinksung" required><br>
	   
	   <label for = "pwd">비밀번호</label><span style = "color:red;">*</span>
	   <input type="password" name="pwd" value = "1234" required><br>
	   
	   <label for = "pwd_re">비밀번호 확인</label><span style = "color:red;">*</span>
	   <input type="password" name="pwd_re" value = "1234" required><br>
	   
	   <label for = "email">이메일</label>&nbsp;
	   <input type="text" name="email" value = "pinksung">@ <input type="text" name="email_dns" value = "">
	   <select name = "emailaddr">
	       <option value="">직접입력</option>
	       <option value="nate.com" selected>nate.com</option>
		   <option value="daum.net">daum.net</option>
		   <option value="gmail.com">gmail.com</option>
		   <option value="naver.com">naver.com</option>
	   </select><br>
	   
	   <label for = "zip">우편번호</label>&nbsp;
	   <input type="text" id = "zip" name="zip" value = "321-212"><br>
	   
       <label for = "addr1">주소</label>&nbsp;
       <input type="text" id = "addr1" name="addr1" value = "서울시 송파구 잠실2동">
       <input type="text" id = "addr2" name="addr2" value = "엘스 아파트 201동 1203호"><br>
       
       <label for = "phone">핸드폰번호</label>&nbsp;
       <input type="tel" id = "phone" name="phone" value = "010-2321-2312"><br>
       
       <label for = "job">직업</label>&nbsp;
	   <select id = "job" name = "job" size = "3" multiple>
		    <option value="학생">학생</option>
			<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
			<option value="언론">언론</option>
			<option value="공무원" selected>공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
			<option value="교육">교육</option>
		</select><br>
		
		<label for = "chk_nail">메일/SMS 정보 수신</label>&nbsp;
		<input type = "radio" id= "chk_nail" name = "chk_nail" value= "yes" checked>수신
		<input type = "radio" id= "chk_nail" name = "chk_nail" value= "no">거부<br>
		
		<label for = "interest">관심분야</label>&nbsp;
		<input type = "checkbox" id= "interest" name = "interest" value = "생두">생두
		<input type = "checkbox" id= "interest" name = "interest" value = "원두" checked>원두
		<input type = "checkbox" id= "interest" name = "interest" value = "로스팅">로스팅
		<input type = "checkbox" id= "interest" name = "interest" value = "핸드드립" checked>핸드드립
		<input type = "checkbox" id= "interest" name = "interest" value = "에스프레소" checked>에스프레소
		<input type = "checkbox" id= "interest" name = "interest" value = "창업">창업<br><br>
		
		<div id = "button">
			<input type = "submit" value="회원가입" onclick = "return check();">
			<input type = "reset" value="취소">
		</div>
   </form>
</body>
</html>