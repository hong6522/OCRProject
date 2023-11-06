<%@page import="model_p.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%NoticeDTO dto = (NoticeDTO)request.getAttribute("mainData"); %>
<script>
function deleChk(){
    var confirmDelete = confirm("정말 삭제 하시겠습니까?");
    if (confirmDelete) {
    	location.href="/HongStProj/Admin/AdminDelete?nid=<%=dto.getNid() %>"
    } else {
    	location.href="/HongStProj/Admin/AdminDetail?nid=<%=dto.getNid() %>"
    }
}
    </script>

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

.notice_detail{
	border: 1px solid #ccc;
	width:1100px;
	height:700px;
	margin-left:30px;
	margin-top:50px;
	overflow: auto;
}
.notice_top{
	margin-left: 50px;
	margin-top:10px;
    border: 1px solid #ccc;
    background: #fff;
    margin-bottom: 20px;
    height: 80px;
    width: 1000px;
    padding-top:30px;
    padding-left:30px;
}
h2{
	margin-left:50px;
	margin-top:20px;
}
.notice_bottom{
	width: 1000px;
	height:auto;
	border: 1px solid #ccc;
	margin-left: 50px;
	margin-top:20px;
	background: #fff;
}
img{
	 max-width:100%;
	 height:auto;
}
input[type="button"] {
  padding: 8px 16px;
  font-size: 16px;
  background-color: #808080;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="button"]:hover {
  background-color: #A9A9A9;
}
.notice_input{
	margin-left:830px;
	margin-top:20px;
}
</style>
<div class="wrapperMain">
<div class ="notice_detail">
		<div class="notice_title"><h2><%=dto.getTitle() %></h2></div>
	<div class="notice_top">
		<div class="notice_etc">
			<div> 등록일 : <%=dto.getReg_date() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			글번호 : <%=dto.getNid() %></div>
		</div>
	</div>
	<div class="notice_bottom">
		<%=dto.getContent() %><br/>
		<%if(dto.getImgFile()!=null && !dto.getImgFile().equals("") ){%> 
			<img src="/HongStProj/fff/<%=dto.getImgFile()%>"/>
		<%} %>
	</div>
</div>
<div class="notice_input">
		<input type="button" value="목록으로" onclick="location.href='/HongStProj/Admin/AdminNotice'">
		<input type="button" value="수정하기" onclick="location.href='/HongStProj/Admin/AdminModify?nid=<%=dto.getNid() %>'">
		<input type="button" value="삭제하기" onclick="deleChk()">
	</div>
</div>
