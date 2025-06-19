<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.board.dao.*" %>
<%@ page import="com.board.dto.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db에 저장된 데이터를 모두 조회하여 화면에 목록으로 보여준다. -->

<%
	BoardDao dao = new BoardDao();
	List<BoardDto> list = dao.selectAll();
%>
<h1>List</h1>
<table>
	<col width="30px"><col width="50px"><col width="100px"><col width="300px"><col width="100px">
	<tr>
		<th><input type="checkbox"></th>
		<th>SEQ</th>
		<th>WRITER</th>
		<th>TITLE</th>
		<th>DATE</th>
	</tr>
<%
	if(list.size()==0){
		//조회한 게시글이 없다.
%>
	<tr>
		<td colspan="5">-----글이 존재하지 않습니다.-----</td>
	</tr>
<%
	}else{
		//조회한 데이터를 화면에 출력
		for(BoardDto dto : list){
%>
	<tr>
		<td><input type="checkbox"></td>
		<td><%=dto.getSeq() %></td>
		<td><%=dto.getWriter() %></td>
		<td><a href="boarddetail.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
		<td><%=dto.getRegdate() %></td>
	</tr>
<%					
		}
	}
%>
</table>
</body>
</html>



















