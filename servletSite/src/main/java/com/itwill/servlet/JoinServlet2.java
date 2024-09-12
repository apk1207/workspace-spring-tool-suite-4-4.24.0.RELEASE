package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class JoinServlet1
 */

@WebServlet("/join2")
public class JoinServlet2 extends HttpServlet {
	
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * GET 방식으로 요청이 들어오면 05-03.form2.html로 방향재지정 (redirection)
   			response.sendRedirect("05-03.form2.html");
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<h3>호갱님죄송합니다.[잘못된요청방식(405)]</h3>");
		out.println("<a href='05-03.form2.html'>회원가입</a>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 응답객체 MIME타입 인코딩설절
		 */
		response.setContentType("text/html;charset=UTF-8");

		/*
		 * 응답스트림생성
		 */
		PrintWriter out = response.getWriter();

		/*
		 * 0.요청객체인코딩설절
		 */
		request.setCharacterEncoding("UTF-8");

		/*
		 * 1.파라메타받기
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String gender=request.getParameter("gender");
		String job=request.getParameter("job");
		String[] hobbys=request.getParameterValues("hobby");
		if(hobbys==null){
			hobbys=new String[] {"없음"};
		}
		
		// 총 항목수 조회
		int totLenth = 6 + hobbys.length;
		/*
		 * 2.Service객체 가입메쏘드호출
		 */

		
		/*
		 * 3.클라이언트로 응답 출력
		 */
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<style type='text/css'>");
		out.println("table{");
		out.println("width: 500px;");
		out.println("margin: 10px auto 0px auto;");
		out.println("}");
		out.println("td, tr, th {");
		out.println("	border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h3 align='center'>가입정보결과</h3>");
		out.println("<table width='50%'>");
		out.println("		<tr>");
		out.println("			<th width='30%'>항목</th>");
		out.println("			<th width='50%'>입력값</th>");
		out.println("			<th width='20%' >비고</th>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>아이디</td>");
		out.println("			<td>"+id+"</td>");
		out.println("			<td rowspan="+totLenth+"></td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>패쓰워드</td>");
		out.println("			<td>"+pass+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>이름</td>");
		out.println("			<td>"+name+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>주소</td>");
		out.println("			<td>"+addr+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>성별</td>");
		out.println("			<td>"+gender+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>직업</td>");
		out.println("			<td>"+job+"</td>");
		out.println("		</tr>");
		
		out.println("		<tr>");
		out.println("			<td rowspan="+hobbys.length+">취미</td>");
		out.println("			<td>"+hobbys[0]+"</td>");
		out.println("		</tr>");	
		for(int i = 1; i<hobbys.length;i++) {
			out.println("		<tr>");
			out.println("			<td>"+hobbys[i]+"</td>");
			out.println("		</tr>");
		}
		
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");

	}

}