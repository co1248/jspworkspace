package net.board.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardAddAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 BoardDAO boardDao=new BoardDAO(); 
         BoardBean boarddata=new BoardBean(); 
         ActionForward forward=new ActionForward(); 
         boolean result = false;
          
         String savePath = "/boardupload";
 		int uploadFileSizeLimit = 5*1024*1024;
 		String encType = "UTF-8";
 		
 		String realPath = request.getRealPath(savePath);

 		
 		try {
 			MultipartRequest multi = new MultipartRequest (
 					request, //request객체
 					realPath,//서버상의 실제 디렉토리
 					uploadFileSizeLimit,//최대 업로드 파일 크기
 					encType,//인코딩 방법
 					new DefaultFileRenamePolicy()
 			);//동일한 이름이 존재하면 새로운 이름이 부여됨
            boarddata.setName(multi.getParameter("name"));
            boarddata.setPass(multi.getParameter("pass"));
            boarddata.setSubject(multi.getParameter("subject"));
            boarddata.setContent(multi.getParameter("content"));
            boarddata.setFile(multi.getFilesystemName((String)multi.getFileNames().nextElement())); 
            result=boardDao.boardInsert(boarddata);
             
            forward.setRedirect(true);
            forward.setPath("./BoardList.bo");
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return forward;
    }
}