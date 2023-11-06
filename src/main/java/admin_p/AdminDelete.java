package admin_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.NoticeDAO;
import model_p.NoticeDTO;

public class AdminDelete implements Service{

	public void execute(HttpServletRequest request , HttpServletResponse response) {
		String nid = (String)request.getParameter("nid");
		System.out.println(nid);
		new NoticeDAO().noticeDelete(nid);
	      request.setAttribute("mainUrl", "inc/alert.jsp");
	      request.setAttribute("msg", "삭제완료");
	      request.setAttribute("goUrl", "AdminNotice");
	}
}



