<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.board.dao.*" %>
<%@ page import="com.board.dto.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function allChk(bool){
		let chks = document.getElementsByName("chk");
		for(let i=0;i<chks.length;i++){
			chks[i].checked = bool;
		}
	}
</script>
</head>
<body>
	<!-- db에 저장된 데이터를 모두 조회하여 화면에 목록으로 보여준다. -->

<%
	BoardDao dao = new BoardDao();
	List<BoardDto> list = dao.selectAll();
%>

<%@ include file="./form/header.jsp" %>

<h1>List</h1>
<form action="muldel.jsp" method="get" id="muldelform">
	<table>
		<col width="30px"><col width="50px"><col width="100px"><col width="300px"><col width="100px">
		<tr>
			<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
			<th>SEQ</th>
			<th>WRITER</th>
			<th>TITLE</th>
			
			<th>DATE</th>
		</tr>
	<%
		if(list.size()==0){
			//조회한 게시글이 없다.
	%>
		<tr>
			<td colspan="5">-----글이 존재하지 않습니다.-----</td>
		</tr>
	<%
		}else{
			//조회한 데이터를 화면에 출력
			for(BoardDto dto : list){
	%>
		<tr>
			<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="boarddetail.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
	<%					
			}
		}
	%>
		<tr>
			<td colspan="5">
				<input type="submit" value="삭제">
				<input type="button" value="글쓰기" onclick="location.href='boardwrite.jsp'">
			</td>
		</tr>
	</table>
</form>
<%@ include file="./form/footer.jsp" %>
</body>
</html>



















