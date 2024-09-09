<%@page import="com.itwill.shop.jumun.JumunService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
1.주문번호받기
2.주문삭제
  	- 주문상세테이블 delete
  	- 주문테이블 delete
*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("jumun_list.jsp");
		return;
	}
	String j_noStr=request.getParameter("j_no");
	JumunService jumunService=new JumunService();
	jumunService.delete(Integer.parseInt(j_noStr));
	response.sendRedirect("jumun_list.jsp");
%>