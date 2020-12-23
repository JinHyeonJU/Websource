package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColorVO {
	private int bno;
	private String name;
	private String password;
	private String title;
	private String attach;
	private int readcount;
	private Date regdate;
}
