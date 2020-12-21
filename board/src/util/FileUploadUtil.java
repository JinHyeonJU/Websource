package util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {
	public void uploadFile(HttpServletRequest request) {
		//file upload 요청 파악하기
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			//전송된 파일을 디스크에 저장하기 위한 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//파일 업로드 handler, Servlet에는 FileUpload기능있음 
			ServletFileUpload upload = new ServletFileUpload(factory);
			//request 파싱을 위해 담기
			List<FileItem> fileItems = null;
			try {
				fileItems = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			String fieldName = null, fileName =null, value=null;
			Iterator<FileItem> iter = fileItems.iterator();
			while(iter.hasNext()) {
				FileItem item = iter.next();
			
				//FormField => type=file이 아닌것들(ex. text...)
				if(item.isFormField()) {
					fieldName = item.getFieldName(); //title&content값 담기
					try {
						value = item.getString("utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} 
				}else { //type=file
					fieldName = item.getFieldName(); 
					fileName = item.getName();
					long size = item.getSize();
					
				//◆File 저장하기
				String path="c:\\upload"; //파일 저장할 위치
				if(!fileName.isEmpty()) {
					
					//◆FileName이 중복되는 경우를 대비해 UUID 객체 사용
					//중복될경우 랜덤문자열_FileName으로 파일저장
					UUID uuid = UUID.randomUUID();
					
					File uploadFile = new File(path+"\\"+uuid.toString()+"_"+fileName);
					try {
						item.write(uploadFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				}
			}
		}
	}
}
