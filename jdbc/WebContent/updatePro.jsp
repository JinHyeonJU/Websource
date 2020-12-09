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
   
   Connection con = null;
   PreparedStatement pstmt = null;
      
   try{
      Class.forName("oracle.jdbc.OracleDriver");
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "javaDB";
      String password = "12345";
      
       con = DriverManager.getConnection(url, user, password);
      if(con!=null){
         String sql = "update userTBL set addr=?, mobile=? where no=?";
         //생성 후 전송
         pstmt = con.prepareStatement(sql);
         //? 에 해당하는 값을 set 하기
         pstmt.setString(1, addr);
         pstmt.setString(2, mobile);
         pstmt.setInt(3, no);
         //구문 실행 후 결과 받기
         int result = pstmt.executeUpdate();
         //결과에 따라 페이지 이동
         if(result>0) {
            response.sendRedirect("index.jsp"); //성공시
         }
      }
            
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         pstmt.close();
         con.close();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
%>