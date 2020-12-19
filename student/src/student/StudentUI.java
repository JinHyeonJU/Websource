package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentUI {

	public static void main(String[] args) {
		boolean isStop = false;
		
		Scanner sc = new Scanner(System.in);
		StudentConsoleUtil util = new StudentConsoleUtil();
		List<Student> list = new ArrayList<Student>();
		
		do {
			System.out.println("--------- <학생 정보 관리 프로그램> ---------");
			System.out.println("1. 학생정보 입력");
			System.out.println("2. 학생정보 전체 조회");
			System.out.println("3. 학생정보 개별 조회");
			System.out.println("4. 프로그램 종료");
			System.out.print("선택 : ");
			
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: //학생정보 입력
				Student student = util.getNewStudent(sc);
				list.add(student);
				util.printAddSuccessMessage(student);
				break;
			case 2: //학생정보 전체 조회
				util.printAllStudentList(list);
				break;
			case 3: //학생정보 개별 조회
				util.printStudent(sc, list);
				break;
			case 4: //프로그램 종료
				System.out.println("프로그램 종료");
				isStop = true;
				break;
			}
		}while (!isStop);	
	}
}
