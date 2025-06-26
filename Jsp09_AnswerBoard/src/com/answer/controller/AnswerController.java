package com.answer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.dto.AnswerDto;
import com.answer.service.AnswerService;


@WebServlet("/answer")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		AnswerService service = new AnswerService();
		
		
		
		
		
		if(command.equals("list")) {
			List<AnswerDto> list = service.selectAll(); 
			
			request.setAttribute("list", list);
			disp("boardlist.jsp", request, response);
			
		}else if(command.equals("writeform")) {
			response.sendRedirect("boardwrite.jsp");
			
		}else if(command.equals("boardwrite")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			
			dto.setTitle(title);
			dto.setContent(content);
			dto.setWriter(writer);
			
			int res = service.insert(dto);
			
			if(res>0) {
				request.setAttribute("msg", "게시글 작성 성공");
				request.setAttribute("url", "answer?command=list");
			}else {
				request.setAttribute("msg", "게시글 작성 실패");
				request.setAttribute("url", "answer?command=writeform");
			}
			disp("result.jsp", request, response);
			
		}else if(command.equals("detail")) {
			//1. 전달받은 parameter 활용하여 데이터 select 한다.
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = service.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			
			//2. boarddetail.jsp페이지로 응답
			disp("boarddetail.jsp", request, response);

			//3. 해당 페이지에서 준비된 데이터 화면에 출력(글번호, 작성자, 작성일, 제목, 내용)
			
			
			
			
			
		}
		
		
		
		
		

	}
	
	
	
	
	
	
	public void disp(String url, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
