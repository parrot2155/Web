<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.login.dto.MyMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyMemberDto dto = (MyMemberDto)request.getAttribute("selectOne");
%>
<h1>Update Role Page</h1>
<form action="logincontroller.jsp" method="post">
<input type="hidden"  name="command" value="updaterole">
<input type="hidden" name="myno" value="<%=dto.getMyno() %>">
	<table>
		<col width="50"><col width="200">
		<tr>
			<th>번 호</th>
			<td><%=dto.getMyno() %></td>
		</tr>
		<tr>
			<th>이 름</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>등 급</th>
			<td>
				<select name="myrole">
					<option value="USER" <%=dto.getMyrole().equals("USER")?"selected":"" %>>일반회원</option>
					<option value="MANAGER" <%=dto.getMyrole().equals("MANAGER")?"selected":"" %>>매니저</option>
					<option value="ADMIN" <%=dto.getMyrole().equals("ADMIN")?"selected":"" %>>관리자</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="변경완료">
			</td>
		</tr>
	</table>
</form>
</body>
</html>