package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
 public class BoardFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 String RequestURI = request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		
		 if(command.equals("/BoardList.bo")){ 
             action = new BoardListAction(); 
             try{ 
                 forward=action.execute(request, response); 
             }catch(Exception e){ 
                 e.printStackTrace(); 
             } 
         } else if(command.equals("/BoardWrite.bo")){ 
             forward=new ActionForward(); 
             forward.setRedirect(false); 
             forward.setPath("./board/qna_board_write.jsp"); 
         } else if(command.equals("/BoardAddAction.bo")){ 
             action  = new BoardAddAction(); 
             try { 
                 forward=action.execute(request, response ); 
             } catch (Exception e) { 
                 e.printStackTrace(); 
             } 
         } else if(command.equals("/BoardDetailAction.bo")){ 
             action = new BoardDetailAction(); 
             try{ 
                 forward=action.execute(request, response); 
             }catch(Exception e){ 
                 e.printStackTrace(); 
             } 
         }
		 if(forward !=null){
	            if(forward.isRedirect()){
	                response.sendRedirect(forward.getPath());
	            }else{
	                RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
	                dispatcher.forward(request,response);                  
	                System.out.print(forward.getPath());
	            }
	        }        
	    } 
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}	  	 
}