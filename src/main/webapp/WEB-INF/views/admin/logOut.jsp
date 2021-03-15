<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션변수 모두 제거
session.invalidate();

response.sendRedirect("../index.jsp");

%>