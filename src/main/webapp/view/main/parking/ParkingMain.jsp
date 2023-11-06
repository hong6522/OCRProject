<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
.parking_all{
    width: 1200px;
    height: 500px;
    margin: auto;
}
h1{
    margin-left: 150px;
    margin-bottom: 20px;
}
hr{
    width:1200px;
    margin: auto;

}
#pp{

    text-align: center;
    font-size: 2.5rem;
}
#pp > #qq{
    margin: auto;
}

img{

    width:340px;
    height:300px;
}
#zz{
    width:500px;
    height:300px;
}
.vv{
    color:#FF8C00;
    font-size: 3rem;
}
.bb{
    color:#A0A0A0;
    font-size: 3rem;
}
.nn{
    color:#007bff;
    font-size: 3rem;
}
#ll{
    float:left;
}

</style>
<%
    int parking = (int)request.getAttribute("parking");
    int clear = (int)request.getAttribute("clear");
%>

<h1>주차 현황</h1>
<hr />
<div class="parking_all">
    <div id="ll">
        <div id="pp">
        <div id="qq">
            <img src="../fff/cc1.png" />
        </div>
        <div id="qq">
            <b>전체 주차공간</b>
        </div>
        <div id="qq" >
            <b class="vv">10</b> 대
        </div>
        </div>
    </div>
    <div id="ll">
        <div id="pp">
        <div id="qq">
            <img src="../fff/cc3.png" id="zz"/>
        </div>
        <div id="qq">
            <b>사용중인 주차공간</b>
        </div>
        <div id="qq">
            <b class="bb"><%=parking %></b> 대
        </div>
        </div>
        </div>
    <div id="ll">
        <div id="pp">
        <div id="qq">
            <img src="../fff/cc2.png" />
        </div>
        <div id="qq">
            <b>사용가능 주차공간</b>
        </div>
        <div id="qq">
            <b class="nn"><%=clear %></b> 대
        </div>
        </div>
    </div>


</div>
