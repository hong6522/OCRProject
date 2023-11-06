<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mainUrl = (String)request.getAttribute("mainUrl");
%>
<!DOCTYPE html>
<html>
<head>
<style>
*{
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}
body{
	width: 100%;	
}
#bottom{
	background-color: #001529;
    height: 110px;
}
#main{
	margin-top: 20px;
	width: 100%;
}
#main > div{
	margin: 0, auto;
}
#wrapper{
	width:1200px;
}
#wrapper > div{
	float:left;
}
#next{
	overflow-y: auto;
    display: block;
    position: fixed;
    left: 0;
    top: 0;
    width: 3.8125rem;
    height: 100%;
    background-color: #808080;
    z-index: 20;
}
#top{
	width:100%
}
</style>
<meta charset="UTF-8">
<title>주차 관리자</title>
</head>
<body>
<div id="wrapper">
	<div>
		<div id="next">
			<jsp:include page="inc/adminNext.jsp"/>
		</div>
	</div>
	
	<div>
		<div id="top">
			<jsp:include page="inc/admintop.jsp"/>
		</div>
		<div id="main">
				<jsp:include page="<%=mainUrl %>" />
		</div>
	</div>
</div>
</body>
</html>