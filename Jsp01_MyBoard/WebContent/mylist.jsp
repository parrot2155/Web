<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.my.dto.MyBoard" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoard> list = dao.selectAll();
%>
</head>
<body>
	<h1>LIST PAGE</h1>
	<!-- db에 저장된 데이터를 조회하여 목록으로 보여줄 페이지 -->
	<table border="1">
		<col width="50px"><col width="100px"><col width="200px"><col width="200px">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
<%
		for(int i=0; i<list.size();i++){
%>
		<tr>
			<td><%=list.get(i).getMyno() %></td>
			<td><%=list.get(i).getMyname() %></td>
			<td><%=list.get(i).getMytitle() %></td>
			<td><%=list.get(i).getMydate() %></td>
		</tr>
<%
		}
%>
	<tr>
		<td colspan="4" align="right">
			<button onclick="location.href='myinsert.jsp';">글쓰기</button>
		</td>
	</tr>
	
	
	</table>
	<!-- <script type="text/javascript">
		function write(){
			loication.href='myinsert.jsp'
		}
	</script> -->
	
</body>
</html>