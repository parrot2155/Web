package com.hello.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi") //어노테이션 방식을 사용하면 web.xml에서 별도로 매핑을 하지 않아도 된다.

public class HelloController extends HttpServlet{
	
	private String contextParam;
	private String initParam;
	
	public HelloController() {
		System.out.println("HelloController 서블릿 생성자");
	}
	
	@Override
	public void init(ServletConfig config) {
		//서블릿 객체가 생성될 떄 초기화할 수 있는 메소드
		contextParam = config.getServletContext().getInitParameter("url");
		System.out.println(contextParam);
		
		initParam = config.getInitParameter("id");
		System.out.println("initParam: "+initParam);
		
		
		
	}
	
	
	//hello라는 요청이 get방식으로 넘어오면 실행됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get 방식");
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='background-color:skyblue;'>HelloServlet</h1>");
		out.println("<span>서블릿 연습</span>");
		out.println("<span><b>"+contextParam+"</b></span>");
		out.println("<span><s>"+initParam+"</s></span>");
		out.print("<a href='home.html'>돌아가기</a>");
		
	}
	
	//hello라는 요청이 post방식으로 넘어오면 실행됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//한글 깨짐 방지 
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("post 방식");
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		response.sendRedirect("Test.jsp");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet 종료");
	}
	
}
