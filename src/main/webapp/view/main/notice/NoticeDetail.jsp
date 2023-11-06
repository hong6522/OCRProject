   <%@page import="model_p.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <title>공지사항 상세 페이지</title>
    <style>
   .container {
        max-width: 900px;
        min-height:500px;
        margin: 50px auto;
        padding: 20px;
        border: 3px solid #FF8C00;
        background-color: #fff;
        box-sizing: border-box;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    
    .notice_title {
    	padding:20px;
    	height:50px;
    	line-height:50px;
        font-size: 24px;
        font-weight: bold;
        background-color: #ffcc99;
    }
    
    .notice_info {
        color: #696969;
        padding:20px;
        margin-bottom: 20px;
        background-color: #ffcc99;
    }
    
    .notice_content {
        margin-bottom: 20px;
    }
    
    .notice_image {
        text-align: center;
        margin-bottom: 20px;
    }
    
    .notice_image img {
        max-width: 100%;
        height: auto;
    }
    
    .button_container {
        text-align: center;
        margin-bottom:20px;
    }
    
    .back_button {
        display: inline-block;
        padding: 10px 20px;
        background-color: #ff8c00;
        color: #fff;
        font-size: 16px;
        border: none;
        cursor: pointer;
        border-radius: 5px;
    }
     .back_button:hover {
  		 background-color: #ffa500;
     }
    h1{
    margin-left: 350px;
    margin-bottom: 20px;
}
	hr{
		width:1200px;
		margin: auto;
		margin-bottom:70px
	}
</style>
<h1 >공지사항</h1>
<hr />
    <% NoticeDTO dto = (NoticeDTO)request.getAttribute("mainData"); %>
    <div class="container">
        <div class="notice_title"><%= dto.getTitle() %></div>
        <div class="notice_info">
            ● No : <%= dto.getNid() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ● 등록일 : <%= dto.getReg_date() %>
        </div>
        <div class="notice_content">
            <%= dto.getContentBr() %>
        </div>
        <% if (dto.getImgFile() != null && !dto.getImgFile().equals("")) { %>
            <div class="notice_image">
                <img src="/HongStProj/fff/<%= dto.getImgFile() %>" alt="이미지" />
            </div>
        <% } %>
    </div>
    <div class="button_container">
        <input type="button" value="목록으로" onclick="location.href='/HongStProj/Notice/NoticeList'" class="back_button">
    </div>