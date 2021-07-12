package unit08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String gender = request.getParameter("gender");
		String chk_nail = request.getParameter("chk_nail");
		String content = request.getParameter("content");
		
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		out.print("����� �Է��� �����Դϴ�.<br>");
		out.print("<br>���� : ");
		out.print(gender);
		out.print("<br>���� ���� ���� : ");
		out.print(chk_nail);
		out.print("<br>�����λ� : <pre>");
		out.print(content);
		out.print("<br></pre><a href = 'javascript:history.go(-1)'>���ư���</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
