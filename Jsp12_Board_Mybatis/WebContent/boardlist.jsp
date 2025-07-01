<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		document.getElementById("muldelform").addEventListener("submit",function(e){
			const checked = document.querySelectorAll("#muldelform input:checked");
			if(checked.length == 0){
				alert("하나 이상 체크해 주세요.");
				e.preventDefault();
			}
		});
	}
</script>
</head>
<body>
<h1>글 목록</h1>
<form action="board" method="post" id="muldelform">
<input type="hidden" name="command" value="muldel">
<table>
	<tr>
		<th>&nbsp;</th>
		<th>번 호</th>
		<th>작성자</th>
		<th>제 목</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td><input type="checkbox" name="chk" value="${dto.seq }"></td>
		<td>${dto.seq }</td>
		<td>${dto.writer }</td>
		<td><a href='board?command=detail&seq=${dto.seq }'>${dto.title }</a></td>
    	<td><fmt:formatDate value="${dto.regdate}" pattern="yy년MM월dd일" /></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4">
			<input type="submit" value="삭제">
			<input type="button" value="글쓰기" onclick="location.href='board?command=writeform'">
		</td>
	</tr>
</table>
</form>
</body>
</html>