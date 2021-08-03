package com.magic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/list.do")
public class ListServlet<empVo> extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션객체가 있다면 반환된다.
		EmployeesVO emp = (EmployeesVO)session.getAttribute("loginUser");
		int result = (Integer)session.getAttribute("result");
		if(emp != null && result == 2) {
			EmployeesDAO empDao = EmployeesDAO.getInstance();
			ArrayList<EmployeesVO> list = empDao.getListAll();
			request.setAttribute("list", list);
			request.setAttribute("message", "사원 정보 조회 성공");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);;
		} else {
			response.sendRedirect("login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}
}
