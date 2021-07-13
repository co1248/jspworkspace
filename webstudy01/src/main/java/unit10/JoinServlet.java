package unit10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String jumin = request.getParameter("jumin_1") + "-" + request.getParameter("jumin_2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		if(request.getParameter("email_dns").trim() == "") {
			email += "@" + request.getParameter("emailaddr");
		} else { 
			email += "@" + request.getParameter("email_dns");
		}
		String zip = request.getParameter("zip");
		String addr = request.getParameter("addr1") + " " + request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String jobs[] = request.getParameterValues("job");
		String interests[] = request.getParameterValues("interest"); 
		
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		
		out.print("�̸� : <b>");
		out.print(name);
		out.print("<br>�ֹι�ȣ : <b>");
		out.print(jumin);
		out.print("<br>���̵� : <b>");
		out.print(id);
		out.print("<br>��й�ȣ : <b>");
		out.print(pwd);
		out.print("<br>�̸��� : <b>");
		out.print(email);
		out.print("<br>�����ȣ : <b>");
		out.print(zip);
		out.print("<br>�ּ� : <b>");
		out.print(addr);
		out.print("<br>�ڵ�����ȣ : <b>");
		out.print(phone);
		out.print("<br>���� : <b>");
		if(jobs == null) {
			out.print("�����׸����");
		} else {
			for(String job : jobs) {  
			out.print(job + " ");
			}
		}
		out.print("<br>���ɺо� : <b>");
		if(interests == null) {
			out.print("�����׸����");
		} else {
			for(String interest : interests) {  
				out.print(interest + " ");
			}
		}
		out.print("<br><a href = 'javascript:history.go(-1)'>�ٽ�</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
