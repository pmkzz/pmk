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
	<form name="select" method="post" action="select.mo">
		<input type="radio" id="general" value="일반회원" name="rb" <c:if test="${membership=='일반회원'}">checked</c:if> >일반회원
		<input type="radio" id="sysop" value="운영자" name="rb" <c:if test="${membership=='운영자'}">checked</c:if>>운영자
		<input type="radio" id="admin" value="관리자" name="rb" <c:if test="${membership=='관리자'}">checked</c:if>>관리자
		<input type="text" id="selName" name="selName" placeholder="이름을 입력하세요">
		<input type="submit" id="select1" name="select1" value="검색">
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
							<td>${dto.rownum}</td>
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