package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ColorVO;

import java.sql.Connection;
import static persistence.JDBCUtil.*;

public class ColorDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ColorDAO(Connection con) {
		this.con=con;
	}
	
	
	//CRUD
	public int addColor(ColorVO vo) {
		String sql="insert into colorPicker(bno,name,title,password,attach) "
				+ "values(color_seq.nextval,?,?,?,?)";
		int result = 0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getAttach());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
