package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {
	//DAO와 연동 - CRUD
	public boolean insertMember(String name);
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
	
}
