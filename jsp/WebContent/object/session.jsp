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
   //���� ��ü - session : ���Ἲ
   //http ���������� �⺻������ stateless(��û-> �����ϰ� ���� ����)������� ������

%>
<h2>�����׽�Ʈ</h2>
isNew() : <%=session.isNew() %> <br />
�����ð� : <%=session.getCreationTime() %> <br />
�������ӽð� : <%=session.getLastAccessedTime() %> <br />
����ID : <%= session.getId() %>

</body>
</html>