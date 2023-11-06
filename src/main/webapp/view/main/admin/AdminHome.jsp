<%@page import="model_p.CalculateDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model_p.PData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model_p.AdminHomeDTO" %>
<%
	PData pd = (PData)request.getAttribute("pd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
li{
	list-style:none;
}
.wrapperMain{
    border:1px solid #ccc;
    width: 1200px;
    height: 1000px;
	float:left;
	margin-left:60px;
}

.info{
    width: 730px;
    height: 600px;
    margin: 20px 0 0 0;
    border:1px solid #000;
    border-radius:10px;
}
.keyContainer{
	width:400px;
	height:600px;
	border:1px solid #000;
	margin:20px;
	margin-left:20px;
	border-radius:10px;
}
.keypad {
	display: inline-block;
	text-align: center;
}
.btn {
    width: 80px;
    height: 80px;
    margin: 5px;
    margin-left:35px;
    margin-bottom:20px;
    border-radius:20px;
    box-shadow: 0 10px 10px lightgray;
}
#carNumInput {
    width: 325px;
    height: 80px;
    margin-top: 60px;
    margin-left: 37px;
    margin-bottom:15px;
}
.sch h2{
	border-bottom:3px solid lightgray;
	width:120px;
}
h2{
	margin:10px 0 0 10px;
}
#wrapperTop{
	float:left;
	margin-left:15px;

}
#wrapperTop>div{
	width:420px;
	float:left;
	
}
#key{
	width:1200px;
	display:flex;
}
.img:nth-child(1){
	width:700px;
	height:655px;
	border-radius:25px;
	display:block;
}
.img{
	display:none;
}
.carinfo{
	margin:30px 0 20px 60px;
	
}
.carinfo>div{
	width:299px;
	height:30px;
	border:1px solid #000;
	float:left;	
	text-align:center;
	padding-top:10px;
	border-radius:10px;
}
.carinfo2{
	margin-left:60px;
	border-radius:10px;
}
.carinfo2>div{
	width:299px;
	height:50px;
	border:1px solid #000;
	float:left;	
	text-align:center;
	padding-top:10px;
	margin-top:10px;
}
table {
	width: 1100px;
	height: 100px;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	border: 1px solid black;
}

th {
	background-color: #f2f2f2;
	font-weight: bold;
}

td {
	text-align: center;
}
#img{
	width:730px;
	height:604px;
	border-radius:15px;
}
.bbbb{
	width:1150px;
	height:300px;
	border:1px solid #000;
	margin-left:20px;
}
</style>
<title>상세페이지</title>
<script>
  var number = ""; // 저장된 번호 변수

  function addNumber(num) {
    if (number.length < 4) {
      number += num; // 숫자를 번호 변수에 추가
      document.getElementById("carNumInput").value = number; // 입력된 번호를 텍스트 필드에 표시
    }
  }

  function deleteNumber() {
    number = number.slice(0, -1); // 번호 변수에서 마지막 숫자 제거
    document.getElementById("carNumInput").value = number; // 변경된 번호를 텍스트 필드에 표시
  }
</script>
</head>
<body>
	<div class="wrapperMain">
		<div id="wrapperTop">
			<div class="sch"><h2>차량 검색</h2></div>
			<div class="sch"><h2>차량 정보</h2></div>	
		</div>
			<div id="key">
			<div class="keyContainer">
			  <form action="/HongStProj/Admin/AdminHome" name="frm">
			    <div class="num">
			      <input type="text" id="carNumInput" name="carNumInput" maxlength="4" readonly style="text-align:center; font-size:40px; border-radius:10px;">
			    </div>
			    <div class="keypad">
			      <input type="button" value="1" style="font-size:30px;" class="btn" onclick="addNumber(1)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="button" value="2" style="font-size:30px;" class="btn" onclick="addNumber(2)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="button" value="3" style="font-size:30px;" class="btn" onclick="addNumber(3)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <br>
			      <input type="button" value="4" style="font-size:30px;" class="btn" onclick="addNumber(4)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="button" value="5" style="font-size:30px;" class="btn" onclick="addNumber(5)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="button" value="6" style="font-size:30px;" class="btn" onclick="addNumber(6)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <br>
			      <input type="button" value="7" style="font-size:30px;" class="btn" onclick="addNumber(7)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="button" value="8" style="font-size:30px;" class="btn" onclick="addNumber(8)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="button" value="9" style="font-size:30px;" class="btn" onclick="addNumber(9)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <br>
			      <input type="button" value="Del" style="font-size:30px; background-color: #f23; border-color: #dc3545;"  class="btn" onclick="deleteNumber()" onmouseover="this.style.color='#ff0';" onmouseout="this.style.color='black';">
			      <input type="button" value="0" style="font-size:30px;" class="btn" onclick="addNumber(0)" onmouseover="this.style.color='#FF0000';" onmouseout="this.style.color='black';">
			      <input type="submit" value="검색" style="font-size:30px; " class="btn" onmouseover="this.style.color='#FF0';" onmouseout="this.style.color='black';">
			    </div>
			  </form>
			</div>
<div class="info">
<%if((ArrayList<CalculateDTO>)request.getAttribute("mainData")==null){ ArrayList<CalculateDTO> dto = (ArrayList<CalculateDTO>)request.getAttribute("mainData");%>
<div class="img"></div>
	<table border="1" style="width: 1100px; height: 100px; margin-left: 60px; margin-top: 30px; overflow: auto;">
	</table>
<%}else{ for(CalculateDTO dto : (ArrayList<CalculateDTO>)request.getAttribute("mainData")){%>
		<div class="img"><img src="/HongStProj/fff/<%=dto.getCar_img() %>" id="img" alt="" /></div>
<%}} %>
</div>
</div>
<div class="bbbb" style="overflow: auto;">
	<div style="border-bottom: 1px solid black; width: 1150px; overflow: auto;">
	<div style="display: flex; border-bottom: 1px solid black; font-weight: bold; background-color: #A9A9A9;">
		<div style="flex: 1; padding: 10px;">차량번호</div>
		<div style="flex: 1; padding: 10px; margin-left:50px;">입차시간</div>
	<form action="/HongStProj/Admin/AdminHome" name="frm">
		<input type="submit" value="초기화" style="height:39px; border:1px; font-size:20px; margin-right:10px; background:#A9A9A9;"
	     onmouseover="this.style.color='#FF0000';"
	     onmouseout="this.style.color='black';">
	</form>
	</div>
	<% if ((ArrayList<CalculateDTO>) request.getAttribute("mainData") != null) { %>
	<% for (CalculateDTO dto : (ArrayList<CalculateDTO>) request.getAttribute("mainData")) { %>
	<div style="display: flex; border-bottom: 1px solid black; background-color: #ffffff;">
	<div style="flex: 1; padding: 10px;"><a href="?carNumInput=<%= dto.getPlate() %>"><%= dto.getPlate() %></a></div>
	<div style="flex: 1; padding: 10px;"><%= dto.getIn_date() %></div>
	</div>
	<% }} %>
	</div>
	</div>
 		</div>
</body>
</html>

