<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
  <h1>마이페이지</h1>
  <table>
  	<tr>
  		<th>아이디</th>
  		<td>${dto.id}</td>
  	</tr>
  	<tr>
  		<th>이름</th>
  		<td>${dto.name}</td>
  	</tr>
  	<tr>
  		<th>전화번호</th>
  		<td>${dto.phone}</td>
  	</tr>
  	<tr>
  		<th>상태</th>
  		<td>${dto.enabled == 'Y' ? '회원' : '비회원'}</td>
  	</tr>
  
  </table>
  <button onclick="location.href='member?command=deleteuser'">회원 탈퇴</button>
</body>
</html>
