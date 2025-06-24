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
	MyMemberDto login = (MyMemberDto)session.getAttribute("dto");
	if(login==null){
		pageContext.forward("index.jsp");
	}
	
	MyMemberDto dto = (MyMemberDto)request.getAttribute("dto");	
%>
<div>
	<span><%=login.getMyname() %>님 환영합니다. (등급 : <%=dto.getMyrole() %>)</span>
	<button onclick="location.href='logincontroller.jsp?command=logout'">로그아웃</button>
</div>



<h1>MyPage</h1>
<table>
	<tr>
		<th>아이디</th>
		<td><%=dto.getMyid() %></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><%=dto.getMypw() %></td>
	</tr>
	<tr>
		<th>이 름</th>
		<td><%=dto.getMyname() %></td>
	</tr>
	<tr>
		<th>주 소</th>
		<td><%=dto.getMyaddr() %></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><%=dto.getMyphone() %></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><%=dto.getMyemail() %></td>
	</tr>
	<tr>
		<th>등 급</th>
		<td><%=dto.getMyrole() %></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="수정" onclick="location.href='logincontroller.jsp?command=updateform'">
			<input type="button" value="탈퇴" onclick="location.href='logincontroller.jsp?command=deleteuser'">
		</td>
	</tr>
</table>
</body>
</html>