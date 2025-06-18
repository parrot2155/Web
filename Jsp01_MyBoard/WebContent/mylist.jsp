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

</head>
<body>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoard> list = dao.selectAll();
%>
	<h1>LIST PAGE</h1>
	<!-- db에 저장된 데이터를 조회하여 목록으로 보여줄 페이지 -->
	<table border="1">
		<col width="50px"><col width="100px"><col width="200px"><col width="200px">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
<%
		for(int i=0; i<list.size();i++){
%>
		<tr>
			<td><%=list.get(i).getMyno() %></td>
			<td><%=list.get(i).getMyname() %></td>
			<td><a href="selectone.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
			<td><%=list.get(i).getMydate() %></td>
			<td><button onclick="location.href='myupdate.jsp?myno=<%=list.get(i).getMyno()%>'">수정</button></td>
			<td><button onclick="location.href='mydelete.jsp?myno=<%=list.get(i).getMyno()%>'">삭제</button></td>
		</tr>
<%
		}
%>
	<tr>
		<td colspan="6" align="right">
			<button onclick="location.href='myinsert.jsp';">글쓰기</button>
		</td>
	</tr>
	
	
	</table>
	<!-- <script type="text/javascript">
		function write(){
			location.href='myinsert.jsp'
		}
	</script> -->
	
</body>
</html>