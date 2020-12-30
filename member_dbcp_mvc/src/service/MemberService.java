package service;

import domain.MemberVO;

public interface MemberService {
	public MemberVO login(String userid, String password);
	public boolean registerMember(MemberVO member);
	public boolean updateMember(String userid, String password);
	public boolean leaveMember(String userid, String password);
	//중복아이디
	public boolean checkIdMember(String userid);
}
