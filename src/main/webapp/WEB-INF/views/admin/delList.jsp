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
	<div class=box1>
		<div class=box2>
		<form name="delselect" method="post" action="delselect.mo">
			<input type="text" style="width:200px;" id="deldate" name="deldate" placeholder="탈퇴요청 기준일 입력(yyyymmdd)">
			<input type="submit" id="select1" name="select1" value="검색">		
		</form>
		</div>
			
		<form name="del" method="post" action="delete.mo">
			<input type="submit" style="background-color: black;height:50px;color:white;width:200px; margin-left:300px;" id="delb" name="delb" value="탈퇴 요청 회원 일괄 삭제">
			<input type="hidden" id="redate" name="redate" value="${redate}">
		</form>
	</div>
		<table>
				<thead>
					<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th>인원 수 : ${cnt}</tr>
					<tr>
						<th style="width:100px;">순번</th>
						<th style="width:100px;">id</th>
						<th style="width:100px;">이름</th>
						<th style="width:100px;">성별</th>
						<th style="width:100px;">등급</th>
						<th style="width:100px;">가입일자</th>
						<th style="width:100px;">탈퇴요청일자</th>
					</tr>
				</thead>				
				<tbody>
					<c:forEach items="${sel}" var="dto" varStatus="status">					
						<tr>
							<td>${status.count}</td>
							<td>${dto.id}</td>
							<td>${dto.name}</td>
							<td>
								<c:choose>
									<c:when test="${dto.gender eq 'M' }">
									남자
									</c:when>
									<c:when test="${dto.gender eq 'F' }">
									여자
									</c:when>
									<c:otherwise>
									사람이 아닙니다.
									</c:otherwise>
								</c:choose>
							</td>
							<td>${dto.membership}</td>
							<td>
								<fmt:parseDate value="${dto.wdate}" var="wdate" pattern="yyyy-mm-dd"/>	
								<fmt:formatDate value="${wdate}" pattern="yyyy/mm/dd"/>	
							</td>
							<td>
								<fmt:parseDate value="${dto.deldate}" var="deldate" pattern="yyyy-mm-dd"/>	
								<fmt:formatDate value="${deldate}" pattern="yyyy/mm/dd"/>
							</td>
						</tr>						
					</c:forEach>							
					
				</tbody>
			</table>		
</div>

<%@ include file="footer.jsp" %>
</body>
</html>