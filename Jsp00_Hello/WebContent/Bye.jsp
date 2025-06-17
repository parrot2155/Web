<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int no = 123; %>
	<h1>Bye.jsp...file<%=no %></h1> <!-- < %% >안에 내용은 보이지 않고 작동만 한다. -->
	<%for(int i=0; i<5;i++){
	%>
		<h3>5번 반복 합시다</h3>
	<%
	}	
	%>
	<%
	if(10>5){
	%>
		<h1>if문 조건이 true</h1>
	<%
	}
	%>
	
	
	
</body>
</html>