package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserInsertAction implements Action {

	private String path;
	
	public UserInsertAction(String path) { //생성자
		this.path = path;
	}
	
	
	
	@Override
	public Actionforward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter()
		 String username = request.getParameter("username");
		 String birthyear = request.getParameter("birthyear");
		 String addr = request.getParameter("addr");
		 String mobile = request.getParameter("mobile");
		
		 //Service에게 일 시키기
		 UserService service = new UserServiceImpl();
		 boolean insertFlag = service.insertUser(username, birthyear, addr,mobile);
		 
		 //작업결과에 따라 페이지 이동 방식 결정 - sendRedirect - true
		 if(!insertFlag) {
			 path ="";
		 }
		 
		return new Actionforward(path, true);
	}

}
