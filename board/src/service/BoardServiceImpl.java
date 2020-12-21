package service;

import java.sql.Connection;
import java.util.List;

import domain.BoardVO;
import persistence.BoardDAO;
import static persistence.JDBCUtil.*;
public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	private Connection con;
	
	
	public BoardServiceImpl() {
		con = getConnection();
		dao = new BoardDAO(con);
	}
	
	@Override
	public boolean insertArticle(BoardVO vo) {
		return false;
	}

	@Override
	public boolean updateArticle(BoardVO vo) {
		return false;
	}

	@Override
	public boolean deleteArticle(int bno) {
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		return null;
	}

	@Override
	public BoardVO getRow(int bno) {
		return null;
	}

}
