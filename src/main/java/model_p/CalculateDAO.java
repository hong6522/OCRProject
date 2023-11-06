package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




//import model_p.CounselDTO;

public class CalculateDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public CalculateDAO() {
		try {
			
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/zxcv");
			con = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public CalculateDTO detail(String plate){
		CalculateDTO dto = null;
		sql = "select * from parking where plate like ?";
		// select * from parking where plate = '122허6785'
		//System.out.println(sql);
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,"%"+plate+"%");
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CalculateDTO();
				dto.setPlate(rs.getString("plate"));
				dto.setIn_date(rs.getString("in_date"));
				dto.setCar_img(rs.getString("car_img"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	public boolean numChk(String plate){
        boolean res = false;
        sql = "select * from parking where plate = ?";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1,plate);
            rs = psmt.executeQuery();

            res = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return res;
    }
	
	public int payChk(String plate){
        int res = 0;
        sql = "select payChk from parking where plate = ?";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1,plate);
            rs = psmt.executeQuery();
            rs.next();
            res = rs.getInt(1);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }

        return res;
    }
	
	public int insert(CalculateDTO dto){
		int res = 0;
		
		sql = "insert into parking_ad(plate_ad, in_date, out_date, price, car_img) values "
				+ " (?,?,?,?,?)";
		
		//insert into parking_ad(plate_ad, in_date, out_date, price, img) values("122허6785",sysdate(), "2023-05-25 18:12:03", 50000, "car1.jpg");

		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, dto.getPlate());
			psmt.setString(2, dto.getIn_date());
			psmt.setString(3, dto.getOut_date());
			psmt.setString(4, dto.getPrice());
			psmt.setString(5, dto.getCar_img());
			
			
			res = psmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}	
		return res;
	}
	
	public void modify(String plate){
		sql = "update parking set payChk = 1 where plate = ?";
		
		try {
			psmt = con.prepareStatement(sql);
					
			psmt.setString(1, plate);
		
			
			psmt.executeUpdate();	
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}	
	}
	
	
	public void close() {
		
		if(rs!=null)try { rs.close();} catch (Exception e) {}
		if(psmt!=null)try { psmt.close();} catch (Exception e) {}
		if(con!=null)try { con.close();} catch (Exception e) {}
	}
	
	

}
