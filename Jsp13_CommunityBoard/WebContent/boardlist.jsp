<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
    <span>사용자 :  ${name}님</span>
    <button onclick="location.href='member?command=logout'">로그아웃</button>
    <button onclick="location.href='board?command=mypage'">마이페이지</button>
  </header>
	<h1>글 목록</h1>
	<table>
	<tr>
		<th>번 호</th>
		<th>작성자</th>
		<th>제 목</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.no }</td>
		<td>${dto.name }</td>
		<td><a href='board?command=detail&seq=${dto.no }'>${dto.title }</a></td>
    	<td><fmt:formatDate value="${dto.regdate}" pattern="yy년MM월dd일" /></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4">
			<button onclick="location.href='board?command=insertform'">글쓰기</button>
		</td>
	</tr>
	</table>
</body>
</html>

















