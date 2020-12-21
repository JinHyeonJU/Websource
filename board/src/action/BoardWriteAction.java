package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardWriteAction implements Action {

	private String path;
	
	//File타입이 하나라도 있으면 request 사용불가
	//
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}

}
