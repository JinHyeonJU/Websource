package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static persistence.JDBCUtil.*;

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO() {
		this.con = con;
	}
	
	public int insert(String name) {
		int result = 0;
		try {
			pstmt = con.prepareStatement("insert into memberTBL values()");
			
			if(result > 0) {
				commit(con);
			}
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(con);
		}
	}
	public int delete(String name) {
		System.out.println("memberDAO delete "+name);
		return 1;
	}
}
