package member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//Data : get,set,equals,noargs,allargs,hasCode,toString
@Data
public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
