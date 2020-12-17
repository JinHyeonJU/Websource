package service;

import java.sql.Connection;
import java.util.List;
import domain.BookVO;
import persistence.BookDAO;
import static persistence.JDBCUtil.*;

public class BookServiceImpl implements BookService {

	Connection con;
	BookDAO dao;
	
	public BookServiceImpl() {
		con = getConnection();
		dao = new BookDAO(con);
	}
	
	@Override
	public boolean insertBook(BookVO vo) {
		return false;
	}

	@Override
	public boolean updateBook(BookVO vo) {
		return false;
	}

	@Override
	public boolean deleteBook(int code) {
		return false;
	}

	@Override
	public BookVO getRow(int code) {
		return null;
	}

	@Override
	public List<BookVO> getList() {
		return null;
	}

}
