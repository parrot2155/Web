package com.cboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cboard.dao.CBoardDao;
import com.cboard.dto.CBoardDto;
import com.cmember.dao.CMemberDao;
import com.cmember.dto.CMemberDto;


@WebServlet("/board")
public class CBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CBoardDao cbdao = new CBoardDao();
	CMemberDao cmdao = new CMemberDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		if(command.equals("list")) {
			List<CBoardDto> list = cbdao.selectAll();
			
			CMemberDto loginUser = (CMemberDto) request.getSession().getAttribute("loginUser");
		    String name = loginUser.getName();

		    request.setAttribute("name", name);
		    request.setAttribute("list", list);

		    System.out.println("bc에서 " + name);
			RequestDispatcher dis = request.getRequestDispatcher("boardlist.jsp");
			dis.forward(request, response);
			
		}
			
		else if(command.equals("mypage")) {
		    HttpSession session = request.getSession();
		    CMemberDto user = (CMemberDto) session.getAttribute("loginUser");

		    request.setAttribute("dto", user);

		    RequestDispatcher dis = request.getRequestDispatcher("mypage.jsp");
		    dis.forward(request, response);
			
		}
		else if(command.equals("insertform")) {
			response.sendRedirect("insertform.jsp");
		}
		else if(command.equals("insert")) {
		    String title = request.getParameter("title");
		    String content = request.getParameter("content");
		    
		    HttpSession session = request.getSession();
		    CMemberDto loginUser = (CMemberDto) session.getAttribute("loginUser");
		    String name = loginUser.getName();

		    CBoardDto dto = new CBoardDto();
		    dto.setTitle(title);
		    dto.setContent(content);
		    dto.setName(name);

		    int res = cbdao.insert(dto);

		    if (res > 0) {
		    	System.out.println("글 작성 완료");
		        response.sendRedirect("board?command=list");
		    } else {
		    	System.out.println("글 작성 실패");
		        response.sendRedirect("insertform.jsp");
		    }
		}
		else if(command.equals("detail")) {
			int no = Integer.parseInt(request.getParameter("seq"));
			CBoardDto dto = cbdao.selectOne(no);
			
			request.setAttribute("dto", dto);
		    RequestDispatcher dis = request.getRequestDispatcher("detail.jsp");
		    dis.forward(request, response);
		}
		else if(command.equals("updateform")) {
			int no = Integer.parseInt(request.getParameter("no"));
			 CBoardDto dto = cbdao.selectOne(no);

			 request.setAttribute("dto", dto);
			 RequestDispatcher dis = request.getRequestDispatcher("updateform.jsp");
			 dis.forward(request, response);
		}
		else if(command.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
		    String title = request.getParameter("title");
		    String content = request.getParameter("content");
		    
		    CBoardDto dto = new CBoardDto();
		    dto.setNo(no);
		    dto.setTitle(title);
		    dto.setContent(content);

		    int res = cbdao.update(dto);
			
		    if(res > 0) {
		    	System.out.println("수정 성공");
		        response.sendRedirect("board?command=list");
		    } else {
		    	System.out.println("수정 실패");
		    	response.sendRedirect("board?command=updateform");
		    }
		}
		else if(command.equals("delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			int res = cbdao.delete(no);
			
			if(res>0) {
				System.out.println("삭제 성공");
				response.sendRedirect("board?command=list");
			}else {
				System.out.println("삭제 실패");
				response.sendRedirect("board?command=list");
			}
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
