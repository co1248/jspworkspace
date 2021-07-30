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

@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesVO emp = (EmployeesVO)session.getAttribute("loginUser");
		if(emp != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("mypage.jsp");
			dispatcher.forward(request, response);
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
		empDao.updateMember(empVo);
	
		HttpSession session = request.getSession();
		request.setAttribute("empVo", empVo);
		request.setAttribute("message", "회원 정보가 수정되었습니다.");
		
		EmployeesVO emp = empDao.getMember(empVo.getId());
		session.setAttribute("loginUSer", emp); //헤더에서 쓸 정보
		
		int result = empDao.userCheck(empVo.getId(), empVo.getPass(), empVo.getLev());
		session.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("joinsuccess.jsp");
		dispatcher.forward(request, response);
	}
}
