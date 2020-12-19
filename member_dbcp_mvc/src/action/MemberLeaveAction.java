package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberLeaveAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		MemberService service = new MemberServiceImpl();
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("leave");
		
		return new ActionForward(path, true);
	}

}
