package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUI {

	public static void main(String[] args) {
		boolean isStop = false; //반복문을 종료할때 사용
		
		Scanner sc = new Scanner(System.in); //키보드에서 입력받기
		MemberConsoleUtil util = new MemberConsoleUtil();
		List<Member> list = new ArrayList<Member>();
		
		//1번은 실행할거기 때문에 do~while문사용
		do {
			System.out.println("===== 회원관리 프로그램 =====");
			System.out.println("1. 회원등록");
			System.out.println("2. 회원목록보기");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보삭제");
			System.out.println("5. 종료");
			System.out.print("메뉴 번호 : ");
			//사용자한테 번호 입력받기
			int menu = sc.nextInt();
			
			//메뉴번호에 따라 출력문 제시 switch문
			switch(menu) {
			case 1: //회원등록
				Member member = util.getNewMember(sc);
				list.add(member);
				util.printAddSuccessMessage(member);
				break;
			case 2: //회원목록보기
				util.printMemberList(list);
				break;
			case 3: //회원정보수정
				member = util.getUpdateMember(sc, list);
				if(member==null) {
					util.printModifyFailMessage();
				}else {
					util.printModifySuccessMessage(member);
				}
				break;
			case 4: //회원정보삭제
				member = util.removeMember(sc, list);
				if(member==null) {
					util.printRemoveFailMessage();
				}else {
					util.printRemoveSuccessMessage(member);
				}
				break;
			case 5: //종료
				System.out.println("프로그램을 종료합니다.");
				isStop = true;
				break;
			}
			
		} while(!isStop);
	}
}
