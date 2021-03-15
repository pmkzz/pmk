<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.manubar{
border:1px solid black;
border-top:0px solid white;
display:flex;
flex-direction:row;
}

.manubutton{
border:none;
padding:15px;
text-align:center;
background-color:white;
flex-grow:1;
}
.logout{
display:flex;
flex-direction:row;
}
</style>
<body>
<div class =manubar>
	<form name="home" method="post" action="/admin/main">
		<button class=manubutton>HOME</button>
	</form>
	<form name="notice" method="post" action="/admin/noticeList">
		<button class=manubutton>공지사항</button>
	</form>
	<form name="memberList" method="post" action="/admin/memberList">
		<button class=manubutton type="submit">회원관리</button>
	</form>
	<form name="memberDel" method="post" action="/admin/memberDel">
		<button class=manubutton  type="submit">탈퇴회원관리</button>
	</form>
	<div style="width:50%"></div>
	
	
</div>
</body>
</html>