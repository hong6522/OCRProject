package admin_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.AdminHomeDAO;
import model_p.AdminHomeDTO;
import model_p.CalculateDTO;
import model_p.PData;

public class AdminHome implements Service{
public void execute(HttpServletRequest request , HttpServletResponse response) {
		String carNumInput = request.getParameter("carNumInput");
//		
//		AdminHomeDAO dao3 = new AdminHomeDAO();
//		AdminHomeDTO mainData3 = dao3.plateTot(request.getParameter("carNumInput"));
//		request.setAttribute("mainData3", mainData3);
//		System.out.print("tqtqtqtq"+mainData3);
//		
//		if(cnt>1) {
		AdminHomeDAO dao = new AdminHomeDAO();
		
		ArrayList<CalculateDTO> mainData = dao.list3(carNumInput);
		System.out.println("rrrrrr 실행:"+mainData);
		
		request.setAttribute("mainData", mainData);
//		}else if(cnt==1) {
//		AdminHomeDAO dao = new AdminHomeDAO();
//		System.out.println("실행");
//		if(carNumInput!=null) {
//		AdminHomeDTO mainData = dao.list(carNumInput);
//		request.setAttribute("mainData", mainData);
//		System.out.println("가져가는 값"+carNumInput);
//		}else if(carNumInput==null){
//		request.setAttribute("mainData", null);
//		System.out.println("값못받음");
//		}
//		}
		
		
	}
}
