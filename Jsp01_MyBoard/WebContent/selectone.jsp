<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import=" com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoard" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- list페이지에서 넘어오는 myno라는 이름의 patameter를 잘 받아 일치하는 데이터를 조회하여 출력-->
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoard dto = dao.selectOne(myno);
	
%>
<h1>SELECT ONE PAGE</h1>
<table>
	<tr>
		<th>NAME</th>
		<td><%=dto.getMyname() %></td>
	</tr>
	<tr>
		<th>TITLE</th>
		<td><%=dto.getMytitle() %></td>
	</tr>
	<tr>
		<th>CONTENT</th>
		<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getMycontent() %></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<button onclick="location.href='myupdate.jsp?myno=<%=dto.getMyno()%>'">수정</button>&nbsp;&nbsp;
			<button onclick="">삭제</button>&nbsp;&nbsp;
			<button onclick="location.href='mylist.jsp'">목록</button>
		</td>
	</tr>
	
</table>
</body>
</html>








