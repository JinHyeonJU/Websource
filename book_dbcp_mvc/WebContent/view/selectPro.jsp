
<%@page import="domain.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//도서목록보기 메뉴를 클릭하면 보여줄 내용 처리
	BookDAO dao = new BookDAO();
	List<BookVO> list = dao.getList();
	//값을 넘기는방법 : scope => request+forward, session
	//forward : pageContext
	request.setAttribute("list", list);
	pageContext.forward("../select.jsp");
%>