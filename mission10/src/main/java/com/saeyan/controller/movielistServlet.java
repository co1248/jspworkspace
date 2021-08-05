package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/movielist.do")
public class movielistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getInstance();
		
		List<MemberVO> movielist = mDao.selectAllMembers();
		request.setAttribute("movielist", movielist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movielist.jsp");
		dispatcher.forward(request, response);
	}
}
