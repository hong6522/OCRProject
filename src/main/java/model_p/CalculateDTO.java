package model_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateDTO {
	
	String plate, car_img, price;
	Date in_date, out_date;
	boolean payChk;
	
	public boolean isPayChk() {
		return payChk;
	}

	public void setPayChk(boolean payChk) {
		this.payChk = payChk;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	
	 
	public String getCar_img() {
		return car_img;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	public String getIn_date() {
		return sdf.format(in_date);
	}

	public void setIn_date(String in_date) {
		
		try {
			this.in_date = sdf.parse(in_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getOut_date() {
		return sdf.format(out_date);
	}

	public void setOut_date(String out_date) {
		try {
			this.out_date = sdf.parse(out_date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	

	public void setCar_img(String car_img) {
		this.car_img = car_img;
	}
	
	

}
