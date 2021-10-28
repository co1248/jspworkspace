package com.rail.controller.action.user;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.dto.MemberVO;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;
public class showPwdFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/find_pwd.jsp"; //비밀번호 찾기 페이지로 이동
		
		int result = 0;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		MemberDAO mdao = MemberDAO.getInstance();

		// 아이디 이름으로 회원정보 있는지 먼저 판단
		MemberVO mvo = mdao.findPwd(id, name);

		// 아이디, 이름과 일치하는 회원이 있는지 확인
		if (mvo != null) {
			result = 1; //회원있음
			System.out.println(result);
			String email = mvo.getEmail();
			request.setAttribute("email", email); 
		} else {
			result = 0; //회원없음
			System.out.println(result);
		}
		
		request.setAttribute("result", result);
		request.setAttribute("id", id); //아이디값 저장
		request.setAttribute("name", name); //비번값 저장
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
		
//		//mail server 설정
//		
//		String host = "smtp.naver.com";
//		String user = "rkdms0316@naver.com";
//		String password = "dkssud5119!";
//		Properties props = new Properties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", 465);
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.ssl.enable", "true"); 
//		props.put("mail.smtp.ssl.trust", "smtp.naver.com");
//
//		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(user, password);
//			}
//		});
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(user));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress("메일주소"));
//			message.setSubject("[테스트]메일제목");
//			message.setText("테스트 입니다.");
//			Transport.send(message);
//			System.out.println("Success Message Send");
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
//		String user = "rkdms0316@naver.com"; // 자신의 네이버 계정
//		String password = "dkssud5119!";// 자신의 네이버 패스워드
//
//		// 메일 받을 주소
//		/* String to_email = m.getEmail(); */
//		String to_email = "rkdms0316@naver.com";
//
//		// SMTP 서버 정보를 설정한다.
//		Properties props = new Properties();
////		props.put("mail.smtp.starttls.enable", "true");     // gmail은 무조건 true 고정
////		props.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 주소
////		props.put("mail.smtp.auth","true");                 // gmail은 무조건 true 고정
////		props.put("mail.smtp.port", "587");                 // gmail 포트
//	    
//	    
//	    
//	    props.put("mail.smtp.host", "rkdms0316@naver.com");
//	    props.put("mail.smtp.port", 465);
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.ssl.enable", "true");
//	    
//	    
//	    
//	    //인증 번호 생성기
//	    StringBuffer temp =new StringBuffer();
//	    Random rnd = new Random();
//	    for(int i=0;i<10;i++)
//	    {
//	        int rIndex = rnd.nextInt(3);
//	        switch (rIndex) {
//	        case 0:
//	            // a-z
//	            temp.append((char) ((int) (rnd.nextInt(26)) + 97));
//	            break;
//	        case 1:
//	            // A-Z
//	            temp.append((char) ((int) (rnd.nextInt(26)) + 65));
//	            break;
//	        case 2:
//	            // 0-9
//	            temp.append((rnd.nextInt(10)));
//	            break;
//	        }
//	    }
//	    String AuthenticationKey = temp.toString();
//	    System.out.println(AuthenticationKey);
//	    
//	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//	        protected PasswordAuthentication getPasswordAuthentication() {
//	            return new PasswordAuthentication(user,password);
//	        }
//	    });
//	    
//	    //email 전송
//	    try {
//	        MimeMessage msg = new MimeMessage(session);
//	        msg.setFrom(new InternetAddress(user, "KH Books"));
//	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
//	        
//	        //메일 제목
//	        msg.setSubject("안녕하세요! 인증 메일입니다.");
//	        //메일 내용
//	        msg.setText("인증 번호는 :"+temp);
//	        
//	        Transport.send(msg);
//	        System.out.println("이메일 전송");
//	        
//	    }catch (Exception e) {
//	        e.printStackTrace();// TODO: handle exception
//	    }
//	    HttpSession saveKey = request.getSession();
//	    saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
//	    //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
//	    request.setAttribute("id", id);
//	    request.getRequestDispatcher("member/show_pwd.jsp").forward(request, response);
//	}

}
