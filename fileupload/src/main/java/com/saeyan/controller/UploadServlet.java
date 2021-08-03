package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//���⸦ �ٲ��ָ� �ٿ�޴� ��ΰ� �ٲ�
		String savePath = "upload";
		//�ִ� ���ε� ���� ũ�� 5MB�� ����
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮 :");
		PrintWriter out = response.getWriter();
		
		try {
			MultipartRequest multi = new MultipartRequest (
					request, //request��ü
					uploadFilePath,//�������� ���� ���丮
					uploadFileSizeLimit,//�ִ� ���ε� ���� ũ��
					encType,//���ڵ� ���
					new DefaultFileRenamePolicy());//������ �̸��� �����ϸ� ���ο� �̸��� �ο���
			String fileName = multi.getFilesystemName("uploadFile");//���ε�� ������ �̸� ���
			String fileName2 = multi.getOriginalFileName("uploadFile");//���� �� pc������ �̸�
			if(fileName == null) { //������ ���ε� ���� �ʾ��� ��
				System.out.println("���� ���ε� ���� �ʾ���");
			} else { //������ ���ε� �Ǿ��� ��
				out.print("<br> �۾��� : " + multi.getParameter("name"));
				out.print("<br> �� &nbsp; �� : " + multi.getParameter("title"));	
				out.print("<br> ���ϸ�(s) : " + fileName);
				out.print("<br> ���ϸ�(o) : " + fileName2);
			}
		} catch (Exception e) {
			System.out.println("���� �߻� : " + e);
		}
	}
}
