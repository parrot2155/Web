<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
	    const id = document.forms[0].id.value;
	    const pw = document.forms[0].pw.value;
	    if (!id || !pw) {
	      alert("아이디와 비밀번호를 모두 입력하세요.");
	      return false;
	    }
	    return true;
	 }
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="member" method="post" onsubmit="return validate()">
		<input type="hidden" name="command" value="login">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" onclick="location.href='member?command=signupform'" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<br>
	<p>테스트 계정</p>
	<p>아이디 : ADMIN</p>
	<p>비밀번호 : ADMIN</p>
</body>
</html>