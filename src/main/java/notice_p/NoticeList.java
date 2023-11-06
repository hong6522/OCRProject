package notice_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.NoticeDAO;
import model_p.NoticeDTO;
import model_p.NoPData;

public class NoticeList implements Service{

	public void execute(HttpServletRequest request , HttpServletResponse response) {
		NoPData pd = (NoPData)request.getAttribute("pd");
		pd.setTotal(new NoticeDAO().total(pd));
		ArrayList<NoticeDTO> mainData= new NoticeDAO().noticeList(pd);
		
		request.setAttribute("mainData", mainData);
	}
}



