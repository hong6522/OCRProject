package control_p;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_p.NoPData;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/Notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new NoPData(request);
		String ParkingStr =  request.getRequestURI().substring(
				(request.getContextPath()+"/Notice/").length()
				);
		
		System.out.println(ParkingStr);
		
		request.setAttribute("mainUrl", "main/notice/"+ParkingStr+".jsp");
		
		try {
			
			Service service = (Service)Class.forName("notice_p."+ParkingStr).newInstance();
			service.execute(request,response);
			
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/usertemplate.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
