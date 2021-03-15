<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="../index.js"></script>
<script src="formCheck.js"></script>


<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<%@include file ="../SideBar.jsp"%>
<!-- Navbar on small screens (Hidden on medium and large screens) -->
<%@include file ="../NavTop.jsp" %>

<!-- Page Content -->
<div class="w3-padding-large " id="main">
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-black" id="home">
    <div class="header">
	
	<img src="/img/bellinger.jpg">
		<div class="center">
	
			<div class="content" style="width:100%; padding:100px;">
			
				<div class="main">	
					<div class="card">
						<h2>회원수정</h2>
						<br>
<%-- 							<c:set value="${member}" var="dto"/> --%>
							<label>아이디</label><br>
							${member.id }<br><br>
								
							<label>이름</label><br>
							${member.name}(
								<c:choose>
									<c:when test="${member.gender eq 'M' }">
									남자
									</c:when>
									<c:when test="${member.gender eq 'F' }">
									여자
									</c:when>
									<c:otherwise>
									사람이 아닙니다.
									</c:otherwise>
								</c:choose>
								)
							<br><br>
								
							<label>이메일</label><br>
							${member.email}
							<br><br>
								
							<label>취미</label><br>
							<c:forEach var="h" items="${hobby}"  >
									<input type="checkbox" name="hobby" value="${h.codeVal}"
										<c:forEach var="myhobby" items="${member.hobby}">
											<c:if test ="${myhobby == h.codeVal}">checked</c:if>
										</c:forEach>
									>${h.codeName}									
							</c:forEach>							
							<br><br>
								
								
							<label>주소</label><br>
							${member.post }<br>
							${member.addr1 }
							${member.addr2 }
							${member.addr3 }
							<br><br>
					
								<label>자기소개</label><br>
								${member.intro }<br><br>
						
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
