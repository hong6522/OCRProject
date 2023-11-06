<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

.mid_road{
	width: 100%;
}

.mid_road > div{
	float:left;
}

.road_left{
width:400px;
height:350px;
background-color:#FF7e00;
color:#F3F3F3;	
line-height: 30px;
text-align: center;
padding:10px;
box-sizing: border-box;
}


.main_board{
	width: 1200px;
	height: 400px;
	margin: auto;

}
h1{
	margin-left: 150px;
	margin-bottom: 20px;
}
hr{
	width:1200px;
	margin: auto;
	margin-bottom:70px
	
}
#aa, #bb, #cc{
	text-align: center;
	margin: 20px;
}
#aa{
	color: #FF8C00;
	font-size:2rem;
	margin: 20px;
}
#bb{
	color: #FF8C00;
	font-size:1.5rem;
}
#cc{
	height: 200px;
	font-size:1rem;
}

	
</style>
<h1>Hongst 찾아 오시는길</h1>
<hr />
<div class="main_board">
	<div class="mid_road">	
		<div class="road_left">
		<br/><br/>
		<h2>주차장 소개</h2><br/>
		국내 최고퀄리티 주차장인 삼성월드타워 76층~101층에<br/>
		위치한 Hongst주차장은 쾌적한 환경에서<br/>
		친절한 서비스를 제공하며<br/>
		실시간 주차가능 서비스를 이용할 수 있는<br/>
		유일의 주차장입니다.
		
		</div>
	
		<div id="map" style="width:790px;height:350px;" >
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2d6a1bdd8412bb95510991ae4dad99a2"></script>
		
		<script>
		    var container = document.getElementById('map');
		    var options = {
		        center: new kakao.maps.LatLng(37.5001, 127.029),
		        level: 3
		    };
		    var map = new kakao.maps.Map(container, options);
		 	// 마커가 표시될 위치입니다 
		    var markerPosition  = new kakao.maps.LatLng(37.5001, 127.029); 
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        position: markerPosition
		    });
		    // 마커가 지도 위에 표시되도록 설정합니다
		    marker.setMap(map);
		    //교통정보
		    map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
		</script>
		</div>
	</div>
	
	
</div>
<div id="pp">
	<div id="aa"><h2>Grow with Hongstcompany</h2></div>
	<div id="bb">Hongst주차장과 함께 할 수 있는 다양한 제안을 기다립니다.</div>
	<div id="cc"><b>"Hongst@localhongst.com"</b></div>
</div>
