<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 성공하면 index.jsp로 이동
	// update 테이블명 set addr=수정값, mobile=수정값
	// where no = 12 
	request.setCharacterEncoding("utf-8");
	
	
	UserDAO dao = new UserDAO();
	int result =;
	
	if(result > 0){
		response.sendRedirect("Index.jsp");
	}
%>