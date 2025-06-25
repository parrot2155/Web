<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	
	<table>
		<col width="50"><col width="100"><col width="200"><col width="100">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4">-----작성된 글이 존재하지 않습니다.-----</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items="${list }" >
					<tr>
						<td>${dto.seq }</td>
						<td>${dto.writer }</td>
						<td><a href="controller.do?command=detail&seq=${dto.seq }">${dto.title }</a></td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>






















