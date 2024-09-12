package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcServlet1
 */
@WebServlet("/jdbc2")
public class JdbcServlet2 extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			/*
			 * 1.AddressService객체 생성
			 * (매번 생성을해야한다는 단점을 보완할 필요가 있음)
			 */
			
			AddressService addressService = new AddressService();
			
			/*
			 * 2.AddressService객체  addressList 메쏘드실행(DTO의 collection이 봔환됨)
			 */
			List<Address> addressList=addressService.addressList();
			
			/*
			 * 3.클라이언트로 출력 
			 */
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
	
			out.println(
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 2◈◈</font><br>");
			out.println(
					"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			for(Address address:addressList) {
				out.println("<tr class=t1>");
				out.println("<td align=center width=25% height=20>"+address.getNo()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getName()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getPhone()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getAddress()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}// end serivce
}// end class