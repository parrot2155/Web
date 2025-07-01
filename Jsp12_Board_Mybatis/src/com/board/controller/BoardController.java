package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		BoardDao dao = new BoardDao();
		
		if(command.equals("list")) {
			List<BoardDto> list = dao.selectAll();
			
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("boardlist.jsp");
			dis.forward(request, response);
		}
		else if(command.equals("detail")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			BoardDto dto = dao.selectOne(seq);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boarddetail.jsp");
			dis.forward(request, response);
		}
		else if(command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			BoardDto dto = dao.selectOne(seq);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boardupdate.jsp");
			dis.forward(request, response);
		}
		else if(command.equals("update")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDto dto = new BoardDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = dao.update(dto);
			
			if(res>0) {
				System.out.println("수정 성공");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("수정 실패");
				response.sendRedirect("board?command=list");
			}
			
			
		}
		else if(command.equals("writeform")) {
			response.sendRedirect("boardwrite.jsp");
			
		}
		else if(command.equals("insert")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDto dto = new BoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = dao.insert(dto);
			
			if(res>0) {
				System.out.println("insert 성공");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("insert 실패");
				response.sendRedirect("board?command=list");
			}
			
			
		}
		else if(command.equals("muldel")) {
			String[] seq = request.getParameterValues("chk");
			
			
			int res = dao.mulDel(seq);
			
			if(res == seq.length) {
				System.out.println("삭제 성공");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("삭제 실패");
				response.sendRedirect("board?command=lise");
			}

		}
		else if(command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = dao.delete(seq);
			
			if(res>0) {
				System.out.println("삭제 성공");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("삭제 실패");
				response.sendRedirect("board?command=lisr");
			}
			
		}
		
		
		
		
	}

	
	
	
	
}






















