<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src='/js/index.js'></script>
<style>
input[type=text],[type=number]{
	width:500px;	
	height:30px;
	float:left;
}
textarea{
	width:100%;
	height:300px;
	float:left;
}
input[type=submit], [type=button]{
background-color:orange;
border:0px solid #FFF;
color:white;
float:right;
width:80px;
height:50px;
font-size:20px;
margin: 10px;
}
</style>
<body class="w3-black">
<%@ include file="../NavTop.jsp" %>
<%@ include file="../SideBar.jsp" %>
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>
	
	<div class ="board_content" style="width:100%;">
		<div class="board_main">
			<h2 style = "text-align:center">게시판 등록</h2>
			<form name ="board" method = "post" action="/tboard/register">
				<input type="text" name="title" placeholder="제목" maxlength="255" required><br><br>
				<input type="number" name="pnum" placeholder="참여수" maxlength="10" required><br><br>
				<input type="number" name="atime" placeholder="신청기간(ex:20XXXXXX)" maxlength="10" required><br><br>
				<input type="number" name="ptime" placeholder="경기일자(ex:20XXXXXX)" maxlength="10" required><br><br>
				
				<textarea name="content" placeholder="내용"></textarea>
								
				<input type="submit" value="등록">
				
				
			</form>
		</div>
	</div>
</div>
</body>
</html>