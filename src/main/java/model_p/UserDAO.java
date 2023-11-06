package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class UserDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	public UserDAO() {
		try {
			
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/zxcv");
			con = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public int payChk(String plate){
		int res=0;
		sql = "select payChk from parking where plate = ?";
		
		try {
			psmt = con.prepareStatement(sql);
            psmt.setString(1,plate);
            rs = psmt.executeQuery();
			rs.next();
			res=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	public void insert(String plate,String car_img){
		
		sql = "insert into parking (plate,car_img, in_date) values (?,?, sysdate())";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,plate);
			psmt.setString(2,car_img);
			psmt.executeUpdate();
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	

	

	
	public String in_dateChk(String plate){
	       String res = "";
	        sql = "select in_date from parking where plate = ?";

	        try {
	            psmt = con.prepareStatement(sql);
	            psmt.setString(1,plate);
	            rs = psmt.executeQuery();
				rs.next();
				res=rs.getString(1);
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	        return res;
	}

	
	public void delete(String plate){
		
		sql = "delete from parking where plate = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,plate);
			psmt.executeUpdate();
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	

	
	
	public int parkChk(String plate){
        int res = 0;
        sql = "select count(*) from parking where plate = ?";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1,plate);
            rs = psmt.executeQuery();

			rs.next();
			res=rs.getInt(1);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
	
	public int parking(){
        int res = 0;
        sql = "select count(*) from parking";

        try {
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();

			rs.next();
			res=rs.getInt(1);
			
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