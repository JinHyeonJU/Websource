<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
   int no = Integer.parseInt(request.getParameter("no"));
   String addr = request.getParameter("addr");
   String mobile = request.getParameter("mobile");
   
   UserDAO dao = new UserDAO();
   int result = dao.updateUser(no, addr, mobile);
   
   
   if(result>0) {
       response.sendRedirect("index.jsp"); //성공시
    }
%>