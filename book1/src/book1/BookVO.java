package book1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// VO : Value Object
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookVO {
	private int code;
	private String title;
	private String writer;
	private int price;
}
