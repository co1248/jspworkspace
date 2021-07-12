package unit09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//üũ�ڽ��� �迭���·� ���� �Ѿ�´�
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String items[] = request.getParameterValues("item"); 
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		
		if(items == null) {
			out.print("�����׸��� �����ϴ�.");
		} else {
			for(int i = 0; i < items.length; i++) {  //for(String item : items) 
				out.print(items[i] + "<br>");
			}
		}
		
		out.print("<br><a href = 'javascript:history.go(-1)'>���ư���</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
