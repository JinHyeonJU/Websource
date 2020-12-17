package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	// ~DAO : DB 작업을 담당하는 클래스
	// JDBC : 드라이버로드, 커넥션, CRUD(select, update, delete, insert) 
	// static => 객체생성을 하지않고 바로 사용가능
	/*
	 * static { try { Class.forName("oracle.jdbc.OracleDriver");
	 * }catch(ClassNotFoundException e) { e.printStackTrace(); } }
	 */
	public Connection getConnection() {
		//2.데이터베이스 연결을 위한 문자열 생성
		//3.커넥션
		Connection con = null;
		//3.커넥션
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oralce");
			con = ds.getConnection(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//CRUD
	//insert
	public int insert(String username, String birthyear, String addr, String mobile) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			if(con!=null){
				//sql 구문 생성
				String sql = "insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
				//Statement 생성 후 전송
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(birthyear));
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);

				//sql구문 실행하고 결과 받기
				result = pstmt.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}//insert

	//조회
	//전체조회
	public List<UserVO> select() {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//비어있는 박스(list) 생성
		List<UserVO> list = new ArrayList<UserVO>();

		try {
			if (con != null) {
				String sql = "select * from userTBL order by no desc";
				//5.Statment 생성 후 전송 : DB연결을 통해 sql문을 수행해 주는 클래스
				pstmt = con.prepareStatement(sql);

				//6.sql 구문 실행 하고 결과 받기
				//select : executeQuery() => ResultSet,
				//insert, update, delete : executeUpdate() => int
				rs = pstmt.executeQuery();

				//7.결과 출력(ResultSet : DB Select 결과를 담는 특수한 객체(테이블 구조))
				while (rs.next()) {
					//UserVO(바구니) 객체 생성
					UserVO user = new UserVO();

					//바구니에 값 담기
					user.setNo(rs.getInt(1));;
					user.setUsername(rs.getString(2));
					user.setBirthyear(rs.getInt(3));
					user.setAddr(rs.getString(4));
					user.setMobile(rs.getString(5));

					//박스(list)에 담기
					list.add(user);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//박스채로 넘겨주기
		return list;
	}

	//개별조회
	public UserVO getUser(String no) {
		//DB 연결 후 사용자의 no에 해당하는 정보 가져오기
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;

		try{
			if(con!=null) {
				String sql = "select * from userTBL where no=?";
				//sql구문 전송
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(no));
				//sql 실행
				rs = pstmt.executeQuery();
				//while = 조건(?가)이 여러개일때. if는 굳이 while필요 x
				//보내야되는 값 no,name. 2개.
				//한사람의 정보만 출력하는거니 list x VO 사용

				if(rs.next()){
					user = new UserVO();
					user.setNo(rs.getInt("no"));
					user.setUsername(rs.getString("username"));
				}//if
			}//if
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		return user;
	}

	public int deleteUser(int no) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			if(con!=null){
				String sql ="delete from userTBL where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{            
				pstmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateUser(int no,String addr, String mobile) {
		 Connection con = getConnection();
		   PreparedStatement pstmt = null;
		   int result = 0;
		   try{
		      if(con!=null){
		         String sql = "update userTBL set addr=?, mobile=? where no=?";
		         //생성 후 전송
		         pstmt = con.prepareStatement(sql);
		         //? 에 해당하는 값을 set 하기
		         pstmt.setString(1, addr);
		         pstmt.setString(2, mobile);
		         pstmt.setInt(3, no);
		         //구문 실행 후 결과 받기
		         result = pstmt.executeUpdate();
		      }
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         pstmt.close();
		         con.close();
		      }catch(Exception e){
		         e.printStackTrace();
		      }
		   }
		   return result;
	}
}