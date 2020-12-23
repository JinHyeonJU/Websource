package service;

import java.sql.Connection;
import java.util.List;
import domain.ColorVO;
import persistence.ColorDAO;

import static persistence.JDBCUtil.*;

public class ColorServiceImpl implements ColorService {

	private ColorDAO dao;
	private Connection con;
	
	public ColorServiceImpl() {
		con = getConnection();
		dao = new ColorDAO(con);
	}
	@Override
	public boolean addArticle(ColorVO vo) {
		boolean addFlag = false;
		
		int result 
		return false;
	}

	@Override
	public boolean updateArticle(ColorVO vo) {
		return false;
	}

	@Override
	public boolean deleteArticle(ColorVO vo) {
		return false;
	}

	@Override
	public List<ColorVO> getList() {
		return null;
	}

	@Override
	public boolean hitUpdate(int bno) {
		return false;
	}

}
