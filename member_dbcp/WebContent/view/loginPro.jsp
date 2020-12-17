<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
   
   String userid = request.getParameter("userid");
   String password = request.getParameter("current_password");
   
   MemberDAO dao = new MemberDAO();
   MemberVO member = dao.isLogin(userid, password);
   
   if(member!=null){ //성공 시 현재정보를 session에 담기
      session.setAttribute("login", member);
   }else{ //실패 시
      out.print("<script>alert('아이디와 비밀번호를 확인해 주세요.');</script>");
   }
   //response.sendRedirect("loginForm.jsp");
   out.print("<script>");
   out.print("location.href='loginForm.jsp';");
   out.print("</script>");
%>