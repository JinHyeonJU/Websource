package domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageVO {
	//page 나누기 정보를 담은 객체
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private SearchVO search;
	private int totalRow;
	
	public pageVO(int total,SearchVO search) {
		this.totalRow = totalRow;
		this.search = search;
		
		//현재 화면의 시작 페이지 수
		endPage = (int)(Math.ceil(search.getPage()/10.0))*10;
		//현재 화면의 시작 페이지 수
		startPage = endPage-9;
		
		//끝나는 페이지가 10개가 안되는 경우 다시 계산
		int realEnd = (int)(Math.ceil(totalRow/1.0)/search.getAmount());
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage>1;
		this.next = this.endPage<realEnd;
	}
}