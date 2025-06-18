<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoard" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- selectone페이지에서 넘어오는 parameter값 myno를 받아 dao를 통해 진행하고 결과값 화면 처리 -->
<% 
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	int res = dao.delete(myno);
	
	if(res>0){
%>
	<script type="text/javascript">
		alert("글 삭제 성공");
		location.href="mylist.jsp";
	</script>
<%
	}else{
%>
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="mylist.jsp";
		</script>
<%
	}
%>
</body>
</html>








