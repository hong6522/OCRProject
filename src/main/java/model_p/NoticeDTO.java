package model_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeDTO {
	int nid;
	String title, imgFile, content;
	Date reg_date;
	
	
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getContentBr() { 
		//db의 줄바꿈을 인식 못해서 코드로 줄바뀌게 함.
		return content.replaceAll("\n","<br/>");
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	public String getReg_date() {
		return sdf.format(reg_date);
	}

	public void setReg_date(String reg_date) {
		
		try {
			this.reg_date = sdf.parse(reg_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	

}
