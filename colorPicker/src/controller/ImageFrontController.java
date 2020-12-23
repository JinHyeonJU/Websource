package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageFrontController
 */
@WebServlet("*.do")
public class ImageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//한글처리
		request.setCharacterEncoding("utf-8");
		
	//요청 판별
		String requestURI = request.getRequestURI(); // /colorPicker/AddColor.do : 프로젝트명+넘어온 값
		String contextPath = request.getContextPath(); // /colorPicker/ : 프로젝트명
		String cmd = requestURI.substring(contextPath.length()); // /AddColor.do
	
	//요청에 따라 Action 생성하기
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
