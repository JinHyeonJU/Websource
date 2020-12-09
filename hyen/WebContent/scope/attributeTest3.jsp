<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AttributeTest2</title>
</head>
<body>
	<h2>영역과 속성 테스트</h2>
	<h3>Application 영역에 저장한 내용</h3>
	<ul> 
	<!-- 어플리케이션의 유효기간 : 컨테이너의 주기와 동일(컨테이너 종료시 소멸) -->
		<li>이름 : <%=application.getAttribute("name") %></li>
		<li>아이디 : <%=application.getAttribute("id") %></li>
	</ul>
	<h3>Session 영역에 저장한 내용</h3>
	<!-- 세션의 유효기간 : 브라우저가 연결을 하고 있는 동안 -->
	<ul> 
		<li>이메일 : <%=session.getAttribute("email") %></li>
		<li>집주소 : <%=session.getAttribute("address") %></li>
		<li>전화번호 : <%=session.getAttribute("tel") %></li>
	</ul>
	<%
	 //어플리케이션과 세션의 차이
	 // 주소를 복붙하면 어플리케이션은 제대로 되지만 세션은 null값이 뜬다
	 // 유효기간에 따라서 null값이 언제나오나?
			 
	//어플리케이션과 세션 중 세션을 더 많이 사용
	%>
</body>
</html>