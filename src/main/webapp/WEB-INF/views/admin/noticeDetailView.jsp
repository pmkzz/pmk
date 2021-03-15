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
		<div class="board_main">
			<h2 style="text-align:center">공지사항</h2>
			<br>
			<br>
			<c:set value="${notice}" var ="dto" />
			<input type=text value="제목 : ${dto.title}"><br>
			<input type=text value="아이디 : ${dto.id}"><br>
			<input type=text value="조회 : ${dto.cnt}"><br>
			<input type=text value="작성시간 : ${dto.wdate}"><br>
			<input type=text value="내용  :  ${dto.content}"><br>
			
	</div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>