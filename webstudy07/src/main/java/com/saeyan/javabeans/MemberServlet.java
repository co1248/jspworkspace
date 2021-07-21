package com.saeyan.javabeans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean member = new MemberBean("Àü¼öºó", "pinksubin");
		
		request.setAttribute("member", member);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("09_el.jsp");
		dispacher.forward(request, response);
	}
}
