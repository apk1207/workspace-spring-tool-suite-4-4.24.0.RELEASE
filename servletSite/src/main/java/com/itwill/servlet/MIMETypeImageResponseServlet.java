package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/response_image")
public class MIMETypeImageResponseServlet extends HelloServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		/*
		 * 응답객체에 MIME 타입설정
		 */
		response.setContentType("image/jpeg");
		OutputStream out=response.getOutputStream(); 
		String imageFilePath="C:\\2024-07-JAVA-DEVELOPER\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\servletSite\\src\\main\\webapp\\image\\album.jpg";
		FileInputStream fis=new FileInputStream(imageFilePath);
		
		
		while(true) {
			int readByte = fis.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		fis.close();
		out.close();
		
	}
}