package unit10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String job = request.getParameter("job");
		String interests[] = request.getParameterValues("interest"); 
		
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		out.print("����� �Է��� �����Դϴ�.<br>");
		out.print("<br>���� : ");
		out.print(job);
		if(interests == null) {
			out.print("���ɺо߰� �����ϴ�.");
		} else {
			out.println("<br>���ɺоߴ� ");
			for(String interest : interests) {  
				out.print(interest + " ");
			}
			out.print("�Դϴ�.");
		}
		out.print("<br><a href = 'javascript:history.go(-1)'>���ư���</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
