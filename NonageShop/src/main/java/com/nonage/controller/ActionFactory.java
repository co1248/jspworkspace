package com.nonage.controller;

import com.nonage.controller.action.Action;
import com.nonage.controller.action.ContractAction;
import com.nonage.controller.action.FindZipNumAction;
import com.nonage.controller.action.IdCheckFormAction;
import com.nonage.controller.action.IndexAction;
import com.nonage.controller.action.JoinAction;
import com.nonage.controller.action.JoinFormAction;
import com.nonage.controller.action.ProductDetailAction;
import com.nonage.controller.action.ProductKindAction;

public class ActionFactory {
	//싱글톤패턴
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
			action = new IndexAction();//객체생성
		} else if(command.equals("product_detail")) {
			action = new ProductDetailAction();	
		} else if(command.equals("category")) {
			action = new ProductKindAction();	
		} else if(command.equals("contract")) {
			action = new ContractAction();	
		} else if(command.equals("join_form")) {
			action = new JoinFormAction();	
		} else if(command.equals("id_check_form")) {
			action = new IdCheckFormAction();	
		} else if(command.equals("find_zip_num")) {
			action = new FindZipNumAction();	
		} else if(command.equals("join")) {
			action = new JoinAction();	
		}

		return action;
	}
}
