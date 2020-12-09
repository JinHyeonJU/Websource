<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8"); //post로 받아올때 한글깨짐 방지
    String[] cats = request.getParameterValues("cat");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 좋아하는 고양이</h3>
	<ul>
	<% for (String s:cats) {
    	out.print("<li>"+s+"</li>");
	}
    %>
	</ul>
</body>
</html>