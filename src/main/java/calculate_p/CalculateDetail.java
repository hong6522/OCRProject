package calculate_p;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control_p.Service;
import model_p.CalculateDAO;
import model_p.CalculateDTO;

public class CalculateDetail implements Service{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CalculateDAO dao = new CalculateDAO();
		
		boolean res = new CalculateDAO().numChk(request.getParameter("plate"));
		int res2 = new CalculateDAO().payChk(request.getParameter("plate"));
		System.out.println(res);
		
		
		
		if(res && res2==0){
			
			Date now = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String nowDate = formatter.format(now);
			
			CalculateDTO mainData = dao.detail(request.getParameter("plate"));
			System.out.println("디테일데이터: "+mainData);
			System.out.println(mainData.getIn_date());
			System.out.println("CalculateDetail.execute() 실행");
			System.out.println(nowDate); 
			
			try {
			    Date d1 = formatter.parse(nowDate);
			    Date d2 = formatter.parse(mainData.getIn_date());

			    // 시간 차이 계산
			    long time = d1.getTime() - d2.getTime();
			    long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
			    

			    // 시간 차이 출력
			    System.out.println(minutes + "분");
			    
			    // 요금 계산 10분당 1000원으로
			    int fee = 1000;
			    int price = (int) (minutes / 10) * fee;
			    
			    System.out.println("요금: " + price + "원");
			    
			    request.setAttribute("minutes", minutes);
			    request.setAttribute("price", price);
			    request.setAttribute("nowDate", nowDate);
			    
			} catch (ParseException e) {
			    e.printStackTrace(); 
			}
			
			
			
			request.setAttribute("mainData", mainData);
			
		}
		
		else {
			request.setAttribute("mainUrl", "inc/alert.jsp");
			request.setAttribute("msg", "등록(주차)되지않은 차량입니다.");
			request.setAttribute("goUrl", "/HongStProj/Calculate/CalculateMain");
		}
	}

}