package com.saeyan.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/moviedetail.do")
public class moviedetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectMemberByCode(code);	
		
		request.setAttribute("member", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/moviedetail.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.deleteMember(code);			
		
		response.sendRedirect("movielist.do");	
	}
}
