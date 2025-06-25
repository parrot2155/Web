package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dto.MyMVCDto; 
import com.mvc.service.MyMVCService;
import com.mvc.service.MyMVCServiceImpl;


@WebServlet("/MyMVCServlet")
public class MyMVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		MyMVCService service = new MyMVCServiceImpl();
		
		if(command.equals("list")) {
			List<MyMVCDto> list = service.selectAll();
			
			request.setAttribute("list", list);
			RequestDispatcher disp = request.getRequestDispatcher("boardlist.jsp");
			disp.forward(request, response);
			
		}else if(command.equals("detail")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MyMVCDto dto = service.selectOne(seq);
			
			request.setAttribute("dto", dto);
			RequestDispatcher disp = request.getRequestDispatcher("boarddetail.jsp");
			disp.forward(request, response);
			
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
