package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")  // URL 매핑 
public class Add2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setCharacterEncoding("UTF-8");  // 해당 페이지는 UTF-8
		response.setContentType("text/html; charset=UTF-8");  // 브라우저로 보낼 때 UTP-8로 있으라는 것.
		
		PrintWriter out = response.getWriter();
	
		String[] num = request.getParameterValues("num");  // 배열로 받음 
		
		int result = 0;
		
		for(int i=0; i<num.length; i++) {
			result += Integer.parseInt(num[i]);
		}
		
		out.println(result);
	}
}
