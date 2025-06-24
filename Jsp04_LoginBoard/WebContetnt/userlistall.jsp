<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="java.util.List" %>
<%@ page import="com.login.dto.MyMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateRole(no){
		//location.href="logincontroller.jsp?command=updateroleform&myno="+no;
		
		//form태그 생성
		let form = document.createElement('form');
		form.method='POST';
		form.action='logincontroller.jsp'
		//<form action='logincontroller.jsp' method='POST'></form>
		
		//input태그 생성
		let command = document.createElement('input');
		command.type='hidden';
		command.name='command';
		command.value='updateroleform';
		
		let myno = document.createElement("input");
		myno.type='hidden';
		myno.name='myno';
		myno.value=no;
		
		
		form.appendChild(command);
		form.appendChild(myno);
		
		//body에 생성한 form태그 추가 후 submit 실행
		document.body.appendChild(form);
		form.submit();
		
	}
	
</script>
</head>
<body>
<%
	List<MyMemberDto> list = (List<MyMemberDto>)request.getAttribute("list");
	
%>

<h1>회원정보조회(All)</h1>
<table>
	<col width="50"><col width="100"><col width="100"><col width="100"><col width="500"><col width="200"><col width="200"><col width="100"><col width="100">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>가입여부</th>
		<th>등급</th>
	</tr>
<%
	for(MyMemberDto dto : list){
%>
	<tr>
		<td><%=dto.getMyno() %></td>
		<td><%=dto.getMyid() %></td>
		<td><%=dto.getMypw() %></td>
		<td><%=dto.getMyname() %></td>
		<td><%=dto.getMyaddr() %></td>
		<td><%=dto.getMyphone() %></td>
		<td><%=dto.getMyemail() %></td>
		<td><%=dto.getMyenabled().equals("Y")?"가입":"탈퇴 " %></td>
		<td><%=dto.getMyrole() %></td>
		<td><button onclick="updateRole(<%=dto.getMyno()%>)">변경</button></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>









