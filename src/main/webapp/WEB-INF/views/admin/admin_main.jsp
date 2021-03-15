<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

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
font-size: 25px;
padding:150px;
}
</style>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div class=content>
<p style="text-align:left">회원등록 건수 :	${cnt}건</p>
<p style="text-align:left">회원탈퇴요청 건수 :	${isdelCnt}건</p>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>