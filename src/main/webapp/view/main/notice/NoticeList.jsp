<%@page import="model_p.NoPData"%>
<%@page import="model_p.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
h1{
    margin-left: 150px;
    margin-bottom: 20px;
}
	hr{
		width:1200px;
		margin: auto;
		margin-bottom:70px
	}
	.notice_list{
		width:800px;
		height:600px;
		overflow: hidden;
		margin:auto;
	}
	.notice_list>ul>li{
		height:100px;
	}
	.notice_list>ul>li>div{
		float:left;
	}
	.ll{
	padding-top:10px;
	width:100px;
	font-size:25px;
	text-align:center;
	color:#FF8C00;
	border-right:1px dotted #ccc;
	}
	.notice_search{
		width:800px;
		height:60px;
		margin:auto;
	}
	.rr>a{
	font-size:30px;
	margin-left: 30px;
	color: #000;
	  cursor: pointer;
	}
	.rr>a:hover{
	color: #ff8c00;
	}
	a{
		text-decoration:none;
	}
	.listul>li{
		margin-left:30px;
	}
	  .form-container {
    display: flex;
    align-items: center;
  }

  .form-select {
    padding: 5px;
    margin-right: 10px;
    border-radius: 3px;
  }

  .form-input {
    padding: 5px;
    border-radius: 3px;
  }

  .form-submit {
 	 margin-left: 10px;
    padding: 8px 10px;
    border-radius: 3px;
    background-color: #FF8c00;
    color: #fff;
    border: none;
    cursor: pointer;
  }
  .form-submit:hover{
  background-color: #FFa500;
  }
	    .button_container {
        text-align: center;
        margin-bottom:20px;
    }
    .page_btn{
    	padding:3px 8px;
    	color:#fff;
    	 border-radius: 3px;
   	 background-color: #FF8c00;
   	 font-size:18px
    }
     .page_btn:hover{
      background-color: #FFa500;
     }
</style>
<h1 >공지사항</h1>
<hr />
<%
	ArrayList<NoticeDTO>  mainData = (ArrayList<NoticeDTO>)request.getAttribute("mainData"); 
	NoPData pd = (NoPData)request.getAttribute("pd");
	%>
<div  class ="notice_search">
<form action="?" method="post" class="form-container">
  <select name="cate" class="form-select">
    <option value="title">제목</option>
    <option value="nid">번호</option>
  </select>
  <input type="text" name="sch" value="" class="form-input">
  <input type="submit" value="검색" class="form-submit">
</form>
</div>
<div class ="notice_list">
	<ul>
	<%for(int i = 0 ; i<mainData.size() ; i++) {%>
		<li>
			<div class ="ll">No<hr style="width:30px; margin:10px 40px 10px 30px;"><%=mainData.get(i).getNid() %></div>
			<div class = "rr">
				<a href="/HongStProj/Notice/NoticeDetail?nid=<%=mainData.get(i).getNid()%>"><%=mainData.get(i).getTitle() %></a>
					<ul class="listul">	
						<li><%=mainData.get(i).getReg_date() %></li>
						<li>이미지 파일 
						<%if(mainData.get(i).getImgFile()!=null && !mainData.get(i).getImgFile().equals("")){ %>
							<img src="/HongStProj/fff/folder.png" width="15px"  />
						<%}%>
						</li>
					</ul>
			</div>
		</li>	
		<hr style="margin-top:10px; margin-bottom:20px;">
		<%} %>
	</ul>
		<div class="button_container">
	        <% if(pd.getStartPage() > 1) {%>
            <a href="?nowPage=<%=pd.getStartPage()-1%>&sch=<%=request.getParameter("sch") %>&cate=<%=request.getParameter("cate")%>" class="page_btn"  role="button" ><</a>
        <%} for(int p=pd.getStartPage(); p<=pd.getEndPage(); p++){ 
            if(pd.getNowPage()==p){%>
            <button type="button" class="page_btn" style="background-color: #FFa500;"><%=p %></button> <%-- 이미 선택한 페이지 번호임으로 a태그 필요없음 --%>

            <%}else{ %>


            <a href="?nowPage=<%=p %>&sch=<%=request.getParameter("sch") %>&cate=<%=request.getParameter("cate")%>" class="page_btn "  role="button"><%=p %></a>
 

        <%}} if(pd.getEndPage() < pd.getTotalPage()){%>
            <a href="?nowPage=<%=pd.getEndPage()+1%>&sch=<%=request.getParameter("sch") %>&cate=<%=request.getParameter("cate")%>" class="page_btn " role="button" >></a>
        <%} %>
        </div>
</div>