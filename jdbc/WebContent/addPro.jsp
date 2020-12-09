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
    
    Connection con = null;
    PreparedStatement pstmt = null;
    //jdbd => Java와 DB연동하기 위한 기본 구조
    try{
    	Class.forName("oracle.jdbc.OracleDriver");
    	
    	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	String user = "javaDB";
    	String password = "12345";
    	
    	con =DriverManager.getConnection(url, user, password);
    	if(con!=null){
    		//sql 구문 생성
    		String sql = "insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
    		//Statement 생성 후 전송
    		pstmt = con.prepareStatement(sql);
    		//?에 해당하는 값을 설정하기 (첫번째 물음표 1번...)
    				
    		//  열명을 올바르게 지정해 주십시오 => sql 문이 넘어갈 때 userTBLvalues ~~  이렇게 넘어가서 그래요
    		// 공백이 없어서~~~
    		// "insert into userTBL ";
    		// sql += "values(userTBL_seq.nextval,?,?,?,?)";
    		pstmt.setString(1, username);
    		pstmt.setInt(2, Integer.parseInt(birthyear));
    		pstmt.setString(3, addr);
    		pstmt.setString(4, mobile);
    		
    		//sql구문 실행하고 결과 받기
    		int result = pstmt.executeUpdate();
    		
    		//결과에 따라 페이지 이동
    		if(result>0){ //성공
    			response.sendRedirect("index.jsp");
    		}else{ //실패
    			response.sendRedirect("add.jsp");
    		}
    	}
    }catch(Exception e){
    	e.printStackTrace();
    }finally{
    	try{
    		pstmt.close();
    		con.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
%>