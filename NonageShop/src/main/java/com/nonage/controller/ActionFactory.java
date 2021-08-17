package com.nonage.controller;

import com.nonage.controller.action.Action;
import com.nonage.controller.action.ContractAction;
import com.nonage.controller.action.IndexAction;
import com.nonage.controller.action.ProductDetailAction;
import com.nonage.controller.action.ProductKindAction;

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
		
		if(command.equals("index")) {
			action = new IndexAction();//按眉积己
		} else if(command.equals("product_detail")) {
			action = new ProductDetailAction();	
		} else if(command.equals("category")) {
			action = new ProductKindAction();	
		} else if(command.equals("contract")) {
			action = new ContractAction();	
		}

		return action;
	}
}
