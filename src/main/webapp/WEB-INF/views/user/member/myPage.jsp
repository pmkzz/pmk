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


<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<%@include file ="../SideBar.jsp"%>
<!-- Navbar on small screens (Hidden on medium and large screens) -->
<%@include file ="../NavTop.jsp" %>

<!-- Page Content -->
<div class="w3-padding-large w3-content" id="main">
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-black" id="home">
    <div class="header">
	
	<img src="/img/bellinger.jpg">
		<div class="center">
	
			<div class="content" style="width:100%; padding:100px;">
			
				<div class="main">	
					<div class="card">
						<c:set value="${member}" var="dto"/>
						<form name="memReg" method="post" action="/member/memberModify" onsubmit="return memberFormCheck()">
							아이디<input type="text" name="id" maxlength="15" value="${dto.id}"><br>
							<input type="text" name="pw" maxlength="15" placeholder="패스워드">* 비밀번호는 4~15자리 여야 합니다.
							<p id="pw_error"></p>
								
							<input type="text" name="name" maxlength="15" placeholder="이름" value="${dto.name}" required><br>
						
							<input type="text" name="eid" value="${fn:substring(dto.email,0, fn:indexOf(dto.email,'@'))}" placeholder="이메일주소">
							<input type="text" name="domain" value="${fn:substring(dto.email,fn:indexOf(dto.email,'@')+1, fn:length(dto.email))}" placeholder="도메인">
								<p id="eid_error"></p>
							<fieldset>
								<legend>성별</legend>
								<input type="radio" id="male" name="gender" value="M"
								<c:if test="${dto.gender == 'M' }"> checked </c:if>>남자
								<input type="radio" id="female" name="gender" value="F"
								<c:if test="${dto.gender == 'F' }"> checked </c:if>>여자
							</fieldset><br>
							<p id="gender_error"></p>
								
							<fieldset>		
								<legend>취미</legend>								
									<c:forEach var="h" items="${hobby}"  >
										<input type="checkbox" name="hobby" value="${h.codeVal}"
											<c:forEach var="myhobby" items="${dto.hobby}">
												<c:if test ="${myhobby == h.codeVal}">checked</c:if>
											</c:forEach>
										>${h.codeName}									
									</c:forEach>								
								
							</fieldset><br>
							<p id="hobby_error"></p>
							<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script src="/js/search_address.js"></script>
							
							<input type="text" name="post" size="5" placeholder="우편번호" id="postcode" value="${dto.post}" readonly>
							<input type="button" onclick="search_address()" value="우편번호 찾기"><br>
							<input type ="text" name="addr1" value="${dto.addr1}"><br>
							<input type="text" name="addr2" placeholder="상세주소" id="detailAddress" value="${dto.addr2}" ><br>
							<input type="text" name="addr3" placeholder="참조항목" id="extraAddress" value="${dto.addr3}" readonly><br>
																	
							<textarea rows="6" cols="100" name="intro" placeholder="자기소개(100글자이네)">
							${dto.intro }
							</textarea>
							
							<input type="submit" value="수정">
							<input type="button" value="회원탈퇴" style="float:right" onclick="location.href='/member/delete'">
									
										
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
