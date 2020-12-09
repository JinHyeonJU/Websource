package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatServlet
 */
@WebServlet("/CatServlet")
public class CatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 사용자의 선택 값 가져오기
		// String[] 변수 = request.getParameterValues("가져올값") : 여러개의 값
		String[] cat = request.getParameterValues("cat");
		// System.out.println(Arrays.toString(cat));
	
		//화면에 출력하기
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>고냥이</title></head>");
		out.print("<body><h3>좋아하는 고냥이</h3>");
		out.print("<ul>");
		for(String s:cat) {
			out.print("<li>"+s+"</li>");
		}
		out.print("</head></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
