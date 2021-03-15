<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.content{
border : 1px solid black;
border-top:0px solid white;
text-align: center;
font-size: 15px;
padding:150px;

}
.box1{
display:flex;
flex-direction:row;
border :1px solid black;
width : 800px;
padding:5px;
text-align:left;
}
.box2{
display:flex;
flex-direction:row;
border :1px solid white;
width : 500px;
padding:5px;
text-align:left;

}
</style>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div class=content>
	
		<c:if test="${sess_name!=null}" >
					<button class="button" onclick="location.href='noticeRegForm.bo'">등록</button>
		</c:if>
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
						<tr onclick="location.href='NoticeDetailView.bo?nno=${dto.nno}'">
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

<%@ include file="footer.jsp" %>
</body>
</html>