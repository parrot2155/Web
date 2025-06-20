<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
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
	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto");
%>
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
</body>
</html>