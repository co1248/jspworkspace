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
		request.setCharacterEncoding("UTF-8");//����Ʈ����� �ѱ��� ������ �������� �̰� ������� �Ѵ�.
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
	         out.println("alert('���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
	         out.println("history.back()");
	         out.println("</script>");
	      }
	}

}
