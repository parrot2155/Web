<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.login.dto.MyMemberDto" %>
<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[command: "+command+"]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MyMemberDto dto = dao.login(id,pw); 
		
		if(dto.getMyid()!=null){
			//로그인 성공
			//session 객체 : 브라우저당 1개의 session객체가 생성.
			session.setAttribute("dto",dto);
			session.setMaxInactiveInterval(60*60);	//담아놓은 객체 이거 얼마동안 살려놓을거냐?
			//객체들의 공유 범위
			// Scope
			//1. page영역 : 하나의 jsp페이지 내에서만 객체를 공유한다.
			//2. request영역 : forward를 통해 request객체가 공유된다.
			//3. session영역 : 같은 브라우저 내에서의 페이지들은 같은 session객체를 공유한다.
			//4. application영역 : 하나의 어플리케이션 당 1개의 application객체 생성되고 공유된다.
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			}else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
			
		}else{
			//로그인 실패
			request.setAttribute("msg", "login 실패");
			request.setAttribute("url", "index.jsp");
			pageContext.forward("result.jsp");
		}
	}else if(command.equals("logout")){
		//session에 저장된 정보를 삭제
		session.invalidate();
		
		request.setAttribute("msg", "로그아웃");
		request.setAttribute("url", "index.jsp");
		pageContext.forward("result.jsp");
		
	}else if(command.equals("userlistall")){
		List<MyMemberDto> list = dao.selectAll();
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
		
	}else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
		
	}else if(command.equals("idchk")){
		String myid = request.getParameter("id");
		String res = dao.idChk(myid);
		
		//res == null --> 저장된 값이 없다. 사용 가능한 아이디다.
		//res != null ==> 이미 해당 아이디 저장되어있다. 중복이다.
		boolean idnotused = true;
		if(res != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);

	}else if(command.equals("insertmember")){
		//파라미터로 넘어오는 데이터를 받은 후 
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MyMemberDto dto = new MyMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		//dao를 통해 insert() 실행
		int res = dao.insertMember(dto);
		
		//그 결과를 통해 화면 처리
		String msg = "";
		String url = "";
		if(res>0){
			msg = "회원가입 성공";
			url = "index.jsp";
		}else{
			msg="회원 가입 실패";
			url="logincontroller.jsp?command=registform";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		pageContext.forward("result.jsp");
		
	}
	
%>
</body>
</html>


























