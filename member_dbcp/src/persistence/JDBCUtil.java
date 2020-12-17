package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.jdbc.pool.DataSource;

public class JDBCUtil {
	Connection con = null;
	try {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
		con = ds.getConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	// 실패 시 리턴 값
	return con;
}
public void commit(Connection con) {
	try {
		con.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	public void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	public void close(PreparedStatement pstmt) {
			try {
				pstmt.close();
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	public void close(ResultSet rs) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
}
