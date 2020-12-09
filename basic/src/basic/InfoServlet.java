package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	
	String username = request.getParameter("username");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String sex = request.getParameter("sex");
	String job = request.getParameter("job");

	PrintWriter out = response.getWriter();
	out.print("<html><head><title>개인정보</title></head>");
	out.print("<body><h2>정보 확인</h2>");
	out.print("<ul><li>이름 : "+username+"</li>");
	out.print("<li>이름 : "+username+"</li>");
	out.print("<li>아이디 : "+id+"</li>");
	out.print("<li>비밀번호 : "+password+"</li>");
	out.print("<li>성별 : "+sex+"</li>");
	out.print("<li>직업 : "+job+"</li></ul>");
	out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
