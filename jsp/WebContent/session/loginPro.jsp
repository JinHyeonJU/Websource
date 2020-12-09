<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");

	// 세션 영역에 값 담기
	session.setAttribute("userid", userid);
	session.setAttribute("password", password);
	
	response.sendRedirect("../index.jsp");
%>