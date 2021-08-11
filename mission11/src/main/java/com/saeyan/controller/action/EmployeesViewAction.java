package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/employees/employeesView.jsp";
		
		String id = request.getParameter("id");
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		EmployeesVO eVo = eDao.selectOneEmployeeById(id);
		
		request.setAttribute("employees", eVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
