<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//mothod="post" 한글 안 깨지게 작업
	request.setCharacterEncoding("utf-8");
    //add.jsp에서 사용자 입력값 가져오기
    String username = request.getParameter("username");
    String birthyear = request.getParameter("birthyear");
    String addr = request.getParameter("addr");
    String mobile = request.getParameter("mobile");
    
    //UserDAO 객체 생성 - DB작업 시키기
    UserDAO dao = new UserDAO();
    //return result 받기
    int result = dao.insert(username,birthyear,addr,mobile); // dao.insert(현재페이지서 넘길값 ex:username...)메소드 호출
    
  //결과에 따라 페이지 이동
	if(result>0){ //성공
		response.sendRedirect("index.jsp");
	}else{ //실패
		response.sendRedirect("add.jsp");
	}
%>