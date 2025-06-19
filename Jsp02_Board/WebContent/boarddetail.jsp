<%@page import="com.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.board.dao.BoardDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- parameter로 넘어오는 seq값을 받아 db에서 일치하는 게시글을 조회하여 화면에 출력 -->
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.selectOne(seq);
%>
<div>
	<h1>Detail</h1>
	<table>
		<tr>
			<th>SEQ</th>
			<td><%=dto.getSeq() %></td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>DATE</th>
			<td><%=dto.getRegdate() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="40" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
	</table>
</div>
	
	
	
	
	
</body>
</html>

















