package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.EmployeesDeleteAction;
import com.saeyan.controller.action.EmployeesListAction;
import com.saeyan.controller.action.EmployeesUpdateAction;
import com.saeyan.controller.action.EmployeesUpdateFormAction;
import com.saeyan.controller.action.EmployeesViewAction;
import com.saeyan.controller.action.EmployeesWriteAction;
import com.saeyan.controller.action.EmployeesWriteFormAction;

public class ActionFactory {
	//教臂沛菩畔
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("employees_list")) {
			action = new EmployeesListAction();//按眉积己
		} else if(command.equals("employees_write_form")) {
			action = new EmployeesWriteFormAction();
		} else if(command.equals("employees_write")) {
			action = new EmployeesWriteAction();
		} else if(command.equals("employees_view")) {
			action = new EmployeesViewAction();
		} else if(command.equals("employees_update_form")) {
			action = new EmployeesUpdateFormAction();
		} else if(command.equals("employees_update")) {
			action = new EmployeesUpdateAction();
		} else if(command.equals("employees_delete")) {
			action = new EmployeesDeleteAction();
		}
		return action;
	}
}
