package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/join1")
public class JoinServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<h3>호갱님죄송합니다.[잘못된요청방식(405)]</h3>");
		out.println("<a href='05-03.form1.html'>가입하기</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 * 1.파라미터받기
		 */
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String gender=request.getParameter("gender");
		String[] favorites=request.getParameterValues("favorite");
		if(favorites==null){
			favorites=new String[0];
		}
		String birthday=request.getParameter("birthday");
		String message=request.getParameter("message");
		
		/*
		 * 2.업무시행(Service객체메쏘드호출)
		 */
		
		/*
		 * 3.클라이언트로 응답출력
		 */
		out.println("<h1>가입정보</h1>");
		out.printf("<ul>");
		out.printf("<li>아이디:%s</li>",id);
		out.printf("<li>이메일:%s</li>",email1+"@"+email2);
		out.printf("<li>성별:%s</li>", gender);
		out.printf("<li>생일:%s</li>", birthday);
		out.printf("<li>가입인사:%s</li>", message);
		out.printf("<li>관심사");
		out.printf("<ul>");
		for(String favorite:favorites) {
			out.printf("<li>%s</li>", favorite);
		}		
		out.printf("</ul>");
		out.print("</li>");
		out.printf("</ul>");
		out.printf("<a href='05-03.form1.html'>가입폼</a>");
		
		
	}
}