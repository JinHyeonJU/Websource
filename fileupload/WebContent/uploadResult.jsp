<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//file upload 요청 ㅏ악하기
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	if(isMultipart) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> fileItems = upload.parseRequest(request);
		
		String fieldName = null, fileName =null, value=null;
		Iterator<FileItem> iter = fileItems.iterator();
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			if(item.isFormField()) {
				fieldName = item.getFieldName();
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
			}else {
				fieldName = item.getFieldName();
				fileName = item.getName();
				long size = item.getSize();
				
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+fileName+"<br>");
				out.print("파일 크기 : "+size);
			}
		}
	}
%>