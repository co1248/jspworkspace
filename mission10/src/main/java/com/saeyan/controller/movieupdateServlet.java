package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/movieupdate.do")
public class movieupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectMemberByCode(code);		
		
		request.setAttribute("member", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieupdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println(request.getParameter("title"));
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("images");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String poster = multi.getParameter("poster");
		if(poster == null) {
			poster =  multi.getParameter("nonmakeImg");
		}
		String synopsis = multi.getParameter("synopsis");
		
		
		System.out.println(title);
		
		
		
		MemberVO mVo = new MemberVO();
		mVo.setCode(Integer.parseInt(code));
		mVo.setTitle(title);
		mVo.setPrice(price);
		mVo.setDirector(director);
		mVo.setActor(actor);
		mVo.setPoster(poster);
		mVo.setSynopsis(synopsis);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);
		
		response.sendRedirect("movielist.do");
	}
}