package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/get_login")
public class GetLoginServlet extends HttpServlet {
	/*
	 * service  GET,POST요청에 의해 실행되는 메쏘드
	 * doGet	GET요청에 의해 실행되는 메쏘드
	 * doPost	POST요청에 의해 실행되는 메쏘드 
	 */
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		/*
		 * 1. 요청시 전송되는 파라미터받기
		 *    - 파라미터 이름은 iput element의 name속성의 값
		 *      <form action="get_login" method="get">
					아이디:<input type="text" name="id"><br/>
					패에쓰:<input type="password" name="pass"><br/><br/>
				</form>
		 */
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		if(id==null || pass==null || id.equals("") || pass.equals("")) {
			response.sendRedirect("05-01.login_get.html");
			return;
		}
		/*
		 * 2. 서비스 객체를 사용해서 업무(로그인실행)
		 */
		/*
		 ---------
		  id | pass
		 ----------
		 xxxx| 1111
		 yyyy| 2222
		 ----------
		 */
		
		// DB 대신 임시로 2개의 계정 지정하여 테스트
		
		
		boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
		boolean isMember2 = id.equals("yyyy") && pass.equals("2222");
		
		
		/*
		 * 3. 클라이언트로 출력
		 */
		out.println("<h1>GET 로그인 결과</h1><hr>");
		if(isMember1 || isMember2) {
			out.println("<h3>"+id+"님 로그인성공</h3>");
			out.println("<a href='index.html'>메인으로</a>");
		}else {
			out.println("<h3>"+id+"님 로그인실패</h3>");
			out.println("<a href='05-01.login_get.html'>메인으로</a>");
		}
		
		
		
		
		
		
	}
}