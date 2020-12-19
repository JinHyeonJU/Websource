package student;

public class Student {
	private int number;
	private String name;
	private int grade;
	private String addr;
	private String birth;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Student(int number, String name, int grade, String addr, String birth) {
		super();
		this.number = number;
		this.name = name;
		this.grade = grade;
		this.addr = addr;
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "StudentConsoleUtil [number=" + number + ", name=" + name + ", grade=" + grade + ", addr=" + addr
				+ ", birth=" + birth + "]";
	}
	public Student() {}
	
}
