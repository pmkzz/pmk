<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="/js/index.js"></script>
<script src="/js/formCheck.js"></script>


<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<%@include file ="../SideBar.jsp"%>
<!-- Navbar on small screens (Hidden on medium and large screens) -->
<%@include file ="../NavTop.jsp" %>

<!-- Page Content -->
<div class="w3-padding-large w3-content" id="main">
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-black" id="home">
    <div class="header" style="z-index:0;">
	
	<img src="/img/bellinger.jpg">
		<div class="center">
	
			<div class="content " style="width:100%; padding:100px;">
			
				<div class="main">	
					<div class="card">
					
						<form name="memReg" method="post" action="/member/memberInsert" onsubmit="return FormCheck()">
								<fieldset>
									<legend>회원가입</legend>
									<input id="id_input" type="text" name="id" maxlength="15" placeholder="아이디" onchange="idCheck()">
									<p id="idCheckMsg" style="color:red"></p>
									<input type="hidden" name="isidCheck" id="isidCheck">
									
									<input type="text" name="pw" maxlength="15" placeholder="패스워드"><br>* 비밀번호는 4~15자리 여야 합니다.
									<p id="pw_error" style="color:red"></p>
								
							
									<input type="text" name="name" maxlength="15" placeholder="이름" required><br>
					
				
					
									<input type="text" name="eid" placeholder="이메일주소">@<input type="text" name="domain" placeholder="도메인">
									<select name="sel_domain" onchange="inputdomain()">
										<option value="">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="daum.net">daum.net</option>
										<option value="gmail.com">gmail.coms</option>
									</select><br>
									<p id="eid_error"></p>
									<fieldset>
										<legend>성별</legend>
										<input type="radio" id="male" name="gender" value="M">남자
										<input type="radio" id="female" name="gender" value="F">여자
									</fieldset><br>
									<p id="gender_error"></p>
									<fieldset>		
									<legend>취미</legend>
										<input type="checkbox" name="hobby" value="music">음악
										<input type="checkbox" name="hobby" value="game">게임
										<input type="checkbox" name="hobby" value="exercise">운동
									</fieldset><br>
									<p id="hobby_error"></p>
						
									<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
								<script src="/js/search_address.js"></script>
								
								<input type="text" name="post" size="5" placeholder="우편번호" id="postcode" readonly>
								<input type="button" onclick="search_address()" value="우편번호 찾기"><br>
								<input type="text" name="addr1" placeholder="주소" id="address" readonly><br>
								<input type="text" name="addr2" placeholder="상세주소" id="detailAddress"><br>
								<input type="text" name="addr3" placeholder="참조항목" id="extraAddress" readonly><br>
					
								<textarea rows="6" cols="100" name="intro" placeholder="자기소개(100글자이네)"></textarea>
								<input type="submit" value="등록">
<!-- 									<input type="button" value="회원탈퇴" style="float:'right'"> -->
							
								</fieldset>
					</form>	
				
					</div>
				</div>
			</div>
		</div>
	</div>
 	</header>
 	<%@ include file="../footer.jsp" %>
 	
</div>

</body>
</html>
