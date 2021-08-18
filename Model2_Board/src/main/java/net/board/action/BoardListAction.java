package net.board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.BoardDAO;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
        BoardDAO boardDao = new BoardDAO();
        List boardlist = new ArrayList();
    
        int listcount = boardDao.getListCount();
        boardlist = boardDao.getBoardList(); 
        
        request.setAttribute("listcount",listcount); 
        request.setAttribute("boardlist", boardlist);
        
        ActionForward forward = new ActionForward();    
        forward.setRedirect(false);
	    forward.setPath("./board/qna_board_list.jsp");
	    return forward;
	}
}