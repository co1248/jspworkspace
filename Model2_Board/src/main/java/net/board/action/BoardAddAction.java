package net.board.action;

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
         
         String savePath = "/boardupload";
         String realPath = request.getRealPath(savePath);
         
 		 int uploadFileSizeLimit = 5*1024*1024;
 		 
 		 boolean result = false;
 		 
 		 String encType = "UTF-8";
 		
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
            
            if(result == false) {
            	System.out.println("게시판 등록 실패");
            	return null;
            }
            System.out.println("게시판 등록 완료");
            
            forward.setRedirect(true);
            forward.setPath("./BoardList.bo");
            return forward;
        } catch (Exception e) {
            e.printStackTrace();
        }
 		return null;
    }
}