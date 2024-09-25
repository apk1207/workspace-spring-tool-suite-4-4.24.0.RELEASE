
<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	/*
	0  . GET방식요청일때 user_login_form.jsp로 redirection
	1  . 요청객체 인코딩설정
	2  . 파라메타 받기
	3  . UserService객체생성
	4  . UserService.login() 메쏘드실행
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	String userId=request.getParameter("userId"); 
	String password=request.getParameter("password"); 
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	int result= new UserService().login(userId, password);
    if(result==0){
    	//0:아이디존재안함
    	/***********case1 script********************/
		/***********case2 redirect******************/
		String msg1=userId+" 는 존재하지않는 아이디입니다.";
    	msg1=URLEncoder.encode(msg1, "UTF-8");
    	String queryString ="msg1="+msg1+"&userId="+userId+"&password="+password;
		response.sendRedirect("user_login_form.jsp?"+queryString);
		/***********case3 forward*******************/
    }else if(result==1){
    	//1:패쓰워드 불일치
    	
    	/***********case1 script********************/
		/***********case2 redirect******************/
		String msg2="패쓰워드가 일치하지않습니다.";
    	msg2=URLEncoder.encode(msg2, "UTF-8");
    	String queryString ="msg2="+msg2+"&userId="+userId+"&password="+password;
    	response.sendRedirect("user_login_form.jsp?"+queryString);
		/***********case3 forward*******************/
		    	
    }else if(result==2){
    	//2:로그인성공(세션)
    	session.setAttribute("sUserId", userId);
    	response.sendRedirect("user_main.jsp");
    }
%>