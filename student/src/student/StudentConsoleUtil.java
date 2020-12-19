package student;

import java.util.List;
import java.util.Scanner;

public class StudentConsoleUtil {
	Scanner sc = new Scanner(System.in);
	public Student getNewStudent(Scanner sc) {
		Student student = new Student();
		
		System.out.println("---- 새로운 학생 정보 입력 ----");
		System.out.println("학 번 : ");
		int number = sc.nextInt();
		
		System.out.println("이 름 : ");
		String name = sc.next();
		
		System.out.println("학 년 : ");
		int grade = sc.nextInt();
		
		System.out.println("주 소 : ");
		String addr = sc.next();
		
		System.out.println("생 일(예시 : 05/11) : ");
		String birth = sc.next();
		
		return new Student(number, name, grade, addr, birth);
	}
	
	public void printAddSuccessMessage(Student student) {
		System.out.println(student.getName() + "학생 정보가 입력되었습니다.");
	}
	
	public void printAllStudentList(List<Student> list) {
		System.out.println("---- 학생 정보 보기 ----");
		System.out.println("학번\t이름\t학년\t주소\t생일");
		System.out.println("--------------------");
		
		for(Student student:list) {
			System.out.printf("%5d",student.getNumber());
			System.out.printf("%7s",student.getName());
			System.out.printf("%5d",student.getGrade());
			System.out.printf("%8s",student.getAddr());
			System.out.printf("%8s",student.getBirth());
			System.out.println();
		}
	}
	public void printStudent(Scanner sc, List<Student> list) {
		System.out.println("검색하고자 하는 학생의 학번을 입력하세요 :");
		int sel = sc.nextInt();
		
		Student student = null;
		for(int i=0; i<list.size(); i++) {
			student = list.get(i);
			if(student.getNumber()==sel) {
		System.out.println("---- 학생 개별 정보 보기 ----");
		System.out.printf("이 름 :"+student.getName());
		System.out.printf(" 학 년 :"+student.getGrade());
		System.out.printf(" 주 소 :"+student.getAddr());
		System.out.printf(" 생 일 :"+student.getBirth());
		System.out.println();
			}
		}
	}
}
