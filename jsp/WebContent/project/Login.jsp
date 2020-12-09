<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String repassword = request.getParameter("repassword");
    String username = request.getParameter("username");
    String jender = request.getParameter("jender");
    String email = request.getParameter("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>개인 정보 확인</h3>
	
	<%
	out.print("<ul><li>아이디 :"+id+"</li>");
	out.print("<li>비밀번호 :"+password+"</li>");
	out.print("<li>성함 :"+username+"</li>");
	out.print("<li>성별 :"+jender+"</li>");
	out.print("<li>이메일 :"+email+"</li></ul>");
	 %>
	
</body>
</html>