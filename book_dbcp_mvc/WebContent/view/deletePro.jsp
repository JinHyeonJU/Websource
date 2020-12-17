<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//delete.jsp 에서 넘긴 값 가져오기
	int code = Integer.parseInt(request.getParameter("code"));
	//DB작업해주기
	BookDAO dao = new BookDAO();
	int result = dao.bookDelete(code);
	
	if(result==0) {
		response.sendRedirect("../index.jsp?tab=delete");
	}else {//성공시 select로 이동
		response.sendRedirect("selectPro.jsp");
	}
%>