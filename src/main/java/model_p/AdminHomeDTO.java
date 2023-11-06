package model_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminHomeDTO {
	String car_img,plate_ad;
	Date in_date,out_date;
	int price,nid,totalPrice;
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCar_img() {
		return car_img;
	}

	public void setCar_img(String car_img) {
		this.car_img = car_img;
	}

	public String getPlate_ad() {
		return plate_ad;
	}

	public void setPlate_ad(String plate_ad) {
		this.plate_ad = plate_ad;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	public Date getOut_date() {
		return out_date;
	}

	public void setOut_date(Date out_date) {
		this.out_date = out_date;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String getIn_dateStr() {
		return sdf.format(in_date);
	}
	public void setIn_dateStr(String reg_date) {
		try {
			this.in_date = sdf.parse(reg_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getOut_dateStr() {
		return sdf.format(out_date);
	}
	public void setOut_dateStr(String reg_date) {
		try {
			this.out_date = sdf.parse(reg_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	@Override
	public String toString() {
		return "AdminHomeDTO [car_img=" + car_img + ", plate_ad=" + plate_ad + ", in_date=" + in_date + ", price=" + price
				+ ", nid=" + nid + "]";
	}
	
	
}
