<%@page import="java.util.ArrayList"%>
<%@page import="model_p.AdminHomeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.wrapperMain{
    width: 1200px;
    height: 1000px;
	float:left;
	background:#f5f5f5;
	margin-left:60px;
	border:1px solid #ccc;

}
table {
	width: 1100px;
	height: 900px;
	margin-top: 30px;
	border-collapse: collapse;
	margin:auto;
	text-align:center;
}
.searchContainer{
	width:1100px;
	height:80px;
	margin-left:50px;
	margin-top:50px;
    display: block;
	margin-top: 10px;
	padding: 0.9375rem 1.25rem;
	border: 1px solid #ccc;
    font-size: 0;
    background-color: #fff;
    
}

  input[type="text"] {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    outline: none;
  }

  input[type="submit"] {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #A9A9A9;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-bottom:1px;
  }
  .date-input {
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    padding: 8px 10px;
    font-size: 16px;
    outline: none;
  }
   select {
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 0.25rem;
  appearance: none;
  background-color: #fff;
  color: #333;
}
select:hover,
select:focus {
  border-color: #f00;
  outline: none;
  transition:1s;
}
.data-container {
    width: 1100px;
    height: 830px;
    margin-top: 30px;
    margin-left: 50px;
    border: 1px solid #ccc;
    text-align:center;
    background:#fff;
    	overflow: auto;
  }

  .data-row {
    display: flex;
    border-bottom: 1px solid #ccc;
    height: 50px;
    
  }

  .data-column {
    flex: 1;
    padding: 10px;
    font-weight: bold;
  }

  .data-cell {
    flex: 1;
    padding: 10px;
  }
  .searchSubContainer{
  	margin-left:300px;
 
  }
</style>

<div class="wrapperMain">
	<div class="searchContainer">
		<div class="searchSubContainer">
			<form action="/HongStProj/Admin/AdminUseList" method="post" name="frm">
			    <input type="text" placeholder="차량번호 입력" name="carNumInput" value=""/>
			    <input type="date" id="inputStart" class="date-input" name="inputStart" style="margin-left:20px;" onchange="setMinCheckoutDate()" />
				<input type="submit" style="margin-left:20px;" value="입차 조회"/>
			</form>
		</div>
	</div>
	<div class="data-container">
		<div class="data-row">
			<div class="data-column">차량번호</div>
			<div class="data-column">입차시간</div>
			<div class="data-column">출차시간</div>
		</div>
		<% for(AdminHomeDTO dto : (ArrayList<AdminHomeDTO>)request.getAttribute("mainData")) { %>
		<div class="data-row">
			<div class="data-cell"><%= dto.getPlate_ad() %></div>
			<div class="data-cell"><%= dto.getIn_dateStr() %></div>
			<div class="data-cell"><%= dto.getOut_dateStr() %></div>
		</div>
		<% } %>
	</div>
</div>