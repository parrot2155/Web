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

<%
	/*
	page 영역
	하나의 jsp페이지 내에서만 객체를 공유하는 영역(jsp only)
	*/

	pageContext.setAttribute("pageId", "myPageInVal");


	/*
	request영역
	요청을 받아서 응답하는 곳까지 객체를 공유하는 영역
	*/
	request.setAttribute("reqId", "myReqVal");
	
	/*
	session영역
	같은 브라우저 내에서 요청되는 페이지들과 모두 공유하는 영역
	브라우저 1개의 session객체 생성
	서블릿 - requset.getSession()으로 session객체 얻을 수 있다.
	*/ 
	session.setAttribute("sessionId", "mySessionIdVal");
	
	/*
	application 영역
	같은 어플리케이션 내에 요청되는 모든 페이지들과 공유하는 영역
	어플리케이션 당 1개의 application객체 생성. 
	서블릿 - request.getServletContext()으로 application영역의 객체를 얻을 수 있다.
	*/
	application.setAttribute("appId", "myAppIdVal");

%>
<h1>index</h1>
pageId : <%=pageContext.getAttribute("pageId") %><br>
reqId : <%=request.getAttribute("reqId") %><br>
sessionId : <%=session.getAttribute("sessionId") %><br>
appId : <%=application.getAttribute("appId") %><br>
<br>

<%
	//pageContext.forward("res.jsp");	//request객체 넘기기. 조건 하에 공유가 된다.
%>
<a href="res.jsp">이동(res.jsp)</a>
<a href="myservlet.do">이동(controller)</a>
</body>
</html>









