<%@page import="model_p.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	background:#f5f5f5;
}
#rightSubContainer{
	width:800px;
	height:98%;
	
}
.info{
	width:500px;
}
.TitleWrite {
  width: 500px;
  max-width: 100%;
  font-size: 1em;
  padding: 0.5em;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin: 0.5em 0;
  color:#888;
}
.file-upload {
  position: relative;
  display: inline-block;
  margin: 10px;
}

.file-upload-label {
  background-color: #A9A9A9;
  color: white;
  padding: 10px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 18px;
}

.file-upload-input {
  position: absolute;
  left: 0;
  top: 0;
  opacity: 0;
  cursor: pointer;
}
.subContainer{
	border:1px solid #ccc;
	width:800px;
	height:600px;
	margin-left:230px;
	margin-top:100px;
	background:#fff;
}
.subContainer>form{
	margin-top:50px;
}
.bottom{
	margin-top:40px;
	margin-left:570px;
}

input[type="button"], input[type="reset"] {
  padding: 8px 16px;
  font-size: 16px;
  background-color: #A9A9A9;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="button"]:hover, input[type="reset"]:hover {
  background-color: #808080;
}
#title{
	width:700px;
	margin-left:50px;
}
#content{
	width:700px;
	height:200px;
	margin-left:50px;
}
h2{
	margin-left:50px;
	margin-top:30px;
}
.file-upload {
  	margin-left: 50px;
}
.file-upload-input{
	
}
</style>

<script>
   function inserChk(){
  
	   if(frm.title.value.trim() == "" || frm.title.value == null){
	          alert("제목을 입력 해주세요 ")
	          return
	    	}
	   
      if(frm.content.value.trim() == "" || frm.content.value == null){
          alert("내용을 입력 해주세요 ")
          return
    	}
       
      frm.submit()
   }
   </script>
  <div class="wrapperMain"> 
  <div class="rightContainer">
  <div class="subContainer">
    <form action="AdminInsertReg"  name="frm" method="post" enctype="multipart/form-data" id="rightSubContainer">
     <div class="rightSubContainer" style="position: relative">
    
     <div>
      <ul class="table">
      	  <li>
          <div class="info"><h2>제목</h2></div>
          <div><input type="text" name="title" id="title"  class="TitleWrite"/></div>
        </li>
		</ul>
    </div>
     <div>
      <ul class="table">
      	  <li>
          <div class="info"><h2>내용</h2></div>
          <div><textarea name="content" id="content"  cols="50" rows="5" style="color:#888"></textarea></div>
        </li>
		</ul>
    </div>
     <div>
      <ul class="table">
      	  <li>
          <div class="info"><h2>파일</h2></div>
          <div class="file-upload">
			  <label for="imgFile" class="file-upload-label">파일 선택</label>
			  <input type="file" name="imgFile" id="imgFile" class="file-upload-input">
		  </div>
        </li>
		</ul>
    </div>
    </div>
    <div class="bottom">
      	<input type="button" value="이전" onclick="location.href='AdminNotice'"/>
      	<input type="reset" value="초기화" />
      	<input type="button" value="등록"  onclick="inserChk()" />   
    </div>
    </form>
    </div>
 </div>
</div>


