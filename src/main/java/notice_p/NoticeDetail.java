package notice_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.NoticeDAO;
import model_p.NoticeDTO;

public class NoticeDetail implements Service{

	public void execute(HttpServletRequest request , HttpServletResponse response) {
		String nid = (String)request.getParameter("nid");
		System.out.println(nid);
		NoticeDAO nDao = new NoticeDAO();
		NoticeDTO mainData= nDao.noticeDetail(nid);
		request.setAttribute("mainData", mainData);
	}
}



