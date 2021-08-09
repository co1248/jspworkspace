package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import svc.LoginService;
import vo.MemberVO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//입력으로 넘어온 데이터에 대한 한글처리
		response.setContentType("text/html;charset=UTF-8");//페이지에서 보여주는 영역에 대한 한글처리
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		LoginService loginService = new LoginService();
		MemberVO loginMember = loginService.getLoginMember(id, passwd);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("index.jsp");
		}else {
			PrintWriter out = response.getWriter();
			 out.println("<script>");
	         out.println("alert('로그인실패')");
	         out.println("history.back()");
	         out.println("</script>");
		}
	}
}

