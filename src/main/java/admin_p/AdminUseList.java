package admin_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.AdminHomeDAO;
import model_p.AdminHomeDTO;
import model_p.PData;

public class AdminUseList implements Service{
public void execute(HttpServletRequest request , HttpServletResponse response) {
		String carNumInput = request.getParameter("carNumInput");
		AdminHomeDAO dao = new AdminHomeDAO();
		PData pd = (PData)request.getAttribute("pd");
		System.out.print("inputStart 실행:"+pd.inputStart);
		ArrayList<AdminHomeDTO> mainData = dao.list4(carNumInput,pd);
		System.out.println("rrrrrr 실행:"+mainData);
		
		request.setAttribute("mainData", mainData);
	}
}
