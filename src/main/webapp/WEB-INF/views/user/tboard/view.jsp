<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<script src='/js/index.js'></script>
<script>
function checkDelYesno(){
	if(confirm("정말로 삭제하냐?")){
		return true;
	}else{
		return false;
	};
	
}
</script>

</head>
<body class="w3-black">
<%@ include file="../NavTop.jsp" %>
<%@ include file="../SideBar.jsp" %>
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>
<script>
function checkDelYesno(){
	if(confirm("정말로 삭제하냐?")){
		return true;
	}else{
		return false;
	};
	
}
</script>
	<div class="content" style="width:100%; padding:100px;">
		<div class="main">
			<div class="card">
				<h2>게시판</h2>
				<hr>
				<div style="margin-top:50px;">
					<table>
						<c:set value="${tboard}" var ="dto" />
						<thead style="width:100%">
							<tr>
								<td colspan="2" style="text-align:center;">제목 : ${dto.title }</td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td style="text-align:right;">아이디 : ${dto.id}</td>
								<td style="text-align:right;">참여수 : ${dto.pnum}</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:right;">작성시간 : ${dto.wdate}</td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align:center;">내용</td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2">${dto.content}</td>
								<td></td>
							</tr>
							
						</thead>
					</table>

									
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>
    
</body>
</html>