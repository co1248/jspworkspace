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
		
		//여기를 바꿔주면 다운받는 경로가 바뀜
		String savePath = "upload";
		//최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리 :");
		PrintWriter out = response.getWriter();
		
		try {
			MultipartRequest multi = new MultipartRequest (
					request, //request객체
					uploadFilePath,//서버상의 실제 디렉토리
					uploadFileSizeLimit,//최대 업로드 파일 크기
					encType,//인코딩 방법
					new DefaultFileRenamePolicy());//동일한 이름이 존재하면 새로운 이름이 부여됨
			String fileName = multi.getFilesystemName("uploadFile");//업로드된 파일의 이름 얻기
			String fileName2 = multi.getOriginalFileName("uploadFile");//실제 내 pc에서의 이름
			if(fileName == null) { //파일이 업로드 되지 않았을 때
				System.out.println("파일 업로드 되지 않았음");
			} else { //파일이 업로드 되었을 때
				out.print("<br> 글쓴이 : " + multi.getParameter("name"));
				out.print("<br> 제 &nbsp; 목 : " + multi.getParameter("title"));	
				out.print("<br> 파일명(s) : " + fileName);
				out.print("<br> 파일명(o) : " + fileName2);
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}
	}
}
