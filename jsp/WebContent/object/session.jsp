<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
   session.setMaxInactiveInterval(10);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
   //내장 객체 - session : 연결성
   //http 프로토콜은 기본적으로 stateless(요청-> 응답하고 연결 끊기)기능으로 움직임

%>
<h2>세션테스트</h2>
isNew() : <%=session.isNew() %> <br />
생성시간 : <%=session.getCreationTime() %> <br />
최종접속시간 : <%=session.getLastAccessedTime() %> <br />
세션ID : <%= session.getId() %>

</body>
</html>