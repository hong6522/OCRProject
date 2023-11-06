package parking_p;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.UserDAO;


public class ParkingMain implements Service{

	public void execute(HttpServletRequest request , HttpServletResponse response) {
		UserDAO uDao = new UserDAO();
		int parking = uDao.parking();
		int clear = 10-parking;
		request.setAttribute("parking", parking);
		request.setAttribute("clear", clear);
	}
}
