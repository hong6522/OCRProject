<%@page import="model_p.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	.wrapperMain {
		width: 1200px;
		height:1000px;
		margin: 0 auto;
		padding: 20px;
		background-color: #f5f5f5;
		margin-left:60px;
		border:1px solid #ccc;
	}
	h1{
		margin-left:30px;
		padding-top:10px;
	}
	.notice_list{
		border: 1px solid #ccc;
		width:1100px;
		height:700px;
		overflow: auto;
		margin-left:30px;
		background:#fff;
	}
	.notice_list>ul>li{
		border-bottom: 1px solid #ccc;
		height:100px;
		padding-top:20px;
	}
	.notice_list>ul>li>div{
		float:left;
	}
	.ll{
	width:60px;
	}
	.search{
	margin-left:30px;
	border:1px solid #ccc;
	background:#fff;
	margin-bottom:20px;
	height:80px;
	width:1100px;
	padding-top:20px;
	}
	.rr{
		margin-left:50px;
	}
	
	form {
	  display: flex;
	  align-items: center;
	}
	
	select, input[type="text"], input[type="submit"] {
	  padding: 8px;
	  font-size: 16px;
	}
	
	select {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	}
	.cate{
		margin-left:20px;
	}
	input[type="text"] {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  width:900px;
	  margin-left:10px;
	}
	
	input[type="submit"] {
	  background-color: #808080;
	  color: white;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	  margin-left:10px;
	  padding: 8px 15px;
	}
	
	input[type="submit"]:hover {
	  background-color: #A9A9A9;
	}
	
	input[type="button"] {
	  padding: 8px 20px;
	  font-size: 16px;
	  background-color: #808080;
	  color: white;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	  margin-left:30px;
	  margin-right:20px;
	}
	input[type="button"]:hover {
	  background-color: #A9A9A9;
	}
	
</style>
<div class="wrapperMain">
<%ArrayList<NoticeDTO>  mainData = (ArrayList<NoticeDTO>)request.getAttribute("mainData"); %>
	<div class = "search">
		<form action = "?" method="post">
			<select name = "cate" class="cate">
				<option value="title">제목</option>
				<option value="nid">번호</option>
			</select>
			<input type="text" name="sch" value="" placeholder="검색어를 입력해주세요"/>
			<input type = "submit"value="검색" />
			<input type = "button" value="글쓰기" onclick="location.href='/HongStProj/Admin/AdminInsert'" />
		</form>
		
	</div>
<div class ="notice_list">
	<ul>
	<%for(int i = 0 ; i<mainData.size() ; i++) {%>
		<li>
			<div class ="ll"><h1><%=mainData.get(i).getNid() %></h1></div>
			<div class = "rr">
				<a href="/HongStProj/Admin/AdminDetail?nid=<%=mainData.get(i).getNid()%>"><%=mainData.get(i).getTitle() %></a>
					<ul>	
						<li><%=mainData.get(i).getReg_date() %></li>
						<li>이미지 파일 
						<%if(mainData.get(i).getImgFile()!=null && !mainData.get(i).getImgFile().equals("")){ %>
							<img src="/HongStProj/fff/folder.png" width="15px"  />
						<%}%>
						</li>
					</ul>
			</div>
		</li>	
		<%} %>
	</ul>
</div>
</div>