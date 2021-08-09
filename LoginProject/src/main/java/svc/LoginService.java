package svc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.coyote.Request;

import dao.LoginDAO;
import vo.MemberVO;

public class LoginService {
	
	public MemberVO getLoginMember(String id, String passwd) {
		LoginDAO loginDao = LoginDAO.getInstance();
		MemberVO loginMember = loginDao.selectLoginMember(id, passwd);
		
		return loginMember;
	}
}
