<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">

#mm{
    margin-left: 50px;
    float: left;
    width: 150px;
    font-size: 2rem;
	margin-top:30px;

}

a:visited{
    color:black;
}
a:hover{
    color:#FF8C00;
}
#hh{
    width: 400px;
    height: 100px;

}
#oo{
    float: left;
    /* margin-right: 30px; */

}
.topmenu{
    padding-top:50px;
    margin-left:20px;
    border: 1px 1px 1px 1px solid #000;
    background:#fff;
    height:100px;
    border-bottom:3px solid #ff8c00;
}

</style>




<div class="topmenu">
	<div id="oo">
	<a href="/HongStProj/Parking/ParkingMain"><img src="../fff/im.png" alt="" id="hh"/></a>
	</div>
    <div id="mm"><a href="/HongStProj/Calculate/CalculateMain" style="text-decoration: none"><b>사전결제</b></a></div>
    <div id="mm"><a href="/HongStProj/Parking/ParkingMain" style="text-decoration: none"><b>주차현황</b></a></div>
    <div id="mm"><a href="/HongStProj/Road/RoadIntro" style="text-decoration: none"><b>오시는길</b></a></div>
    <div id="mm"><a href="/HongStProj/Notice/NoticeList" style="text-decoration: none"><b>공지사항</b></a></div>
</div>