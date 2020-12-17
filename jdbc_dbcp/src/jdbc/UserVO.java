package jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//UserVO : 유저의 정보를 담을 객체(바구니라 생각하면 됨)
//sql 에서 보면 테이블모양 => ResultSet(첫번째 행 가져옴)을 이용해서 담음
//일단 한사람의 정보를 담기

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserVO {
	private int no;
	private String username;
	private int birthyear;
	private String addr;
	private String mobile;
	
	//생성자, getter, setter, toString 생성 => lombok 플러그인 사용(@getter...)
	
	
}
