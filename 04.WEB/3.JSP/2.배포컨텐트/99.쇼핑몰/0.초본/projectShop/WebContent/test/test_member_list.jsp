<%@page import="com.itwill.shop.member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.member.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberService memberService=new MemberService();
	ArrayList<Member> memberList=memberService.list();
	//System.out.println(memberList);
	for(Member m:memberList){
		System.out.println(m);
		
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(Member m:memberList){
%>	
	<li><%=m.getNo() %>,<%=m.getName() %>,<%=m.getAddress() %></li>	
<%		
	}
%>
</body>
</html>