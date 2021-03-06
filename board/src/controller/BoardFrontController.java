package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//요청 판별
		String requestURI = request.getRequestURI(); // /board/qWrite.do : 프로젝트명+넘어온 값
		String contextPath = request.getContextPath(); // /board/ : 프로젝트명
		String cmd = requestURI.substring(contextPath.length()); // /qWrite.do
		
		//요청에 따라 Action 생성하기
		BoardActionFactory factory = BoardActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		//생성된 Action에 일 시키기
		ActionForward af = null;
		
		try {
			af=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//리턴받은 결과에 따라 지정된 방식으로 이동하기
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
