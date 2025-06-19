<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.board.dto.BoardDto" %>
<%@ page import="com.board.dao.BoardDao" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이전 페이지에서 넘어오는 parameter 3개를 받아 dao를 통해 update진행 후 결과 화면처리 -->
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDto dto = new BoardDto(seq,null,title,content,null);
	
	BoardDao dao = new BoardDao();
	int res = dao.update(dto);
	
	if(res>0){
		//수정 성공 스크립트
%>
	<script type="text/javascript">
		alert("글 수정 성공");
		location.href="boardlist.jsp";
	</script>
<%
	}else{
		//수정 실패 스크립트
%>
	<script type="text/javascript">
		alert("글 수정 실패");
		location.href="boarddetail.jsp?seq=<%=dto.getSeq()%>";
	</script>
	
<%
	}
%>
</body>
</html>

















