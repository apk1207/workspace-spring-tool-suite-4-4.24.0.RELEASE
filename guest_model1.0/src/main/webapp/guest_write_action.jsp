<%@page import="com.itwill.guest.GuestService"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//GET방식이면 guest_main.jsp redirection
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("guest_main.jsp");
	return;
}  	
	
//0.요청객체encoding설정
request.setCharacterEncoding("UTF-8");

//1.파라메타받기(guest_name,guest_email,guest_homepage,guest_title,guest_content) Guest객체생성
String name = request.getParameter("guest_name");
String email = request.getParameter("guest_email");
String homepage = request.getParameter("guest_homepage");
String title = request.getParameter("guest_title");
String content = request.getParameter("guest_content");

Guest guest = Guest.builder()
					.guestName(name)
					.guestEmail(email)
					.guestHomepage(homepage)
					.guestTitle(title)
					.guestContent(content)
					.build();


//2.GuestService객체생성
GuestService guestService = new GuestService();

//3.GuestService객체 guestWrite(Guest객체) 메쏘드호출
guestService.guestWrite(guest);

//4.guest_list.jsp로 redirection
response.sendRedirect("guest_list.jsp");

%>