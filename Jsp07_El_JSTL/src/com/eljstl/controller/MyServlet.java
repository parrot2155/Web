package com.eljstl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eljstl.score.Score;


@WebServlet("/myservlet.do")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command.equals("eltest")) {
			Score sc = new Score("박태욱", 100, 77, 56);
			request.setAttribute("dto", sc);
			RequestDispatcher disp = request.getRequestDispatcher("eltest.jsp");
			disp.forward(request, response);
		}else if(command.equals("jstltest")) {
			List<Score> res = new ArrayList<>();
			for(int i=1;i<6;i++) {
				Score tmp = new Score("이름"+i, 90+i, 80+i*2, 60+i*3);
				res.add(tmp);
			}
			request.setAttribute("list", res);
			RequestDispatcher disp = request.getRequestDispatcher("jstlpage.jsp");
			disp.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
