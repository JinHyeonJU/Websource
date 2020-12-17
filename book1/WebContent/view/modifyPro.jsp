<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int code = Integer.parseInt(request.getParameter("code"));
	int price = Integer.parseInt(request.getParameter("price"));
	
	BookDAO dao = new BookDAO();
	int result = dao.bookUpdate(price, code);

	if(result==0){
		response.sendRedirect("../index.jsp?tab=modify");
	}else {
		response.sendRedirect("selectPro.jsp");
	}
%>