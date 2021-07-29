package com.magic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			url = "main.jsp";
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String url = null;
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String lev = request.getParameter("lev");
		
		EmployeesDAO empDao = EmployeesDAO.getInstance();
		int result = empDao.userCheck(id, pass, lev);
        
		if(result == 2 || result ==3) {
			EmployeesVO empVo = new EmployeesVO();
			empVo = empDao.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", empVo);
			session.setAttribute("result",result);
			url = "main.jsp";
		} else {
			if(result == 0) {
				request.setAttribute("message","비밀번호 맞지 않습니다.");
			} else if(result == 1) {
				request.setAttribute("message","레벨 불일치 로그인 실패");
			} else {
				request.setAttribute("message","존재하지 않는 회원입니다.");
			}
			url = "login.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

