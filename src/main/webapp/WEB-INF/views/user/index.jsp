<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>    


<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/w3.css">

<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>

<script src="/js/index.js"></script>
<script src="/js/formCheck.js"></script>

<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<%@include file ="SideBar.jsp"%>
<!-- Navbar on small screens (Hidden on medium and large screens) -->
<%@include file ="NavTop.jsp" %>

<!-- login modal -->
<%@ include file ="login_modal.jsp" %>

<!-- Page Content -->
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
  
  <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
    <h1 class="w3-jumbo"><span class="w3-hide-small">스포츠</span> 토너먼트 랜덤 파이트</h1>
    <p></p>
    <img src="/img/bellinger.jpg" alt="boy" class="w3-image" style="width:100px">
  </header>

  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>

		<div class="board_content w3-content"  style="width:100%">
			<div class="board_main">
				<h2 style="text-align:center">공지사항</h2>
				<br><br>		
				<table>
					<thead>
						<tr>
							<th style="width:10%">순번</th>
							<th style="width:50%">제목</th>
							<th style="width:10%">조회수</th>
							<th style="width:10%">작성일자</th>
							<th style="width:10%">아이디</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${notice}" var="dto">							
							<tr onclick="location.href='/notice/view?nno=${dto.nno}'">
								<td>${dto.nno}</td>
								<td style="text-align:left">${dto.title}</td>
								<td>${dto.cnt}</td>
								<td>${dto.wdate}</td>
								<td>${dto.id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	
	

	<!-- 로그인 Section -->

  
    <!-- Footer -->
<%@ include file="footer.jsp" %>
  


<!-- END PAGE CONTENT -->
</div>



<input type="hidden" name="resMsg" value="${resMsg}" id="resMsg">
<input type="hidden" id="loginRes" value="<c:out value="${loginStat}"/>">
<script>
window.onload = function(){
	
	if(document.getElementById("resMsg").value ==1 ){
		alert("회원이 등록 되었습니다.");
		document.getElementById("login_modal").style.display = "block";	
	}
	
	if(document.getElementById("loginRes").value == "loginfail"){
		document.getElementById("login_modal").style.display ="block";
		document.getElementById("msg").innerHTML="아이디가 없습니다.";
		document.forms["login"]["pw"].focus();
	}
}

</script>

</body>
</html>
