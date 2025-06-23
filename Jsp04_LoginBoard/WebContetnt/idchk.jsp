<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		let id = opener.document.getElementsByName("myid")[0].value;
		
		document.getElementsByName("id")[0].value = id;
	}
	
	function confirm(bool){
		if(bool == "true"){
			//중복체크한 아이디값 사용 가능할 때
			opener.document.getElementsByName("myid")[0].title="y";
			opener.document.getElementsByName("mypw")[0].focus();
		}else{
			//중복 체크한 아이디값 사용 불가능할 때(중복일때)
			opener.document.getElementsByName("myid")[0].value="";
			opener.document.getElementsByName("myid")[0].focus();
		}
		self.close();
	}
</script>
</head>
<body>
<%
	String idnotused = request.getParameter("idnotused");
%>

<table>
	<tr>
		<td><input type="text" name="id" readonly="readonly"></td>
	</tr>
	<tr>
		<td><%=idnotused.equals("true")?"아이디 생성 가능":"중복 아이디 존재" %></td>
	</tr>
	<tr>
		<td><button onclick="confirm('<%=idnotused %>');">확인</button></td>
	</tr>
</table>
</body>
</html>















