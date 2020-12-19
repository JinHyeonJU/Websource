package member;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleUtil {
	Scanner sc = new Scanner(System.in);
	
	public Member getNewMember(Scanner sc) {
		Member member = new Member();
		
		System.out.println("등록할 회원 정보를 입력하세요");
		System.out.print("아이디 : ");
		int id = sc.nextInt();
		/* member.setId(sc.nextInt()); 
		 * return member 해도됨 */
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("주소 : ");
		String addr = sc.next();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("국가 : ");
		String nation = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		return new Member(id, name, addr, nation, email, age);
	}
	
	public void printAddSuccessMessage(Member member) {
		System.out.println(member.getName() + " 회원 정보 추가 성공 ");
	}
	
	public void printMemberList(List<Member> list) {
		System.out.println("회원아이디\t   이름\t주소\t이메일\t국가\t나이\t");
		
		for(Member member:list) {
			System.out.printf("%5d",member.getId());
			System.out.printf("%7s",member.getName());
			System.out.printf("%8s",member.getAddr());
			System.out.printf("%18s",member.getEmail());
			System.out.printf("%6s",member.getNation());
			System.out.printf("%8d",member.getAge());
			System.out.println();
		}
	}
	public Member getUpdateMember(Scanner sc, List<Member> list) {
        System.out.print("수정할 회원의 아이디를 입력하세요 : ");
        int id = sc.nextInt();
        //아이디가 있다면 수정
        Member member = null;
        for(int i=0; i<list.size(); i++) {
           member = list.get(i);
           if(member.getId()==id) {
              System.out.println("수정할 주소를 입력하세요.");
              String addr = sc.next();
              System.out.println("수정할 이메일을 입력하세요.");
              String email = sc.next();
              
              //입력받은 값을 해당 객체에 변경한 후 리턴
              member.setAddr(addr);
              member.setEmail(email);
              
              return member;
           }
        }         
        return null;      
     }
	public void printModifySuccessMessage(Member member) {
		System.out.println(member.getName() + " 회원 정보 수정 성공 ");
	}
	public void printModifyFailMessage() {
		System.out.println(" 회원 정보 수정 실패 ");
	}
	
	
	public Member removeMember(Scanner sc, List<Member> list) {
		 System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
	        int id = sc.nextInt();
	        
	        Member member = null;
	        for(int i=0; i<list.size(); i++) {
	            member = list.get(i);
	            if(member.getId()==id) {
	            	System.out.println("정말로 삭제하시겠습니까? 예(1) 아니오(2) ");
	            	int no = sc.nextInt();
	            	if(no==1) {
	            		list.remove(i);
	            		return member;	            		
	            }
	        }
	    }
	        return null;
	}
	public void printRemoveSuccessMessage(Member member) {
		System.out.println(member.getName() + " 회원 정보 삭제 성공 ");
	}
	public void printRemoveFailMessage() {
		System.out.println(" 회원 정보 삭제 실패 ");
	}
}
