<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db에 저장할 데이터를 입력받을 form 작성 -->
	<h1>Write Page</h1>
	<form action="myinsert_res.jsp" method="post">
		<table>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="myname"></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="입력">
					<input type="button" value="취소" onclick="history.back();">
				</td>
			</tr>
		
		</table>
	
	</form>
	
	
	
</body>
</html>























