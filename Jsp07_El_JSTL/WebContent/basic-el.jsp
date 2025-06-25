<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
		EL(Expression Language)
		JSP에서 데이터 처리를 쉽게 하기 위한 문법 
		<\%= %> --> 달러{}
		값을 화면에 출력하는 표현식
</pre>

<table border="1">
	<tr>
		<th>EL</th>
		<td>result</td>
	</tr>
	<tr>
		<th>\${1}</th>
		<td>${1 }</td>
	</tr>
	<tr>
		<th>\${1+2}</th>
		<td>${1+2 }</td>
	</tr>
	<tr>
		<th>\${10-3}</th>
		<td>${10-3 }</td>
	</tr>
	<tr>
		<th>\${(1==2)?3:4}</th>
		<td>${(1==2)?3:4}</td>
	</tr>
</table>


</body>
</html>