package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8"); 
        
        BoardDAO boardDao = new BoardDAO(); 
        BoardBean boarddata=new BoardBean(); 
            
        int num=Integer.parseInt(request.getParameter("num")); 
        boardDao.setReadCountUpdate(num); 
	    boarddata = boardDao.getDetail(num);
	   
	    request.setAttribute("boarddata", boarddata); 
	    ActionForward forward = new ActionForward(); 
	    forward.setRedirect(false); 
	    forward.setPath("./board/qna_board_view.jsp"); 
	    return forward; 
	}

}
