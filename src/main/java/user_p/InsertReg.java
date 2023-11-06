
	package user_p;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.swing.JLabel;

import org.apache.tomcat.jni.Time;

	import com.oreilly.servlet.MultipartRequest;
	import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

	import control_p.Service;
import gui_p.CarInGui;
import gui_p.CarOutGui;
import gui_p.Clear;
import model_p.UserDAO;

	public class InsertReg  implements Service {
		
		
		public void execute(HttpServletRequest request, HttpServletResponse response) {
			CarInGui carIn = CarInGui.getInstance();
			CarOutGui carOut = CarOutGui.getInstance();
			Clear clear = Clear.getInstance();
			UserDAO uDao = new UserDAO();
			String path = request.getRealPath("/fff");
			path = "C:\\hongkh\\study\\javaWork\\HongStProj\\src\\main\\webapp\\fff";		
			String fileName ="";
			String button = "";
			try {
				MultipartRequest mm = new MultipartRequest(
					request,
					path,
					10*1024*1024,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
				fileName = mm.getParameter("carImg");
				button = mm.getParameter("button");
				
			} catch (Exception e) {}
			
			System.out.println("주차장입력버튼 구간1:"+button);
			System.out.println(fileName);
			
			
			//-----------------------------------------------------------------
			
			String txtPath ="";
			try {
				String pyPath = "C:\\hongkh\\study\\python_work\\ocr\\carCheck.py";
				String imgPath = "C:\\hongkh\\study\\javaWork\\HongStProj\\src\\main\\webapp\\fff\\"+fileName;
				txtPath = "C:\\hongkh\\study\\javaWork\\HongStProj\\src\\main\\webapp\\fff\\kkk.txt";
				
				ProcessBuilder builder = new ProcessBuilder("python", pyPath,imgPath,txtPath);
				
				builder.redirectErrorStream(true);
	            Process process = builder.start();
	            int exitNo = process.waitFor();

	            FileReader fr = new FileReader(txtPath);
	            BufferedReader br = new BufferedReader(fr);

	            String carNum = br.readLine();
	            String tt = "";
	            for (int i = 0 ; i < carNum.length() ; i++) {
	    			
	    			if(Pattern.matches("[가-힣;0-9]", carNum.split("")[i])) {
	    				tt += carNum.split("")[i];
	    			}
	    		}
	            
	            System.out.println(carNum);
	            System.out.println(tt);
	            //new CarInGui(carNum);
	            
	            
	            //System.out.println("주차장입력버튼 구간2:"+button);
	            if(button.equals("1")) {
	            	//carIn.signLabel = new JLabel("입차"+carNum);
	            	if(tt==null || tt.equals("") || tt.length()<7) {
	            		//System.out.println(tt.length());
	            		//tt = "차량번호를 다시 입력시켜주세요";
	            		carOut.signLabel.setText("차량번호를 다시 인식해주세요.");
	            	}
	            	else {
	            		carOut.signLabel.setText("출차 "+tt);
	     	            new UserDAO().delete(tt);
	     	           
	     	           
	            	}
	            }
	            else if(button.equals("2")) {
	            	//System.out.println("진입할까?");
	            	//carOut.signLabel = new JLabel("출차"+carNum);
	            	if(tt==null || tt.equals("") || tt.length()<7) {
	            		//System.out.println(tt.length());
	            		
	            		carIn.signLabel.setText("차량번호를 다시 인식해주세요.");
	            		
	            	}
	            	else {
		            	carIn.signLabel.setText("입차 "+tt);
		            	new UserDAO().insert(tt, fileName);
			 	            
			 	        //String cltt = "주차 가능 대수 :";
			 	        clear.signLabel.setText(tt); 
	            	}
	            	
	            }
	            br.close();
	            fr.close();
	            
	            
	            // System.out.println(exitNo);

	            //UserDAO uDao = new UserDAO();
	            
	            String cltt = "주차 가능 대수 :";
  	           	int parking = 10-uDao.parking();
  	           	String strParking = cltt + parking;
  	           	
  	           	
  	            clear.signLabel.setText(strParking);
	            
	           
	            
//	            if(uDao.parkChk(carNum)==0) {
//	            	new CarInGui(carNum);
//	                uDao.insert(carNum, fileName);
//	            }
//	            else if(uDao.payChk(carNum)==1){
//	            	new CarOutGui(carNum);
//	                uDao.delete(carNum);
//	                System.out.println("출차 if문 실행 종료");
//	            }
	            
	            //uDao.close();
	            
	            

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        //File file = new File(txtPath);
	        //file.delete();



	    }
	}