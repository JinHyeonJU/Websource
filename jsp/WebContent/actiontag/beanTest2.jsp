<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- useBean => User user(클래스의 변수명) = new User(); --%>
<jsp:useBean id="user" class="exam.User"/> <%-- id="클래스의 변수명" --%>
<h1>
<%-- setProperty (valus 속성 추가해야함) => user.setName() --%>
<%-- getProperty => user.getName() --%>
<%-- User 클래스의 속성(String name) --%>
<%-- name="클래스의 변수명" --%>
<%-- ★bean은 사용 잘 안함 --%>
	<jsp:setProperty property="name" name="user" value="홍길동"/>
	<jsp:getProperty property="name" name="user"/>
</h1>
</body>
</html>