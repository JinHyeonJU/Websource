package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {
	//CRUD
	public boolean insertArticle(BoardVO vo);
	public boolean updateArticle(BoardVO vo);
	public boolean deleteArticle(int bno);
	//게시글 전체 조회
	public List<BoardVO> getList();
	//게시글 특정 번호 조회
	public BoardVO getRow(int bno);
}
