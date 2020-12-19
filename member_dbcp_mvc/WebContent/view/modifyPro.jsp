<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// modifyForm.jsp에서 넘긴 값 가져오기
	
	// DB작업
	MemberDAO dao = new MemberDAO();
	// 1. 현재 비밀번호가 일치 하는지 => isLogin(userid(세션에 있음), password(리퀘스트))
	// - 세션에서 userid 가져오기 필요
	
	MemberVO info = dao.isLogin(vo.getUserid(), current_password);
	
	// 2. 일치하면 변경 / 세션해제 / 로그인 페이지로 돌려보내기 => 새로운 메소드
	if(info!=null){
		int result = dao.isModify(new_password, vo.getUserid());
		if(result > 0) {
			session.invalidate();
			response.sendRedirect("loginForm.jsp");
		}
	}else{	// 3. 일치하지 않으면 비밀번호 변경 페이지로 이동
		response.sendRedirect("modifyForm.jsp");
	}
%>