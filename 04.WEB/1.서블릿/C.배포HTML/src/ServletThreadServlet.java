package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletThreadServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>서블릿쓰레드</title>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>ServletThreadServlet[Dynamic Resource]실행쓰레드</h5>");
		out.println("<hr>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
