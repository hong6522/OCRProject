<%@page import="model_p.CalculateDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	CalculateDTO dto = (CalculateDTO)request.getAttribute("mainData");
	Object minutes = request.getAttribute("minutes");
	Object price = request.getAttribute("price");
	Object nowDate = request.getAttribute("nowDate");
	
	
%>   
<html>
<head>
<meta charset="UTF-8">
<script src="../fff/jquery_3_6_3.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script> 

<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	iamport.payment.js
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script> -->
<script>

var IMP = window.IMP;
IMP.init('imp58784867');

function Pay() {
   //iamport 대신 자신의 "가맹점 식별코드"를 사용
  IMP.request_pay({
    pg: "html5_inicis",
    pay_method: "card",
    merchant_uid : 'merchant_'+new Date().getTime(),
    name : '결제테스트',
    amount : <%=price%>,
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456'
  },
  
  function (rsp) { // callback
	  if (rsp.success) {
	      var msg = '결제가 완료되었습니다.';
	      alert(msg);
	      /* location.href = "CalculateMain" */
	      frm.submit()
	    } else {
	      var msg = '결제에 실패하였습니다.';
	      msg += '에러내용 : ' + rsp.error_msg;
	      alert(msg);
	    }
  });
}
</script>

<style>

	.wrapperMain{
		/* border:1px solid#000;   */
		width: 1200px;
		height: 600px;
		margin: auto;
		display:flex;	
	}
	
	h1{
		margin-left: 150px;
		margin-bottom: 20px;
	}
	
	hr{
		width:1200px;
		margin: auto;
	}
	#carsagin{
		border:1px solid#BDBDBD;
		display: flex;
		/* float:left; */
		width: 400px;
		height: 500px;
		margin: 10px;
	}
	#info{
		border:1px solid#F8F8F8; 
		width: 750px;
		height: 500px;
		margin: 10px;
		display: flex;
	}
	#in1{
		/* border:1px solid#F8F8F8; */
		width: 300px;
		height: 500px;
	}
	#in2{
		/* border:1px solid#000; */
		width: 450px;
		height: 500px;
	}
	.title{
		background-color:#F8F8F8;
		border:1px solid#BDBDBD; 
		width: 300px;
		height:123px;
		text-align:center;
		font-size : 30px;
		line-height: 100px;
		
	}
	.val{
		border:1px solid#BDBDBD; 
		width: 450px;
		height:123px;
		text-align:center;
		font-size : 30px;
		line-height: 100px;
	}
	#btn{  
		width: 1200px;
		height: 600px;
		margin: auto;
		display:flex;
		
	}
	
	#gg, #cencel{
		position: relative;
		width:400px;
		height:100px;
		margin: 20px;
		left: 150px;
		background: #ff8c00;
		font-size : 30px;
		color: white;
		border: 1px solid#fff;
		border-radius: 10px;
		cursor: pointer;
	}
	#gg:hover, #cencel:hover{
	background: #ffa500;
	}
	#num, #price{
		color:red;
		font-weight:bold;
	}
	#sale{
		color:blue;
	}
	img{
		width:400px;
		height:500px;
	}
	
		
</style>

<title>상세페이지</title>
</head>
<body>

<h1>상세페이지</h1>
<hr />
<form action="CalculatePay" method="get" name="frm">
	<div class="wrapperMain">
		<div id="carsagin">
			<img src="../fff/<%=dto.getCar_img() %>" alt="" />
		</div>
		<div id="info">
			<div id="in1">
				<div class="title">차량번호</div>
				<div class="title">입차시각</div>
				<div class="title">주차시간</div>
				<div class="title">주차요금</div>
				
			</div>
			<div id="in2">
				<div class="val" id="num"><%=dto.getPlate()%></div>
				<div class="val"><%=dto.getIn_date()%></div>
				<div class="val"><%=minutes %>분</div>
				<div class="val" id="price"><%=price%>원</div>
			</div>
			
		
		</div>
		
	</div>
	<div id="btn">
		<input type="hidden" value="정산" name="payment"/>
		<input type="hidden" value="<%=dto.getPlate() %>" name="plate"/>
		<input type="hidden" value="<%=dto.getIn_date() %>" name="in_date"/>
		<input type="hidden" value="<%=nowDate %>" name="out_date"/>
		<input type="hidden" value="<%=price %>" name="price"/>
		<input type="hidden" value="<%=dto.getCar_img() %>" name="car_img"/>
		<input type="button" id="gg" value="정산하기" onclick="Pay()" />
		<input type="button" id="cencel" value="취 소" onclick="location.href='CalculateMain'" />
	</div>
	
</form>

</body>
</html>