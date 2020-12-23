package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ColorVO;
import lombok.AllArgsConstructor;
import service.ColorService;
import service.ColorServiceImpl;
import util.FileUploadUtil;

@AllArgsConstructor
public class ColorAddAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter() 사용불가 => file잇어서
		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map = utils.uploadFile(request);
		
		//map 에 들어있는 폼 요소들을 VO에 옮기기
		ColorVO color = new ColorVO();
		color.setName(map.get("name"));
		color.setTitle(map.get("title"));
		color.setPassword(map.get("password"));
		if(map.containsKey("attach"))
			color.setAttach(map.get("attach"));
			
		//서비스 호출
		ColorService service = new ColorServiceImpl();
		boolean flag = service.addArticle(color);
		
		if(!flag) {
			path = "view/AddBoard.jsp";
		}
		return new ActionForward(path, true);
	}
}
