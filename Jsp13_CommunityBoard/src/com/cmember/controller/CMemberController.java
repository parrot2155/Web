package com.cmember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cboard.dao.CBoardDao;
import com.cmember.dao.CMemberDao;
import com.cmember.dto.CMemberDto;


@WebServlet("/member")
public class CMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CBoardDao cbdao = new CBoardDao();
	CMemberDao cmdao = new CMemberDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		if(command.equals("login")) {
			String id = request.getParameter("id");
		    String pw = request.getParameter("pw");
		    CMemberDto dto = cmdao.login(id, pw);
		    
		    if(dto != null) {
		    	//System.out.println("mc에서"+dto.getName());
		    	request.getSession().setAttribute("loginUser", dto);
		        response.sendRedirect("board?command=list");
		        
		    }else {
		        System.out.println("로그인 실패.");
		        response.sendRedirect("index.jsp");
		    }
		        
		}else if(command.equals("signupform")) {
			response.sendRedirect("signupform.jsp");
			
		}else if(command.equals("signup")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				
				CMemberDto dto = new CMemberDto();
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setPhone(phone);
				
				int res = cmdao.signup(dto);
				
				if(res>0) {
					System.out.println("회원가입 성공");
					response.sendRedirect("index.jsp");
				}else {
					System.out.println("회원가입 실패");
					response.sendRedirect("index.jsp");
				}
				
		}else if(command.equals("logout")) {
			HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            System.out.println("로그아웃 되었습니다.");
            response.sendRedirect("index.jsp");
            
        }else if(command.equals("deleteuser")) {
        	HttpSession session = request.getSession();
        	CMemberDto loginUser = (CMemberDto) session.getAttribute("loginUser");
        	
        	String id = loginUser.getId();

            int res = cmdao.deleteUser(id);
            
            if(res>0) {
            	System.out.println("회원 탈퇴 완료");
            	response.sendRedirect("index.jsp");
            }else {
            	System.out.println("회원 탈퇴 실패");
            	response.sendRedirect("index.jsp");
            }
        	
        	
        }
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}












