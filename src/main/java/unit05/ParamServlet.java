package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String age = request.getParameter("age");
		
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		out.print("����� �Է��� �����Դϴ�.");
		out.print("���̵� : ");
		out.print(id);
		out.print(" ���� : ");
		out.print(age);
		out.print("<br><a href = 'javascript:history.go(-1)'>���ư���</a>");
		out.print("</body>");
		out.print("</html>");
	}
}
