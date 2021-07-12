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
		String no = request.getParameter("no");
		String no2 = request.getParameter("no2");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String email3 = request.getParameter("email3");
		String postNo = request.getParameter("postNo");
		String add = request.getParameter("add");
		String add2 = request.getParameter("add2");
		String phone = request.getParameter("phone");
		String jobs[] = request.getParameterValues("job");
		String check_mail = request.getParameter("chk_mail");
		String interests[] = request.getParameterValues("interest"); 
		
		out.print("<html><head><title></title></head>");
		out.print("<body>");
		
		out.print("<br>�̸� : ");
		out.print(name);
		out.print("<br>�ֹι�ȣ : ");
		out.print(no + "-" + no2);
		out.print("<br>���̵� : ");
		out.print(id);
		out.print("<br>��й�ȣ : ");
		out.print(pw);
		out.print("<br>�̸��� : ");
		if(email2 == "") {
			out.print(email + "@" + email3);
		} else { 
			out.print(email + "@" + email2);
		}
		out.print("<br>�����ȣ : ");
		out.print(postNo);
		out.print("<br>�ּ� : ");
		out.print(add + " " + add2);
		out.print("<br>�ڵ�����ȣ : ");
		out.print(phone);
		out.print("<br>���� : ");
		if(jobs == null) {
			out.print(" �����ϴ�.");
		} else {
			for(String job : jobs) {  
				out.print(job + " ");
			}
		}
		out.print("<br>���ɺо� : ");
		if(interests == null) {
			out.print(" �����ϴ�.");
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

}
