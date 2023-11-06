package admin_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.NoticeDAO;
import model_p.NoticeDTO;


public class AdminNotice implements Service{
	public void execute(HttpServletRequest request , HttpServletResponse response) {
		String cate = (String)request.getParameter("cate");
		String sch = (String)request.getParameter("sch");
		System.out.println("cate: "+cate+",sch: "+sch);
		NoticeDAO nDao = new NoticeDAO();
		ArrayList<NoticeDTO> mainData= nDao.noticeList(cate, sch);
		request.setAttribute("mainData", mainData);

	}
}
