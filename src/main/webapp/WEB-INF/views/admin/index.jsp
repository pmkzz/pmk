<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.login_modal{
 	border: 0px solid #000;
	position:fixed;
	width:100%;
	height:100%;

}
.login_layer{
	display:flex;
	position:relative;
	border:1px solid black;
	flex-direction:column;
	width:380px;
	height:210px;
	top:50%;
	left:50%;
	transform:translate(-50%,-50%);
}
.login_header{
	text-align:center;
	font-size:15px;
	margin:15px;
}
.login_wright{
	text-align:center;
	margin:10px;
}
input[type=submit]{
	width:250px;	
	height:30px;
	
	box-sizing: border-box;
	border:none;
	background-color:darkorange;
}
</style>

<body>
	<div class="login_modal" id="login_modal">
		<div class="login_layer">
			<div class="login_header">
				관리 시스템
			</div>
			<form name="login" method="post" action="/admin/login">
				<div class="login_wright">
				<input type="text" name="id" placeholder="아이디" size="30" maxlength="15" value="<% if(request.getParameter("id") !=null)
					   out.print(request.getParameter("id")); %>">
				</div>
				<div class="login_wright">
				<input type="text" name="pw" placeholder="패스워드" size="30" maxlength="15" >
				</div>
				<div class="login_wright">
				<input type="submit" value="로그인">
				</div>
				<p class="msg" id="msg" style=text-align:center;color:red;></p>				
				
			</form>

			<input type="hidden" id="loginRes" value="<c:out value="${loginStat}"/>">
			<script>
			window.onload = function(){
							
				
				if(document.getElementById("loginRes").value == "loginfail"){
					document.getElementById("login_modal").style.display ="block";
					document.getElementById("msg").innerHTML="일치하는 회원 정보가 없습니다.";
					document.forms["login"]["pw"].focus();
				}
			}
			</script>
		</div>
	</div>
</body>
</html>