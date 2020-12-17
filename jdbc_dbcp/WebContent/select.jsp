
<%@page import="jdbc.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//index.jsp에서 넘긴 값 가져오기
request.setCharacterEncoding("utf-8");
String no = request.getParameter("no");
String username = request.getParameter("username");

UserDAO dao = new UserDAO();
UserVO vo = dao.getUser(no);
%>
<%@include file="header.jsp"%>
<div class="container">
	<form action="" method="post">
		<div class="form-group">
			<label for="username">번호</label> <input type="text"
				class="form-control" id="no" name="no" readonly value="<%=vo.getNo()%>">
		</div>
		<div class="form-group">
			<label for="username">이름</label> <input type="text"
				class="form-control" id="username" name="username" readonly
				value="<%=vo.getUsername()%>">
		</div>
		<div class="form-group">
			<button type="button" id="update" class="btn btn-primary">
				수정</a>
			</button>
			<button type="button" id="delete" class="btn btn-danger">
				삭제</a>
			</button>
		</div>
	</form>
</div>
<%
	
%>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script>
	$(function() {

		let form = $("form");
		//수정버튼을 클릭하면 update.jsp로 이동
		$(".btn-primary").click(function() {
			$(form).attr("action", "update.jsp");
			$(form).submit();
		})
		//삭제버튼을 클릭하면 deletePro.jsp로 이동
		$(".btn-danger").click(function() {
			$(form).attr("action", "deletePro.jsp");
			$(form).submit();
		})
	})
</script>
</body>
</html>