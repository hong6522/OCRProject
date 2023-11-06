package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminHomeDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	public AdminHomeDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/zxcv");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public AdminHomeDTO list(String nid){
			AdminHomeDTO dto = new AdminHomeDTO();
		      sql = "select * from parking_ad where plate_ad like ?";
		      
		      try {
		         psmt = con.prepareStatement(sql);
		         psmt.setString(1, "%"+nid);
		         rs = psmt.executeQuery();
		         if(rs.next()) {
		        	 
		        	 dto = new AdminHomeDTO();
		        	 dto.setCar_img(rs.getString("car_img"));
		        	 dto.setPlate_ad(rs.getString("plate_ad"));
		        	 dto.setIn_dateStr(rs.getString("in_date"));
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      return dto;
		   }
		
//		public AdminHomeDTO plateTot(String carNumInput){
//			AdminHomeDTO dto = new AdminHomeDTO();
//			sql = "SELECT count(*) FROM parking_ad where plate_ad like ? ";
//			try {
//				 psmt = con.prepareStatement(sql);
//		         psmt.setString(1,'%'+carNumInput+'%');
//		         rs = psmt.executeQuery();
//		         
//		         if(rs.next()) {
//	        	 
//	        	 dto = new AdminHomeDTO();
//	        	 dto.setImg(rs.getString("img"));
//	        	 dto.setPlate_ad(rs.getString("plate_ad"));
//	        	 dto.setIn_dateStr(rs.getString("in_date"));
//		         }
//		      } catch (Exception e) {
//		         e.printStackTrace();
//		      }finally {
//		    	  close();
//		      }
//		      
//		      return dto;
//		   }
		
//		public int total(){
//		      int res = 0;
//		      sql = "select count(*) from parking_ad";
//		      
//		      try {
//		         psmt = con.prepareStatement(sql);
//		         rs = psmt.executeQuery();
//		         
//		         rs.next();
//		         res = rs.getInt(1);
//		      } catch (Exception e) {
//		         e.printStackTrace();
//		      }
//		      
//		      return res;
//		   }
		
		public ArrayList<AdminHomeDTO> list2(PData pd,String carNumInput){   
			sql = "SELECT * FROM parking_ad";
		      ArrayList<AdminHomeDTO> res = new ArrayList<>();
		      try {
		         psmt = con.prepareStatement(sql);
		         psmt.setString(1, '%'+carNumInput);     
		         rs = psmt.executeQuery();
		         while(rs.next()) {
		        	 AdminHomeDTO dto = new AdminHomeDTO();	
		        	 dto.setCar_img(rs.getString("car_img"));
		        	 dto.setPlate_ad(rs.getString("plate_ad"));
		        	 dto.setIn_dateStr(rs.getString("in_date"));
		        	 dto.setOut_dateStr(rs.getString("out_date"));
		        	 dto.setPrice(rs.getInt("price"));
		            res.add(dto);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      return res;
		   }
		
		public AdminHomeDTO totalPrice(){
		      
		      sql = "select sum(price) from parking_ad";
		      AdminHomeDTO dto = new AdminHomeDTO();
		      try {
		         psmt = con.prepareStatement(sql);
		         
		         rs = psmt.executeQuery();
		         
		         if(rs.next()) {
		        	 dto.setTotalPrice(rs.getInt("sum(price)"));
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      
		      return dto;
		   }
		
		public int datePrice(PData pd){
			System.out.println("test1------------------");
		      sql = "select sum(price) from parking_ad";
			  if (pd.inputStart != null && !pd.inputStart.isEmpty() && pd.inputEnd != null && !pd.inputEnd.isEmpty()) {
			      sql += " WHERE in_date BETWEEN ? AND ?";
			  }
		      int res = 0;
		      try {
		         psmt = con.prepareStatement(sql);
		         System.out.println("test2------------------");     
		         if(pd.inputStart!="" && pd.inputStart!=null&&pd.inputEnd!="" && pd.inputEnd!=null) {
						psmt.setString(1, pd.getInputStart());
						psmt.setString(2, pd.getInputEnd());
					}
		         System.out.println("test3------------------");
		         rs = psmt.executeQuery();
		         
		         if(rs.next()) {
		        	 res = rs.getInt("sum(price)");
		        	 System.out.println("test4------------------");
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      System.out.println("test5------------------");
		      return res;
		   }
		
		public int total(PData pd){
		      int res = 0;
		      sql = "select count(*) from parking_ad";
		      
		      if(pd.inputStart!="" && pd.inputStart!=null&&pd.inputEnd!="" && pd.inputEnd!=null) {
					sql += " where in_date between ? and ?";
				}
		      
		      try {
		         psmt = con.prepareStatement(sql);
		         
		         if(pd.inputStart!="" && pd.inputStart!=null&&pd.inputEnd!="" && pd.inputEnd!=null) {
						psmt.setString(1, pd.getInputStart());
						psmt.setString(2, pd.getInputEnd());
					}
		         
		         rs = psmt.executeQuery();
		         rs.next();
		         res = rs.getInt(1);
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      return res;
		   }
		public ArrayList<AdminHomeDTO> list5(PData pd){   
//			sql = "SELECT * FROM parking_ad WHERE plate_ad ORDER BY out_date DESC LIMIT ?, ?";
		      sql = "SELECT * FROM parking_ad";
			  if (pd.inputStart != null && !pd.inputStart.isEmpty() && pd.inputEnd != null && !pd.inputEnd.isEmpty()) {
			      sql += " WHERE in_date BETWEEN ? AND ?";
			  }
			  sql += " ORDER BY out_date DESC LIMIT ?, ?";

			  
		      ArrayList<AdminHomeDTO> res = new ArrayList<>();
		      try {
		         psmt = con.prepareStatement(sql);
//		         psmt.setInt(1, pd.getStart());
//				 psmt.setInt(2, pd.getLimit());
				 
				if(pd.inputStart!="" && pd.inputStart!=null&&pd.inputEnd!="" && pd.inputEnd!=null) {
					psmt.setString(1, pd.getInputStart());
					psmt.setString(2, pd.getInputEnd());
					psmt.setInt(3, pd.getStart());
					System.out.println("pd.getStart()"+pd.getStart());
					System.out.println("pd.getLimit()"+pd.getLimit());
					psmt.setInt(4, pd.getLimit());
					System.out.println("검색성공");
				}else {
					psmt.setInt(1, pd.getStart());
					psmt.setInt(2, pd.getLimit());
				}
		         
		         rs = psmt.executeQuery();
		         while(rs.next()) {
		        	 AdminHomeDTO dto = new AdminHomeDTO();
		        	 dto.setCar_img(rs.getString("car_img"));
		        	 dto.setPlate_ad(rs.getString("plate_ad"));
		        	 dto.setIn_dateStr(rs.getString("in_date"));
		        	 dto.setOut_dateStr(rs.getString("out_date"));
		        	 dto.setPrice(rs.getInt("price"));
		        	 
		             res.add(dto);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      return res;
		   }
		
		public ArrayList<CalculateDTO> list3(String carNumInput){   
			sql = "SELECT * FROM parking WHERE plate LIKE ? ORDER BY in_date DESC";
		      ArrayList<CalculateDTO> res = new ArrayList<>();
		      try {
		         psmt = con.prepareStatement(sql);
		      
		         psmt.setString(1, '%'+carNumInput);
		        	 
		         rs = psmt.executeQuery();
		         while(rs.next()) {
		        	 CalculateDTO dto = new CalculateDTO();
		        	 dto.setCar_img(rs.getString("car_img"));
		        	 dto.setIn_date(rs.getString("in_date"));
		        	 dto.setPlate(rs.getString("plate"));
		        	 
		            res.add(dto);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      return res;
		   }
		
		public ArrayList<AdminHomeDTO> list4(String carNumInput,PData pd){   
			sql = "SELECT * FROM parking_ad where nid > 0 ";
//			 where plate_ad like ?
			 if (carNumInput != "") {
				 sql += " and plate_ad LIKE ? ";
			 }
			 if (pd.inputStart != null && !pd.inputStart.isEmpty() && pd.inputStart != "" ) {
				 sql += " and in_date LIKE ? ";
			 }
			 sql += ";";
		      ArrayList<AdminHomeDTO> res = new ArrayList<>();
		      try {
		         psmt = con.prepareStatement(sql);
		         if(carNumInput != "") {
		        	 psmt.setString(1, '%'+carNumInput);
		        	 if(pd.inputStart != null && !pd.inputStart.isEmpty() && pd.inputStart != "" ) {
		        		 psmt.setString(2, pd.getInputStart()+'%');
			         }
		         }
		         else if(pd.inputStart != null && !pd.inputStart.isEmpty() && pd.inputStart != "" ) {
	        		 psmt.setString(1, pd.getInputStart()+'%');
		         }
		         
			     
		         rs = psmt.executeQuery();
		         while(rs.next()) {
		        	 AdminHomeDTO dto = new AdminHomeDTO();
		        	 dto.setCar_img(rs.getString("car_img"));
		        	 dto.setPlate_ad(rs.getString("plate_ad"));
		        	 dto.setIn_dateStr(rs.getString("in_date"));
		        	 dto.setOut_dateStr(rs.getString("out_date"));
		        	 dto.setPrice(rs.getInt("price"));
		            res.add(dto);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		    	  close();
		      }
		      return res;
		   }
		
		public void close() {
		      if(rs!=null)try { rs.close();} catch (Exception e) {}
		      if(psmt!=null)try { psmt.close();} catch (Exception e) {}
		      if(con!=null)try { con.close();} catch (Exception e) {}
		}
}




