package join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//포스트방식은 한글이 깨지지 않으려면 이걸 적어줘야 한다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id.equals("java")&& passwd.equals("java")){
	         HttpSession session = request.getSession();
	         session.setAttribute("id", id);
	         RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
	         dispatcher.forward(request, response);
	      } else{
	         out.println("<script>");
	         out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')");
	         out.println("history.back()");
	         out.println("</script>");
	      }
	}

}
