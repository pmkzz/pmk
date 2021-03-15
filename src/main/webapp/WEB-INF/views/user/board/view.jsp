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
<style>

textarea{
	width:100%;
	height:300px;
	float:left;
}

</style>
<body class="w3-black">
<%@ include file="../NavTop.jsp" %>
<%@ include file="../SideBar.jsp" %>
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>
<script>
function checkDelYesno(){
	if(confirm("정말로 삭제하냐?")){
		return true;
	}else{
		return false;
	};
	
}
</script>

	<div class="content" style="width:100%; padding:100px;">
	<div class="main">
		<div class="card">
			<h2>게시판</h2>
			<hr>
			<div style="margin-top:50px;">
				<table>				
					<thead style="width:100%">
						<tr>
							<td colspan="2" style="text-align:center;">제목 : ${board.title}</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align:right;">아이디 : ${board.id}</td>
							<td style="text-align:right;">조회 : ${board.cnt}</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:right;">작성시간 : ${board.wdate}</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:center;">내용</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2">${board.content}</td>
							<td></td>
						</tr>
						<c:if test="${board.upfile.fileName != null }">
			               <tr>
			               <c:set value="${board.upfile.fileType}" var="ftype" />
			               <c:set value="${fn:substring(ftype, 0,fn:indexOf(ftype,'/') ) }" var="type"/>
			               
			                  <td colspan="2" style="text-align:left"> 첨부파일 :    
			                     <form name="filedown" method="post" action="/download">      
  			                        <input type="hidden" name="savefilename" value="${board.upfile.saveFileName}">
			                        <input type="hidden" name="filepath" value="${board.upfile.filePath}">   
			                        
			                        
			                        <c:if test="${ type eq 'image'}">
			                           <img width="100px" height="100px" src="/upload/${board.upfile.saveFileName }" />
			                        </c:if>
			                        ${board.upfile.fileName } (사이즈: ${board.upfile.fileSize })    
			                        
			                        <input type="submit" value="다운로드" >                        
			                     </form>
							</td>
						</tr>
						</c:if>
						
					</thead>
				</table>

				<c:if test="${board.id==sess_id }">				
					<form name="boardModifyBtn" method="POST" action="modifyForm">
						<input type="hidden" name="bno" value="${board.bno}">
						<input type="hidden" name="title" value="${board.title}">
						<input type="hidden" name="content" value="${board.content}">
						<input type="hidden" name="cnt" value="${board.cnt}">
						<input type="hidden" name="wdate" value="${board.wdate }">
						<input type="hidden" name="writer" value="${board.id}">
						<input type="submit" class="button button1" value="수정">
						
						<input type="hidden" name="fileNo" value="${board.upfile.fileNo}">
						<input type="hidden" name="saveFileName" value="${board.upfile.saveFileName}">
						<input type="hidden" name="fileName" value="${board.upfile.fileName}">
						<input type="hidden" name="fileSize" value="${board.upfile.fileSize}">
						<input type="hidden" name="fileType" value="${board.upfile.fileType}">
					</form>
					<form name="boardDelBtn" method="POST" action="delete" onsubmit='return checkDelYesno()'>
						<input type="hidden" name="bno" value="${board.bno}">
						<input type="hidden" name="saveFileName" value="${board.upfile.saveFileName}">
						
						<input type="submit" class="button button1" value="삭제">
					</form>
				</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>
    
</body>
</html>