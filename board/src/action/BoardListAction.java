package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.PageVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardListAction implements Action {
	
	private String path;
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//서비스 요청
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.getList();
		
		//전체 행 수 가져오기
		service = new BoardServiceImpl();
		int totalRow = service.getRows();
		
		PageVO info = new PageVO(totalRow, seachVO);
		//요청 후 받은 결과 담기
		request.setAttribute("list", list);
		//검색어/검색기준
		request.setAttribute("info", info);
		
		//request.set이면 false
		//이동방식 결정
		return new ActionForward(path, false);
	}

}
