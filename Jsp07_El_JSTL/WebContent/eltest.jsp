<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.eljstl.score.Score" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Score sc = (Score)request.getAttribute("dto");
%>
<table>
	<tr>
		<th colspan="2"><%=sc.getName() %></th>
	</tr>
	<tr>
		<th>국어</th>
		<td>${dto.kor}</td>
	</tr>
	<tr>
		<th>영어</th>
		<td>${dto.eng}</td>
	</tr>
	<tr>
		<th>수학</th>
		<td>${dto.math}</td>
	</tr>
	<tr>
		<th>총점</th>
		<td>${(dto.kor+dto.eng+dto.math) }점</td>
	</tr>
</table>
	
	
</body>
</html>