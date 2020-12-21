<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//file upload 요청 파악하기
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
		//아래는 Apache Commons에서 지정한 형태
	if(isMultipart) {
		//전송된 파일을 디스크에 저장하기 위한 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//파일 업로드 handler, Servlet에는 FileUpload기능있음 
		ServletFileUpload upload = new ServletFileUpload(factory);
		//request 파싱을 위해 담기
		List<FileItem> fileItems = upload.parseRequest(request);
		//List에서 값을 가져오는 방법
		//1. for(MemberVO vo:list)
		//2. Iterator
		
		String fieldName = null, fileName =null, value=null;
		Iterator<FileItem> iter = fileItems.iterator();
		while(iter.hasNext()) {
			FileItem item = iter.next();
		
			//FormField => type=file이 아닌것들(ex. text...)
			if(item.isFormField()) {
				fieldName = item.getFieldName(); //title&content값 담기
				value = item.getString("utf-8"); 
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
			}else { //type=file
				fieldName = item.getFieldName(); 
				fileName = item.getName();
				long size = item.getSize();
				
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+fileName+"<br>");
				out.print("파일 크기 : "+size);
				
			//◆File 저장하기
			String path="c:\\upload"; //파일 저장할 위치
			if(!fileName.isEmpty()) {
				
				//◆FileName이 중복되는 경우를 대비해 UUID 객체 사용
				//중복될경우 랜덤문자열_FileName으로 파일저장
				UUID uuid = UUID.randomUUID();
				
				File uploadFile = new File(path+"\\"+uuid.toString()+"_"+fileName);
				item.write(uploadFile);
				
				
				//◆File Download를 위한 경로 설정
				out.print("<p>");
				out.print("<a href='download.jsp?fileName="+uploadFile.getName()+"'>"+fileName+"</a>");
				out.print("</p>");
			}
			}
		}
	}
%>