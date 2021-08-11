package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");	
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		eDao.deleteEmployee(id);
		
		response.sendRedirect("EmployeesServlet?command=employees_list");
	}
}
