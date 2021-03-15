<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>    


<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="/js/index.js"></script>
<script src="/js/formCheck.js"></script>

<body>

  <div class="login_modal" id="login_modal" style="z-index:1">
	<div id= "login_layer">
		<div class="login_layer_header">
			<p>로그인<p>
		</div>
		<div class="login_layer_close">
			<a href="#" onclick="login_layer_close()">x</a>
		</div>
		
		<form name="login" method="post" action="/member/login" onsubmit= "return formCheck()">
		
			<div class="login_content1">
				<input type="text" name="id" placeholder="아이디" size="45" maxlength="15"
					   value="<% if(request.getParameter("id") !=null)
					   out.print(request.getParameter("id")); %>" required><br>
				<input type="password" name="pw" placeholder="비밀번호" size="45" maxlength="15"><br>
				<p class="msg" id="msg" ></p>
				<p id="login_error" style="color:red"></p>

			</div>
		
			<div class="login_content2">
				<input type="submit" value="로그인">
			</div>
		
			<div class="login_content3">
				<a href="/member/memRegForm" >회원가입</a>
			</div>
		</form>
	</div>
  </div>

</body>
</html>
