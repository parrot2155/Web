package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.dao.BikeDao;
import com.test.dto.BikeDto;


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
			new BikeDao().deleteAll();
			
			
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
			              
			List<BikeDto> list = new ArrayList<>();
			for(int i=0;i<element.getAsJsonObject().get("DATA").getAsJsonArray().size();i++) {
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				
				//System.out.println(tmp);
				//System.out.println(tmp.get("new_addr").getAsString());
				
				String addr_gu = tmp.get("addr_gu").getAsString();
				int content_id = tmp.get("content_id").getAsInt();
				String content_nm = tmp.get("content_nm").getAsString();
				String new_addr = tmp.get("new_addr").getAsString();
				int cradle_count = tmp.get("cradle_count").getAsInt();
				double longitude = tmp.get("longitude").getAsDouble();
				double latitude = tmp.get("latitude").getAsDouble();
				
				
				BikeDto dto = new BikeDto();
				dto.setAddr_gu(addr_gu);
				dto.setContent_id(content_id);
				dto.setContent_nm(content_nm);
				dto.setNew_addr(new_addr);
				dto.setCradle_count(cradle_count);
				dto.setLatitude(latitude);
				dto.setLongitude(longitude);
				
				list.add(dto);
				
				
			}
			
			int res = new BikeDao().insert(list);
			if(res==list.size()) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
			PrintWriter out = response.getWriter();
			out.println(res);
			
			
		}else if(command.equals("first_db")) {
			 String[] bikeList = request.getParameterValues("bike");
			 System.out.println("bike리스트의 크기: "+ bikeList.length);
			 List<BikeDto> list = new ArrayList<>();
			 for(int i=0;i<bikeList.length;i++) {
				 String[] tmp = bikeList[i].split("/");
				 BikeDto dto = new BikeDto();
				 dto.setAddr_gu(tmp[0]);
				 dto.setContent_id(Integer.parseInt(tmp[1]));
				 dto.setContent_nm(tmp[2]);
				 dto.setNew_addr(tmp[3]);
				 dto.setCradle_count(Integer.parseInt(tmp[4]));
				 dto.setLongitude(Double.parseDouble(tmp[5]));
				 dto.setLatitude(Double.parseDouble(tmp[6]));
				 
				 list.add(dto);
			 }
			 new BikeDao().deleteAll();
			 int res = new BikeDao().insert(list);
			 if(res>0) {
				 System.out.println("insert 성공");
				 response.sendRedirect("index.html");
			 }else {
				 System.out.println("insert 실패");
				 response.sendRedirect("bike01.js");
			 }
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
