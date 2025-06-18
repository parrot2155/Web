<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoard" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- selectone + update -->
<!-- 1. parameter로 넘어오는 myno를 받아 수정하려는 게시글 정보를 조회해서 출력 -->
<!-- 2. 수정한 정보를 넘겨서(form태그 이용) 업데이트를 진행 -->
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoard dto = dao.selectOne(myno);
%>
<!-- ?myno= -->
<h1>UPDATE PAGE</h1>
<form action="myupdate_res.jsp" method="post">
	<input type="hidden" name="myno" value="<%=dto.getMyno() %>"> <!-- 보이진 않지만 값을 넘겨준다. --> 
	<table>
		<tr>
			<th>NAME</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><input type="text" name="mytitle" value="<%=dto.getMyname() %>"></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" name="mycontent"><%=dto.getMycontent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" >
				<input type="button" value="취소" onclick="location.href='history.back();'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>















