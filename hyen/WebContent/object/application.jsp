<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//���尴ü - application ��ü (�� �� ���ø����̼Ǵ� ���� �ϳ��� ���� - ��ü ���ø����̼� ����(������Ʈ)���� �����ؾ��ϴ� ������ ó��)
	
%>
<ul>
	<li>jsp ���� : <%=application.getMajorVersion() %>.<%=application.getMajorVersion() %></li>
	<li>�����̳� ���� : <%=application.getServerInfo() %></li>
	<li>�� ���ø����̼��� ���� ���� �ý��� ��� : <%=application.getRealPath("/")%></li>
</ul>
</body>
</html>