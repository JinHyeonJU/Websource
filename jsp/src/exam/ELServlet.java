package exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("*.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//Session
		HttpSession session = request.getSession(); //세션객체
		session.setAttribute("age", 25); //("변수명", 값)
		
		//List(For문)
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("kang123", "kang123@"));
		list.add(new LoginDTO("kang124", "kang124@"));
		list.add(new LoginDTO("kang125", "kang125@"));
		list.add(new LoginDTO("kang126", "kang126@"));
		request.setAttribute("list", list);
		
		//login 객체
		LoginDTO login = new LoginDTO("hong123", "hong123@");
		request.setAttribute("login", login);
		
		//request => setAttribute랑 forward 세트
		request.setAttribute("name", request.getParameter("name"));
		RequestDispatcher rd = request.getRequestDispatcher("el/$이용.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
