package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Service;

import service.MemberService;
import service.MemberServiceImpl;

public class InsertAction implements Action{
	//생성자 : 객체 생성시 필요 = > new할 때 무조건 호출
	//클래스 안에생성자가 하나도 없다면 컴파일러가 자동으로 dafault생성자를 생성해줌
	private String path;
	public InsertAction(String path) {
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request,
			 HttpServletResponse response) throws Exception {
		// ~Pro.jsp 에서 했던 작업
		// request.getParameter();
		String name = request.getParameter("name");
		System.out.println("insert_action name : "+name);
		
		//DB작업을 service 부탁
		MemberService service = new MemberServiceImpl();
		service.insertMember(name);
		
		//session => sendRedirect()
		//request => forward()
		// sendRedirect(true), forward(false)
		return new ActionForward(path,true);
	}
}
