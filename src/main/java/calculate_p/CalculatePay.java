package calculate_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.CalculateDAO;
import model_p.CalculateDTO;

public class CalculatePay implements Service {

	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//String payment = request.getParameter("payment"); 정산

		String plate = request.getParameter("plate");
		String in_date = request.getParameter("in_date");
		String out_date = request.getParameter("out_date");
		String price = request.getParameter("price");
		String car_img = request.getParameter("car_img");

		//System.out.println(payment);

		System.out.println(plate);
		System.out.println(in_date);
		System.out.println(out_date);
		System.out.println(price);
		System.out.println(car_img);

		
		
		System.out.println("실행됐냐? 1 ");
		CalculateDTO dto = new CalculateDTO();
			
		dto.setPlate(plate);
		dto.setIn_date(in_date);
		dto.setOut_date(out_date);
		dto.setPrice(price);
		dto.setCar_img(car_img);
	 
		System.out.println("실행됐냐? 2 ");
		
		int cnt = new CalculateDAO().insert(dto);
		new CalculateDAO().modify(plate);
		
		
		System.out.println("cnt:"+cnt);
		
		request.setAttribute("mainUrl", "inc/alert.jsp");
		request.setAttribute("msg", "메인 페이지로 이동합니다");
		request.setAttribute("goUrl", "/HongStProj/Calculate/CalculateMain");
		
		
			/*
			 * if(payment.equals(null)||payment == "null" || payment == null) {
			 * 
			 * request.setAttribute("mainUrl", "inc/alert.jsp"); request.setAttribute("msg",
			 * "등록(주차)되지않은 차량입니다."); request.setAttribute("goUrl",
			 * "/HongStProj/Calculate/CalculateMain"); }
			 */
		 

	}
}
