<%@page import="java.util.ArrayList"%>
<%@page import="model_p.PData"%>
<%@page import="model_p.AdminHomeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PData pd = (PData)request.getAttribute("pd");
	AdminHomeDTO adDTO = (AdminHomeDTO)request.getAttribute("adDTO");
	int daPrice = (int)request.getAttribute("daPrice");
%>
<style>
	.wrapperMain {
		max-width: 1200px;
		height:1000px;
		margin: 0 auto;
		padding: 20px;
		background-color: #f5f5f5;
		margin-left:60px;
		border:1px solid #ccc;
	}

	.search-form {
		margin-bottom: 20px;
	}

	.search-form input[type="date"] {
		width: 200px;
		padding: 5px;
		border: 1px solid #ccc;
		border-radius: 3px;
	}

	.search-form input[type="submit"] {
		padding: 5px 10px;
		background-color: #ff0;
		border: none;
		border-radius: 3px;
		color: #000;
		font-weight: bold;
		cursor: pointer;
	}

	.data-table {
		background-color: #fff;
		border: 1px solid #ccc;
		border-radius: 3px;
		padding: 10px;
		height:600px;
	}

	.table-header {
		display: flex;
		justify-content: space-between;
		border-bottom: 1px solid #ccc;
		margin-bottom: 10px;
	}

	.table-header {
		font-weight: bold;
	}

	.table-row {
		display: flex;
		justify-content: space-between;
		margin-bottom: 30px;
	}

	.pagination {
		display: flex;
		justify-content: center;
		margin-top: 20px;
	}

	.pagination ul {
		list-style-type: none;
		padding: 0;
		margin: 0;
	}

	.pagination ul li {
		display: inline-block;
		margin-right: 5px;
	}

	.pagination ul li a {
		display: inline-block;
		padding: 5px;
		border: 1px solid #ccc;
		border-radius: 3px;
		text-decoration: none;
		color: #000;
	}

	.pagination ul li a:hover {
		background-color: #f5f5f5;
	}

	.summary {
		margin-top: 20px;
		font-size:24px;
	}

	.total-amount {
		margin-top: 10px;
		font-weight: bold;
		font-size: 18px;
	}
	.bottomContainer{
		float:left;
		height:80px;
		margin-left:860px;
		font-weight:bold;
	}
	
	.bottomMain>div>div{
		width:400px;
		
	}
	input{
		height:50px;
	}
</style>
<script>
  $(document).ready(function(){
    $(".navigation li").hover(function(){
      $(this).children(".hiddenMenu").stop().slideToggle();
    });
  });
  
  function setMinCheckoutDate() {
	  var checkin = new Date(document.getElementById("inputStart").value);
	  checkin.setDate(checkin.getDate() + 1);
	  var minCheckoutDate = checkin.toISOString().slice(0, 10);
	  document.getElementById("inputEnd").setAttribute("min", minCheckoutDate);
	}

	function setMaxCheckoutDate() {
		  var checkin = new Date(document.getElementById("inputEnd").value);
		  checkin.setDate(checkin.getDate() - 1);
		  var minCheckoutDate = checkin.toISOString().slice(0, 10);
		  document.getElementById("inputStart").setAttribute("max", minCheckoutDate);
		}
</script>
<div class="wrapperMain">
	<div class="search-form">
		<form action="?">
			<p style="font-size: 18px; float:right;">입차 <input type="date" id="inputStart" name="inputStart" class="date" onchange="setMinCheckoutDate()"/> 
			   &nbsp;&nbsp;&nbsp;&nbsp;출차 <input type="date" id="inputEnd" name="inputEnd" class="date" onchange="setMaxCheckoutDate()"/>
			<input type="submit" value="검색" style="background:#A9A9A9; margin-left:30px; width:70px;"></p>
		</form>
	</div>
	<br/><br/>
	<div class="data-table">
		<div class="table-header">
			<p>차량번호</p>
			<p>입차시간</p>
			<p>출차시간</p>
			<p>결제금액</p>
		</div>
		<%
			/* int totalPrice = 0; */
			for(AdminHomeDTO dto : (ArrayList<AdminHomeDTO>)request.getAttribute("mainData")){
		%>
		<div class="table-row">
			<p><%=dto.getPlate_ad() %></p>
			<p><%=dto.getIn_dateStr() %></p>
			<p><%=dto.getOut_dateStr() %></p>
			<p><%=dto.getPrice() %>원</p>
		</div>
		<%-- <%totalPrice+=dto.getPrice(); %> --%>
		<%} %>
		<div class="pagination">
		    <ul>
		        <% if(pd.getStartPage() > 1){ %>
		        <div>
		          <li><a href="?nowPage=<%= pd.getStartPage()-1%>">&lt;</a></li>
		        </div>
		        <% } %>
		        
		        <% for(int p = pd.getStartPage() ; p<=pd.getEndPage() ; p++){
		          if(pd.getNowPage()== p){ %>
		        <li>[<%=p %>]</li>
		        <% } else { %>
		        <li><a href="?nowPage=<%=p%>"><%=p %></a></li>
		        <% }} %>
		        
		        <% if(pd.getEndPage() < pd.getTotalPage()) { %>
		        <div>
		          <li><a href="?nowPage=<%=pd.getEndPage()+1%>">&gt;</a></li>
		        </div>
		        <% } %>
		    </ul>	
		</div>
	</div>
	<div class="bottomMain">
			<div class="bottomContainer">
				<div class="summary">
					<div>날짜 금액 합계: <%=daPrice %>원</div>
					<div>총 금액  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=adDTO.getTotalPrice() %>원</div>
				</div>
			</div>
		</div>	
	
</div>
