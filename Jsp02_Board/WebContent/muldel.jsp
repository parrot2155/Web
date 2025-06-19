<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.board.dao.BoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- parameter값을 받아 dao를 통해 삭제 진행 후 결과 처리 -->
<%
	//동일한 name의 parameter가 다수 존재할 때
	String[] seq = request.getParameterValues("chk");
	
	if(seq == null){
%>
	<script type="text/javascript">
		alert("삭제할 글을 1개 이상 선택해 주세요");
		location.href="boardlist.jsp";
	</script>
<%
	}else{
		BoardDao dao = new BoardDao();
		int res = dao.multiDelete(seq);
		
		if(res == seq.length){
			//다중 삭제 성공
%>
	<h1>체크된 글 <%=res %>개 모두 삭제 성공하였습니다. </h1>
	<button onclick="location.href='boardlist.jsp'">확인</button>
<%
		}else{
			//다중 삭제 실패
%>
	<h1>체크된 글들을 삭제 실패하였습니다.</h1>
	<button onclick="location.href='boardlist.jsp'">확인</button>
<%			
		}
	}
%>
</body>
</html>






