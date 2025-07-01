<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정</h1>
	<form action="myboard" method="post">
		<input type="hidden" name="command" value="update">
		<input type="hidden" name="myno" value="${dto.myno }">
		<table>
			<tr>
				<th>번 호</th>
				<td>${dto.myno }</td>
			<tr>
			<tr>
				<th>이 름</th>
				<td>${dto.myname }</td>
			<tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			<tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="40" name="mycontent">${dto.mycontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>