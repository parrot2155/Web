<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my.dto.MyBoard" %>
<%@ page import="com.my.dao.MyBoardDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- myinsert에서 넘어오는 데이터를 잘 꺼내서 db에 저장-->
<%
	String myname = request.getParameter("myname");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoard dto = new MyBoard(0,myname,mytitle,mycontent,null);
	MyBoardDao dao = new MyBoardDao();
	int res = dao.insert(dto); 
	
	if(res>0){
%>
 		<h1>글 등록 성공</h1>
 		<button onclick="location.href='mylist.jsp'">확인</button>
<%
	}else{
%>
	<script type="text/javascript">
		alert("글 등록 실패");
		location.href="myinsert.jsp";
	</script>
<%
	}
%>

<h1><%=myname %></h1>


</body>
</html>



