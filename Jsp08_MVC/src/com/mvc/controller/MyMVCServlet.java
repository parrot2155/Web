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
			
		}else if(command.equals("writeform")) {
			response.sendRedirect("boardwrite.jsp");
			
		}else if(command.equals("boardwrite")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			MyMVCDto dto = new MyMVCDto(0,writer,title,content,null);
			boolean res = service.insert(dto);
			
			if(res) {
				request.setAttribute("msg", "글 작성 성공");
				request.setAttribute("url", "controller.do?command=list");
			}else {
				request.setAttribute("msg", "글 작성 실패");
				request.setAttribute("url", "controller.do?command=writeform");
			}
			
			RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
			disp.forward(request, response);
			
		}else if(command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			MyMVCDto dto = service.selectOne(seq);
			
			request.setAttribute("dto", dto);
			RequestDispatcher disp = request.getRequestDispatcher("boardupdate.jsp");
			disp.forward(request, response);
			
		}else if(command.equals("boardupdate")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MyMVCDto dto = new MyMVCDto(seq,null,title,content,null);
			boolean res = service.update(dto);
			
			if(res) {
				request.setAttribute("msg", "글 수정 성공");
				request.setAttribute("url", "controller.do?command=list");
			}else {
				request.setAttribute("msg", "글 수정 실패");
				request.setAttribute("url", "controller.do?command=updateform&seq="+seq);
			}
			RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
			disp.forward(request, response);
			
		}else if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			boolean res = service.delete(seq);
			
			if(res) {
				request.setAttribute("msg", "글 삭제 성공");
				request.setAttribute("url", "controller.do?command=list");
			}else {
				request.setAttribute("msg", "글 삭제 실패");
				request.setAttribute("url", "controller.do?command=detail&seq="+seq);
			}
			RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
			disp.forward(request, response);
			
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
