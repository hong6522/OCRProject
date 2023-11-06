<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/HongStProj/css/admin.css">
<style>
a:hover{
	color: black;
	cursor: pointer;
	transition:1s;
 }
a{
	text-decoration: none;
}
 
.leftContainer{
	display: block;
	height: 3.75rem;
	position: relative;
}
a{
	color:black;
	font-weight:bold;
}
.navigation {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

.navigation li {
	display: inline-block;
	margin-right: 10px;
	
}

.navigation li a img {
	position: absolute;
    left: 1.25rem;
    top: 50%;
    margin-top: -0.5625rem;
    width: 1.125rem;
}

.navigation li a {
	text-decoration: none;
    position: relative;
    display: block;
    width: 3.75rem;
    height: 3.75rem;
    padding: 0 1.25rem;
    border-bottom: 1px solid black;
    line-height: 1.25rem;
}
.navigation li a:hover {
	opacity: 0.8;
}
navigation>img{
	padding-bottom:20px;
}
.menus{
	width:20px;
	height:20px;
	margin-left:3px;
}
.menuimg{
	width:20px;
	height:20px;
}
.sidebar{
	width:230px;
	height:100%;
	background:#808080;
	position:fixed;
	top:0;
	left:-300px;
	z-index:1;
	transition:all .35s;
}
#menuicon:checked+label+div{
	left:0;
}
.menu{
	width: 3.75rem;
    padding: 0 1.25rem;
    line-height: 1.25rem;
    padding-bottom:20px;
    padding-top:20px;
}
#menuicon{
	display:none;
}
input[checkbox]{
	z-index:1;
}
img:hover{
	cursor: pointer;
	transition:1s;
 }
 .navigations>li{
 	margin-bottom:15px;
 	margin-left:10px;
 	margin-top:15px;
 	list-style-type: none;
 	font-size:15px;
 	padding-bottom:15px;
 	border-bottom: 1px solid black;
 }

</style>
<script>
document.getElementById("menuicon").addEventListener("click", function() {
	  var slideshow = document.getElementById("slideshow");
	  if (slideshow.style.display === "none") {
	    slideshow.style.display = "block";
	  } else {
	    slideshow.style.display = "none";
	  }
	});
</script>
<input type="checkbox" id="menuicon" />
<label for="menuicon">
    <img src="/HongStProj/fff/menu.png" class="menu" style="border-bottom: 1px solid black;" alt="메뉴 아이콘" />
</label>
<div class="sidebar">
	<ul class="navigations" style="">
		<li><a href="AdminHome"><img src="/HongStProj/fff/cancel.png" class="menus" alt="메뉴 아이콘" /></a></li>
		<li><a href="AdminNotice"><img src="/HongStProj/fff/notice.png" class="menuimg" style="margin-bottom:-3px; " alt="기간별 입출차 조회"> 공지사항</a></li>
		<li><a href="AdminHome"><img src="/HongStProj/fff/parking.png" class="menuimg" style="margin-bottom:-3px; " alt="기간별 입출차 조회"> 번호판 조회</a></li>
		<li><a href="AdminUseList"><img src="/HongStProj/fff/diary.png" class="menuimg" style="margin-bottom:-3px;" alt="기간별 입출차 조회"> 입출차 조회</a></li>
		<li><a href="AdminSales"><img src="/HongStProj/fff/statics.png" class="menuimg" style="margin-bottom:-3px;" alt="매출"> 매출&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
	</ul>
</div>

<div class="leftContainer">
	<ul class="navigation" style="">
		<li><a href="AdminNotice"> <img src="/HongStProj/fff/notice.png" style="margin-bottom:20px;" alt="공지사항"></a></li>
		<li><a href="AdminHome"> <img src="/HongStProj/fff/parking.png" style="margin-bottom:20px;" alt="번호판 조회"></a></li>
		<li><a href="AdminUseList"> <img src="/HongStProj/fff/diary.png" style="margin-bottom:20px;" alt="입출차 조회"></a></li>
		<li><a href="AdminSales"> <img src="/HongStProj/fff/statics.png" style="margin-bottom:20px;" alt="매출"></a></li>
	</ul>
</div>

