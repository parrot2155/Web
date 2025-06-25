<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>result</h1>
		pageId : <%=pageContext.getAttribute("pageId") %><br>
		reqId : <%=request.getAttribute("reqId") %><br>				<!-- page와 request는 다른애들이다. 공유가 안된다. -->
		sessionId : <%=session.getAttribute("sessionId") %><br>
		appId : <%=application.getAttribute("appId") %><br>			<!-- session과 application객체는 잘 가져온다. -->
		<br>
		
	</body>
</html>