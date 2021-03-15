<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>    


<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/w3.css">
<script src='/js/index.js'></script>


<body class="w3-black">
<%@ include file="../NavTop.jsp" %>
<%@ include file="../SideBar.jsp" %>
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>

		<div class="board_content w3-content"  style="width:100%">
			<div class="board_main">
				<h2 style="text-align:center">게시판</h2>
				<div>
				<c:if test="${sess_name!=null}" >
					<button class="button" onclick="location.href='/board/regForm'">등록</button>
				</c:if>
				</div>
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
						<c:forEach items="${board}" var="dto">
						<tr onclick="location.href='view?bno=${dto.bno}'">
							<td>${dto.bno}</td>
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
	<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>