package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.BookVO;
import oracle.jdbc.proxy.annotation.Pre;

public class BookDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BookDAO(Connection con) {
		this.con = con;
	}
	
	//book insert
	// insert into bookTBL values(1001, '이것이 자바다', '신용균', 28000);
	public int bookInsert(int code, String title, String writer, int price) {
		int result = 0;
		try {
			String sql = "insert into bookTBL values(?,?,?,?)";
			//sql문 전송
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setInt(4, price);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}//insert 종료
	
	//전체조회
	public List<BookVO> getList() {
		List<BookVO> list = new ArrayList<>();
		
		try {
			String sql = "select * from bookTBL order by code desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}//getList
	
	
	//delete from bookTBL where code=?
	public int bookDelete(int code) {
		int result = 0;
		
	try {
		String sql = "delete from bookTBL where code=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, code);
		result = pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
	}
	
	public int bookUpdate(int price, int code) {
		int result = 0;
		
		try {
			String sql = "update bookTBL set price=? where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, code);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public List<BookVO> bookSearch(String criteria, String keyword) {
		//코드가 2001 번인 책 검색
		//select * from bookTBL where code=?;
		//criteria = 코드 or writer
		//작가가 홍길동 검색하기
		//select * from bookTBL where writer='?';
//		String sql = "select * from bookTBL where " + criteria + "= ?";
		
		String sql = "";
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			if(criteria.equals("code")) {
			sql = "select * from bookTBL where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(keyword));
			} else {
			sql = "select * from bookTBL where writer=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
}
