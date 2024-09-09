<%@page import="com.itwill.shop.cart.CartService"%>
<%@page import="com.itwill.shop.jumun.Jumun"%>
<%@page import="com.itwill.shop.jumun.JumunService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>    
<%
	/*
	 주문생성
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("jumun_list.jsp");
		return;
	}
	String buyType=request.getParameter("buyType");
	String p_noStr=request.getParameter("p_no");
	String p_qtyStr=request.getParameter("p_qty");
	JumunService jumunService=new JumunService();
	CartService cartService=new CartService();
	
	if(buyType.equals("cart")){
		jumunService.create(sUserId);
	}else if(buyType.equals("direct")){
		jumunService.create(sUserId, Integer.parseInt(p_noStr), Integer.parseInt(p_qtyStr));
		
	}
	response.sendRedirect("jumun_list.jsp");	
%>