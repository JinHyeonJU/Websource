package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberLoginAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		//값 가져오고 VO에 보내기
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.login(userid, password);
		
		//세션에 저장
		HttpSession session = request.getSession();
		session.setAttribute("login", member);
		
		//session => sendRedirect=forward
		return new ActionForward(path, true);
	}

}
