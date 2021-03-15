<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>





<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src='/js/index.js'></script>


<body class="w3-black">
<%@ include file="../NavTop.jsp" %>
<%@ include file="../SideBar.jsp" %>
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>

		<div class="board_content w3-content" style="width:100%">
			<div class="board_main">
				<h2 style="text-align:center">경기등록</h2>
				<div>
				<c:if test="${sess_name!=null}" >
					<button class="button" onclick="location.href='/tboard/regForm'">등록</button>
				</c:if>	
				</div>
				<br><br>		
				<table>
					<thead>
						<tr>
							<th style="width:10%">순번</th>
							<th style="width:20%">제목</th>
							<th style="width:8%">최대인원</th>
							<th style="width:8%">참여인원</th>
							<th style="width:15%">신청기간</th>
							<th style="width:9%">등록회원</th>
							<th style="width:10%">경기일자</th>
							<th style="width:5%">참가</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tboard}" var="dto">
							<tr onclick="location.href='/tboard/view?tno=${dto.tno}'">
								<td>${dto.tno}</td>
								<td style="text-align:left">${dto.title}</td>
								<td>${dto.pnum}</td>
								<td>미구현</td>
								<td>${dto.atime}</td>
								<td>${dto.id}</td>
								<td>${dto.ptime}</td>
								<td>미구현</td>
							</tr>
						</c:forEach>
					
					</tbody>			
				</table>
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	
</div>

</body>
</html>