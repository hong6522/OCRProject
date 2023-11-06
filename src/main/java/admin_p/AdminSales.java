package admin_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.AdminHomeDAO;
import model_p.AdminHomeDTO;
import model_p.PData;

public class AdminSales implements Service{
	public void execute(HttpServletRequest request , HttpServletResponse response) {
		AdminHomeDAO dao = new AdminHomeDAO();
		PData pd = (PData)request.getAttribute("pd");
		pd.setTotal(dao.total(pd));
		
		ArrayList<AdminHomeDTO> mainData = dao.list5(pd);
		AdminHomeDTO adDTO = new AdminHomeDAO().totalPrice();
		int daPrice = new AdminHomeDAO().datePrice(pd);
		System.out.println(daPrice+"------------------");
		System.out.println("rrrrrr 실행:"+mainData);
		request.setAttribute("adDTO", adDTO);
		request.setAttribute("daPrice", daPrice);
		request.setAttribute("mainData", mainData);
	}
}
