<%@page import="jdbc.UserVO"%>
<%@page import="jdbc.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %> <!-- css파일인 header.jsp불러오기 -->
<div class="container">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">태어난 해</th>
      <th scope="col">주소</th>
      <th scope="col">전화번호</th>
    </tr>
  </thead>
<tbody>
<%

	UserDAO dao = new UserDAO();
	List<UserVO> list = dao.select();
	//for문으로 유저 다 가져오기
	//향상된for문 : list를 다 꺼낼때까지 list에서 UserVO를 빼오고 vo라는 변수에 담기
	for(UserVO vo:list){

%>
	<tr>
		<td><%=vo.getNo() %></td>
		<td><a href="select.jsp?no=<%=vo.getNo()%>"><%=vo.getUsername()%></a></td>
		<td><%=vo.getBirthyear() %></td>
		<td><%=vo.getAddr() %></td>
		<td><%=vo.getMobile() %></td>
	</tr>

<%
	}
%>
  </tbody>
</table>
</div>
</body>
</html>

<!-- 다른페이지로 데이터전송하기 => request.getParameter()
1. form
2. 링크 -->