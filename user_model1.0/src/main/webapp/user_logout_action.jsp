<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
    
<%@ include file="user_login_check.jspf" %>

<%
	//로그아웃을 위해 세션정보`초기화
	session.invalidate();
	response.sendRedirect("user_main.jsp");

%>