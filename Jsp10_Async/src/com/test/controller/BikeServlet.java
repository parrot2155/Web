package com.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@WebServlet("/bike.do")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
			
		}else if(command.equals("second")) {
			response.sendRedirect("bike02.jsp");
			
			
		}else if(command.equals("second_db")) {
			String obj = request.getParameter("obj");
			//System.out.println(obj);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(obj);
			
			//DATA의 첫번째 방에 저장된 json데이터 new_addr값 저장하기
			String str = element.getAsJsonObject().get("DATA").getAsJsonArray().get(0).getAsJsonObject().get("new_addr").getAsString();
			//System.out.println(str);
			
			
			//DESCRIPTION이 가지는 data의 ADDR_GU의 값을 저장하기
			String ss = element.getAsJsonObject().get("DESCRIPTION").getAsJsonObject().get("ADDR_GU").getAsString();
			System.out.println(ss);
			
			for(int i=0;i<element.getAsJsonObject().get("DATA").getAsJsonArray().size();i+=300) {
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				
				//System.out.println(tmp);
				//System.out.println(tmp.get("new_addr").getAsString());
			}
			
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
