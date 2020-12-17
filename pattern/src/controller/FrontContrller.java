package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.DeleteAction;
import action.InsertAction;

/**
 * Servlet implementation class FrontContrller
 */
@WebServlet("*.do")
public class FrontContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8080/pattern/update.do
		//http://localhost:8080/pattern/select.do
		//http://localhost:8080/pattern/delete.do
		//http://localhost:8080/pattern/insert.do
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI(); //pattern/update.do
		String contextPath = request.getContextPath(); //pattern
		String cmd = requestURI.substring(contextPath.length()); //update.do
		
		ActionFactory factory = new ActionFactroy();
		Action action = null;
		
		ActionForward af= null;
		try {
			af=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) { //true => sendRedirect방식
			response.sendRedirect(af.getPath()); //경로
		}else { // false => forward방식
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
