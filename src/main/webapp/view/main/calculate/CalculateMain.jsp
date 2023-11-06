<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>

	#wrapperMain{
		/* border:1px solid#000;  */
		width: 1200px;
		height: 900px;
		margin: auto;
		
	}

	#carimg{
		/* border:1px solid#000;   */
		width: 800px;
		height: 600px;
		margin: auto;
		margin-top: 30px;
		background-image: url('../fff/car.jpg');
		background-repeat: no-repeat;
		background-size: 800px 600px;
	
	}
	#input{
		border:1px solid#000;
		width: 200px;
		height: 40px;
		margin-left: 300px;
		margin-top: 380px;
		font-size : 30px;
		text-align: center;
	}
	#input::placeholder {
  		font-size: 20px;
 
	}
	h1{
		margin-left: 150px;
		margin-bottom: 20px;
	}
	hr{
		width:1200px;
		margin: auto;
	}
	#sub{
		width:800px;
		margin-top: 50px;
		margin-left: 200px;
		height: 80px;
		font-size : 30px;
		color: white;
		background: #ff8c00;
		border:1px solid#fff;
		border-radius: 15px;
		cursor: pointer;
		/* border-radius:50px; */
	}
	#sub:hover{
	background: #ffa500;
	}
	#ll{
		margin-top: 10px;
		text-align: right;
	}
</style>

<title>정산</title>
</head>
<body>

<h1>정산</h1>
<hr />
<form action="CalculateDetail" method="get">
	<div id="wrapperMain">
		<div id="ll"><b>※ 차량번호 입력 ex) 12가1234</b></div>
		<div id="carimg">
		
			<input type="text" id=input maxlength="8" autofocus="autofocus" name="plate" required placeholder="차량번호 입력"/>
			
		</div>
		
		<div>
			<input type="submit" id="sub" value="확 인"/>
		</div>

	</div>
</form>

</body>
</html>