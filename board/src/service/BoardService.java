package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	// CRUD
	public boolean insertArticle(BoardVO vo);
	public boolean updateArticle(BoardVO vo);
	public boolean deleteArticle(int bno, String password);

	// 조회(전체 / 개별)
	public List<BoardVO> getList();
	public BoardVO getRow(int bno);
	//게시글 전체 행 수
	public int getRows(); 
	
	// 조회수 업데이트
	public boolean hitUpdate(int bno);
	
	//댓글
	public boolean insertReply(BoardVO reply);
}