<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>작성글 보기</h1>
<table>
	<!-- 3. 해당 페이지에서 준비된 데이터 화면에 출력(글번호, 작성자, 작성일, 제목, 내용) -->
	<tr>
		<th>글 번호</th>
		<td>${dto.boardno }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${dto.regdate }</td>
	</tr>
	<tr>
		<th>제 목</th>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="10" cols="40" readonly="readonly">${dto.content }</textarea></td> 
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" value="수정" onclick="location.href='answer?command=updateform&boardno=${dto.boardno}'">
		<input type="button" value="답글" onclick="location.href='answer?command=answerform&parentboardno=${dto.boardno}'">
		</td>
	</tr>
</table>

	
</body>
</html>