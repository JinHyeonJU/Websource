package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;

@AllArgsConstructor
public class BoardWriteAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// reqeust.getParameter() 사용불가
		
		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map = utils.uploadFile(request);
		
		//map 에 들어있는 폼 요소들을 VO에 옮겨주기(꺼낼때 put)
		BoardVO board = new BoardVO(); //vo객체생성
		board.setName(map.get("name")); //담기 시작
		board.setTitle(map.get("title"));
		board.setContent(map.get("content"));
		board.setPassword(map.get("password"));
		if(map.containsKey("attach"))
			board.setAttach(map.get("attach"));
		
		//서비스 호출
		BoardService service = new BoardServiceImpl();
		boolean flag = service.insertArticle(board);
		
		if(!flag) {
			path = "view/qna_board_write.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
