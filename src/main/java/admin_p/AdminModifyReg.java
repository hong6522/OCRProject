package admin_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import control_p.Service;
import model_p.NoticeDAO;
import model_p.NoticeDTO;

public class AdminModifyReg implements Service{

	public void execute(HttpServletRequest request, HttpServletResponse response) {
	      
		String path = request.getRealPath("/fff");
		path = "C:\\hongkh\\study\\javaWork\\HongStProj\\src\\main\\webapp\\fff";		
		NoticeDTO nDto = new NoticeDTO();
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy());
			nDto.setNid(Integer.parseInt(mm.getParameter("nid")));
			nDto.setTitle(mm.getParameter("title"));
			nDto.setContent(mm.getParameter("content"));
			nDto.setImgFile(mm.getFilesystemName("imgFile"));
			System.out.println(mm.getParameter("title"));
			System.out.println(mm.getParameter("content"));
			System.out.println(mm.getFilesystemName("imgFile"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		new NoticeDAO().noticeModify(nDto);
	      
	      request.setAttribute("mainUrl", "inc/alert.jsp");
	      request.setAttribute("msg", "수정완료");
	      request.setAttribute("goUrl", "AdminDetail?nid="+nDto.getNid());
	      
	   }
}



