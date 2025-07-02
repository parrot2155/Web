<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 수정</h1>
<form action="board" method="post">
    <input type="hidden" name="command" value="update">
    <input type="hidden" name="no" value="${dto.no}">

    <table>
        <tr>
            <th>작성자</th>
            <td>${dto.name}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10" cols="40"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="수정 완료">
                <input type="button" value="취소" onclick="history.back()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>