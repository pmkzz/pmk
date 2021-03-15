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
<style>
input[type=text]{
	width:500px;	
	height:30px;
	float:left;
}
textarea{
	width:100%;
	height:300px;
	float:left;
}
input[type=submit], [type=button]{
background-color:orange;
border:0px solid #FFF;
color:white;
float:right;
width:80px;
height:50px;
font-size:20px;
margin: 10px;
}

</style>

<body class="w3-black">
<%@ include file="../NavTop.jsp" %>
<%@ include file="../SideBar.jsp" %>
<div class="w3-padding-large" id="main">
  <!-- Header/Home -->
	<header class="w3-container w3-padding-32 w3-black" id="home">
	</header>
	<div class="content" style="width:100%; padding:100px;">
		<div class="main">
			<div class="card">
				<h2>게시판 수정</h2>
				
				<form name="borad" method="post" action="modify" enctype="multipart/form-data" onsubmit="return boardFormCheck()">
					<input type="hidden" name="bno" value="${board.bno}">
					<input type="hidden" name="cnt" value="${board.cnt}">
					<input type="hidden" name="wdate" value="${board.wdate}">
					<input type="hidden" name="writer" value="${board.id}">
					
					<input type="text" name="title" value="${board.title}" >
	
					<textarea name="content" placeholder="내용">${board.content}</textarea>
					
					<c:choose>
				 		<c:when test="${!empty uploadFile.fileName}">
						 	<c:set value="${uploadFile.fileType}" var="ftype" />
							<c:set value="${fn:substring(ftype, 0,fn:indexOf(ftype,'/') ) }" var="type"/>
								
							<div id="file">		
							<c:if test="${ type eq 'image'}">							 						 			
								<img width="100px" height="100px" src="/upload/${uploadFile.saveFileName }" />
							</c:if>	
							${uploadFile.fileName } (사이즈: ${uploadFile.fileSize }) 	
					 		<input type="button" value="파일삭제" onclick="fileDelete('${board.bno}','${uploadFile.saveFileName }')">					 				 				 	
							</div>	
				 		</c:when>
				 		<c:when test="${empty uploadFile.fileName}">
				 			<input type="file" name="files"><br>
				 		</c:when>
				 	</c:choose>	
									
					<input type="submit" value="수정">
				</form>
				
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>
<script>
function fileDelete(bno, savefilename){
	
	var x = new XMLHttpRequest();
	
	x.onreadystatechange = function(){
		if(x.readyState === 4){
			
			if(x.status === 200){

				var tag = document.getElementById("file");					
						
				if(x.responseText.trim() =="0"){
					alert("파일삭제 실패 하였습니다.");
				}				
				else{
					alert("파일삭제 하였습니다.");
					tag.innerHTML = "<input type='file' name='files'>";
				}
								
			}else{
				console.log('에러코드 : '+ x.status);
			}
			
		}
		
	};

//	get방식	
//	x.open("get",root_path + "/idCheck.jsp?id=" + id, true);
//	x.send();

//	post방식
	x.open("POST","/deleteFile", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("bno=" + bno+ "&saveFileName=" +savefilename);
}
</script>
    
</body>
</html>