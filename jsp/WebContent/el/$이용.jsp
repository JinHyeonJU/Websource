<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--prefix:시작하는문자 uri:주소 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--EL : jsp에서 데이터를 추출하는 표현식
	${} : request.sission에 담아놓은 값 가져올 때 사용
	+ JSTL : EL과 같이 쓰는 것(라이브러리 추가해야함) --%>
<h3>request에 담아 놓은 값 가져오기</h3>
	<div><%=request.getAttribute("name") %></div>
<h4>request에 담아 놓은 객체 가져오기 - LoginDTO</h4>
	<%
		LoginDTO dto = (LoginDTO)request.getAttribute("login");
	%>
	<div>ID : <%=dto.getUserid()%></div>
	<div>PWD : <%=dto.getPassword() %></div>
<hr />
	<%-- login : request에 담아놓은 변수명 --%>
	<div>ID : ${login.userid}</div>
	<div>PWD : ${login.password}</div>
<h3>Session 에 담아 놓은 값 가져오기</h3>
	<div><%=session.getAttribute("age") %></div>
	<div>${age}</div>
<hr />
<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
	</tr>
	<%--<c:forEach : JSTL이며 for문 --%>
	<%-- var : 변수명, items : EL --%>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.userid}</td>
			<td>${vo.password}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>