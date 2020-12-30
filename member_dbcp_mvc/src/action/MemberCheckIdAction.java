package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberCheckIdAction implements Action {

	private String path;
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userid = request.getParameter("userid");
		
		MemberService service = new MemberServiceImpl();
		boolean dupId = service.checkIdMember(userid); //dupId = true or false
		
		if(dupId) { //사용 불가
			request.setAttribute("dupId", "false");
		} else { //사용 가능
			request.setAttribute("dupId", "true");
		}
		
		return new ActionForward(path, false);
	}
}
