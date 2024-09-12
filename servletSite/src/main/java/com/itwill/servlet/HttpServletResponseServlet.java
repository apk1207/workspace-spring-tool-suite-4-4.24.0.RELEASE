package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class HttpServletResponseServlet extends HttpServletRequestServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 * http://192.168.15.31/servletSite/response?cmd=1
		 * http://192.168.15.31/servletSite/response?cmd=2
		 * http://192.168.15.31/servletSite/response?cmd=3
		 * http://192.168.15.31/servletSite/response?cmd=234535
		 * http://192.168.15.31/servletSite/response?cmd=    ==> ""
		 * http://192.168.15.31/servletSite/response         ==> null
		 */
		String cmd=request.getParameter("cmd");
		if(cmd==null || cmd.equals("")) {
			response.sendRedirect("04.HttpServletResponse.html");
			return;
		}
		
		
		if(cmd.equals("normal")) {
			/*
			 * 정상응답
			 *   1.응답라인(상태코드 200)
			 *   2.응답헤더
			 *   3.응답바디데이타전송
			 */
			out.println("<h3>정상응답</h3>");
		}else if(cmd.equals("error")) {
			/*
			 * 에러응답
			 *   1.응답라인(상태코드 4xx,5xx)
			 *   2.응답헤더
			 *   3.응답바디데이타없음(보낼수없음)
			 */
			//response.sendError(HttpServletResponse.SC_NOT_FOUND);
			//response.sendError(500);
			response.sendError(403);
			
		}else if(cmd.equals("redirect")) {
			/*
			 * redirect[방향재지정]응답
			 * 	1. 응답라인 상태코드 302
			 *  2. 응답헤더[Location:index.html(redirection url) 이포함]
			 *  3. 응답바디데이타없음(보낼수없음)
			 */
			response.sendRedirect("./index.html");
		}else {
			
		}
		
	}
}