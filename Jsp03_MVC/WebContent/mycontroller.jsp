<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.mvc.dao.MVCBoardDao" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//뷰에서 요청한 내용이 무엇인지 확인할 수 있는 parameter 값
	String command = request.getParameter("command");
	
	System.out.println("[command: "+command+"]");
	MVCBoardDao dao = new MVCBoardDao();
	
	if(command.equals("boardlist")){
		//필요 데이터 준비하고 해당하는 페이지로 전환한다.
		
		//1.필요데이터 준비
		List<MVCBoardDto> res = dao.selectAll();
		
		//2. list페이지로 이동(준비된 데이터와함께)
		request.setAttribute("allList",res);
		
		pageContext.forward("boardlist.jsp");
		//화면의 흐름을 제어하는 방법, 페이지 이동하는 방법
		//foward : request에 담긴 값이 유지된다. req, res객체가 유지.
		//			<jsp:forward>, pageContext.forward(jsp내에서), requestDispatcher객체(서블릿)
		//redirect : 클라이언특 새로운 페이지를 요청한 것과 같은 방식으로 페이지 이동.
		//			response.sendRedirect
	}else if(command.equals("boarddetail")){
		//필요데이터 준비 후 화면 전환
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto res = dao.selectOne(seq);
		
		request.setAttribute("dto",res);
		pageContext.forward("boarddetail.jsp");
	}else if(command.equals("boardinserform")){
		response.sendRedirect("boardinsert.jsp");
		
	}else if(command.equals("boardinsert")){
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	}
	
%>
</body>
</html>







