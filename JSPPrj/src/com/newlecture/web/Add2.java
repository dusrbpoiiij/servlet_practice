package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")  // URL ���� 
public class Add2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setCharacterEncoding("UTF-8");  // �ش� �������� UTF-8
		response.setContentType("text/html; charset=UTF-8");  // �������� ���� �� UTP-8�� ������� ��.
		
		PrintWriter out = response.getWriter();
	
		String[] num = request.getParameterValues("num");  // �迭�� ���� 
		
		int result = 0;
		
		for(int i=0; i<num.length; i++) {
			result += Integer.parseInt(num[i]);
		}
		
		out.println(result);
	}
}