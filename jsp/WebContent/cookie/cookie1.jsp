<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 저장
	// 쿠키 생성 Cookie c = new cookie(key, value)
	// 쿠키 저장 response.addCookie(c)
	
	
	//밑에는 c대신 add.Cookie(이 안에 c값 입력)
	
	response.addCookie(new Cookie("name", "John"));
	response.addCookie(new Cookie("age", "20"));
	response.addCookie(new Cookie("gender","male"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie1</title>
</head>
<body>
<h3>쿠키 데이터가 저장되었습니다.</h3>
<a href="getCookie1.jsp">쿠키확인</a>
</body>
</html>