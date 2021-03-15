<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<link rel="stylesheet" href="/css/w3.css">
<link rel="stylesheet" href="/css/index.css">

<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
  <!-- Avatar image in top left corner -->
  <img src="/img/bellinger.jpg" style="width:100%">
  <a href="/" class="w3-bar-item w3-button w3-padding-large w3-black">
    <i class="fa fa-home w3-xxlarge"></i>
    HOME
  </a>
  <a href="/member/memRegForm" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
    <i class="fa fa-eye w3-xxlarge"></i>
    회원가입
  </a>
  <a href="/notice/list" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
    <i class="fa fa-bomb w3-xxlarge"></i>
    공지사항
  </a>
  <a href="/board/list" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
    <i class="fa fa-bold w3-xxlarge"></i>
    게시판
  </a>
  <a href="/tboard/list" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
    <i class="fa fa-trophy w3-xxlarge"></i>
    경기게시판
  </a>
  
  <c:set value="${sess_name}" var="sessName"/>
  
	  <c:if test="${sessName !=NULL }">
	  	<a href="/member/logOut" onclick="#" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
	    <i class="fa fa-user w3-xxlarge"></i>
	    로그아웃
	    </a>
	    <a href="/member/myPage" onclick="#" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
	    <i class="fa fa-info w3-xxlarge"></i>
	    회원정보
	    </a>
	    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
	    ${sessName}님 반갑습니다.
	    </a>
	  </c:if>
  
	  <c:if test="${sessName ==NULL }">
		  <a href="#login_modal" onclick="login_layer_open()" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
		    <i class="fa fa-user w3-xxlarge"></i>
		    로그인
		  </a>
	  </c:if>	
</nav>
