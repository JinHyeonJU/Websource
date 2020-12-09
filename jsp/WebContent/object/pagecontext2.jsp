<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//아래의 include는 지시어 : <%@ include file 과 같은 개념
	pageContext.include("pagecontext3.jsp");
	//3번 페이지를 가져와서 포함시킴
%>
<h2>pagecontext.jsp 의 forward 메소드로 포워딩된 페이지</h2>
</body>
</html>