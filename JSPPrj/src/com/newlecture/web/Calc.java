package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")  // URL 매핑 
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setCharacterEncoding("UTF-8");  // 해당 페이지는 UTF-8
		response.setContentType("text/html; charset=UTF-8");  // 브라우저로 보낼 때 UTP-8로 있으라는 것.
		
		PrintWriter out = response.getWriter();
	
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("operator");
		
		int result = 0;
		
		if(op.equals("덧셈"))
			result = num1 + num2;
		else 
			result = num1 - num2;
		
		out.println(result);
	}
}
