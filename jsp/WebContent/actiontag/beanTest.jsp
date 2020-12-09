<%@page import="exam.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//User 클래스 사용 하고싶음 => 객체 생성
	User user = new User(); //아직 비어있음.
	user.setName("홍길동"); //user에 홍길동이라는 값 넣기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BeanTest</title>
</head>
<body>
<h2>★이 방법은 디자이너들이 안좋아함</h2>
<h1><%=user.getName()%></h1>
</body>
</html>