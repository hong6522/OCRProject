package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class NoticeDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	public NoticeDAO() {
		try {
			
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/zxcv");
			con = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public ArrayList<NoticeDTO> noticeList(NoPData pd){
		ArrayList<NoticeDTO> res = new ArrayList<NoticeDTO>();
		sql = "select * from notice ";
		if(pd.sch != null &&  !pd.sch.equals("")) {
			sql += " where "+pd.cate+" like ?";
		}
		sql += " order by nid desc limit ? , ?";		
		try {
			psmt = con.prepareStatement(sql);
			if(pd.sch != null &&  !pd.sch.equals("")) {
				psmt.setString(1,'%'+pd.getSch()+'%');
				psmt.setInt(2, pd.getStart());
				psmt.setInt(3, pd.getLimit());
			}
			else {
				psmt.setInt(1, pd.getStart());
				psmt.setInt(2, pd.getLimit());
			}
            rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNid(rs.getInt("nid"));
				dto.setTitle(rs.getString("title"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setImgFile(rs.getString("imgFile"));
				dto.setContent(rs.getString("content"));
				res.add(dto);
			};
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public ArrayList<NoticeDTO> noticeList(String cate,String sch){
		ArrayList<NoticeDTO> res = new ArrayList<NoticeDTO>();
		sql = "select * from notice ";
		if(sch != null && sch != "") {
			sql += " where "+cate+" like ?";
		}
		
		try {
			psmt = con.prepareStatement(sql);
			if(sch != null && sch != "") {
				psmt.setString(1,'%'+sch+'%');
			}
            rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNid(rs.getInt("nid"));
				dto.setTitle(rs.getString("title"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setImgFile(rs.getString("imgFile"));
				dto.setContent(rs.getString("content"));
				res.add(dto);
			};
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public int total(NoPData pd){
		int res = 0;
		sql = "select count(*) from notice";
		if(pd.sch != null && !pd.sch.equals("")) {
			sql += " where "+pd.cate+" like ?";
		}
		try {
			psmt = con.prepareStatement(sql);
			if(pd.sch != null &&  !pd.sch.equals("")) {
				psmt.setString(1,'%'+pd.getSch()+'%');
			}
			rs = psmt.executeQuery();
			
			rs.next();
			res = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	
	public NoticeDTO noticeDetail(String nid){
		NoticeDTO dto = new NoticeDTO();
		sql = "select * from notice where nid = ?";
		System.out.print(nid);
		int nInt = Integer.parseInt(nid);
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1,nInt);
            rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setNid(rs.getInt("nid"));
				dto.setTitle(rs.getString("title"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setImgFile(rs.getString("imgFile"));
				dto.setContent(rs.getString("content"));
			};
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	
	
	public int noticeInsert(NoticeDTO nDto){
		System.out.println(nDto);
		sql = "insert into notice (title,content,imgFile, reg_date) values (?,?,?, sysdate())";
		int res = 0;
		try {
	psmt = con.prepareStatement(sql);
	psmt.setString(1,nDto.getTitle());
	psmt.setString(2,nDto.getContent());
	psmt.setString(3,nDto.getImgFile());
	psmt.executeUpdate();
	
	
	sql = "select max(nid) from notice";
	psmt = con.prepareStatement(sql);
	rs = psmt.executeQuery();
	rs.next();
	res = rs.getInt(1);
	  
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public void noticeModify(NoticeDTO nDto){
		sql = "update notice set title = ?, content = ?, imgFile = ? where nid = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,nDto.getTitle());
			psmt.setString(2,nDto.getContent());
			psmt.setString(3,nDto.getImgFile());
			psmt.setInt(4,nDto.getNid());
			psmt.executeUpdate();
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
		public void noticeDelete(String nid){
		
		sql = "delete from notice where nid = ?";
		int nInt = Integer.parseInt(nid);
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1,nInt);
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