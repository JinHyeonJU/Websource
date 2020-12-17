<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//leaveForm.jsp에서 넘긴 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	//DB 작업
	MemberDAO dao = new MemberDAO();
	int result = dao.leaveMember(userid, password);
	//비밀번호가 일치하여 탈퇴가능한 경우. - 세션해제, index페이지로 이동
	if(result>0){
		session.invalidate();
		response.sendRedirect("../index.jsp");
	//비밀번호가 틀리는 경우. - leaveForm.jsp로 이동
	}else {
		response.sendRedirect("leaveForm.jsp");
	}
	
	

%>