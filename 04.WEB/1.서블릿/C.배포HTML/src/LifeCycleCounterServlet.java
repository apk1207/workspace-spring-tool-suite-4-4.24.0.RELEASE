package lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifeCycleCounterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("3.doGet:GET 요청시마다 실행");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;>");
		out.println("<center>		");
		out.println("현재까지의 접속자수");
		out.println("<font color=#0000FF>");
		out.println("3");
		out.println("</font>");
		out.println("명입니다 ");
		out.println("</center> ");
		out.println("</body> ");
		out.println("</html>");

	}

	@Override
	public void destroy() {
		System.out.println("4.destroy: 서블릿객체가 메모리에서 해제될때호출");
	}
}
