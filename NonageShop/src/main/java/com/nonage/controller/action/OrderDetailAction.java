package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.OrderDAO;
import com.nonage.dto.MemberVO;
import com.nonage.dto.OrderVO;

public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "mypage/orderDetail.jsp";
		
		HttpSession session =  request.getSession();
        MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
        
        if(loginUser == null) {
        	url = "NonageServlet?command=login_form";
        } else {
        	int oseq = Integer.parseInt(request.getParameter("oseq"));
        	OrderDAO orderDAO =  OrderDAO.getInstance();
        	ArrayList<OrderVO> orderList = orderDAO.listOrderById(loginUser.getId(), "%", oseq); //"%"와일드카드 전체조회
        	
        	int totalPrice = 0;
			for(OrderVO ovo : orderList) {
        		totalPrice += ovo.getPrice2()*ovo.getQuantity();
        	}
			request.setAttribute("title", "주문 상세 내역");
			request.setAttribute("orderDetail", orderList.get(0));
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
        }
		request.getRequestDispatcher(url).forward(request, response);
	}
}