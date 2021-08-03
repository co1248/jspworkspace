package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/custom.do")
public class CustomJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션객체가 있다면 반환된다.
		EmployeesVO emp = (EmployeesVO)session.getAttribute("loginUser");
		int result = (Integer)session.getAttribute("result");
		if(emp != null && result == 2) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("customjoin.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		EmployeesVO empVo = new EmployeesVO();
		empVo.setId(request.getParameter("id"));
		empVo.setPass(request.getParameter("pass"));
		empVo.setName(request.getParameter("name"));
		empVo.setLev(request.getParameter("lev"));
		empVo.setGender(Integer.parseInt(request.getParameter("gender")));
		empVo.setPhone(request.getParameter("phone"));
		
		EmployeesDAO empDao = EmployeesDAO.getInstance();
		empDao.insertMember(empVo);
	
		
		request.setAttribute("empVo", empVo);
		request.setAttribute("message", "회원 등록에 성공했습니다.");
		
		//HttpSession session = request.getSession();
		
		//EmployeesVO emp = empDao.getMember(empVo.getId());
		//session.setAttribute("loginUSer", emp); //헤더에서 쓸 정보
		
		//int result = empDao.userCheck(empVo.getId(), empVo.getPass(), empVo.getLev());
		//session.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("joinsuccess.jsp");
		dispatcher.forward(request, response);
	}

}
