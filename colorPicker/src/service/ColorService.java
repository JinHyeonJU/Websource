package service;

import java.util.List;

import domain.ColorVO;

public interface ColorService {	
	//CRUD
	public boolean addArticle(ColorVO vo);
	public boolean updateArticle(ColorVO vo);
	public boolean deleteArticle(ColorVO vo);
	//게시글 전체 조회
	public List<ColorVO> getList();
	//조회수 업데이트
	public boolean hitUpdate(int bno);

}
