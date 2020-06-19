package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")  // URL 매핑 
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ServletContext application = request.getServletContext();  // 어플리케이션 객체 
		HttpSession session = request.getSession();  // 세션 객체 
		Cookie[] cookies = request.getCookies();  // 쿠키 객체 
		
		
		response.setCharacterEncoding("UTF-8");  // 해당 페이지는 UTF-8
		response.setContentType("text/html; charset=UTF-8");  // 브라우저로 보낼 때 UTP-8로 있으라는 것.
		
		PrintWriter out = response.getWriter();
	
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		

		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		if(op.equals("=")) {
			
			//int x = (Integer)application.getAttribute("value"); 
			//int x = (Integer)session.getAttribute("value"); 
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			response.getWriter().printf("result is %d\n", result);
		}
		else {
			// 어플리케이션 객체를 이용한 값 유지 
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(60*60);  // 1시간 간 쿠키 유지 
			opCookie.setPath("/calc2");

			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");  // Page Redirection 
		}

	}
}
