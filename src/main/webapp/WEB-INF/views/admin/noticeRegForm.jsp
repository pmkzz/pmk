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
			<h2 style = "text-align:center">게시판 등록</h2>
			<form name="borad" method="post" action="noticeRegProc.bo" >
				<input type="text" name="title" placeholder="제목" maxlength="255" required>
				<textarea name="content" placeholder="내용"></textarea>			
				<input type="submit" value="등록">
			</form>
	</div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>