package unit06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		out.print("����� �Է��� �����Դϴ�.<br>");
		out.print("���̵� : ");
		out.print(name);
		out.print(" �ּ� : ");
		out.print(addr);
		out.print("<br><a href = 'javascript:history.go(-1)'>���ư���</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //�ݵ�� �Է�
		doGet(request, response);
	}

}
