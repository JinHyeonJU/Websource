package service;

import java.util.List;

import domain.MemberVO;
import persistence.MemberDAO;

public class MemberServiceImpl implements MemberService {

	@Override
	public boolean insertMember(String name) {
	System.out.println("delete service "+name);
	
	MemberDAO dao = new MemberDAO();
		return dao.insert(name)>0?true:false;
	}

	@Override
	public boolean updateMember(String name) {
		return false;
	}

	@Override
	public boolean deleteMember(String name) {
		System.out.println("delete service "+name);
		
		MemberDAO dao = new MemberDAO();
		return dao.delete(name)>0?true:false;
	}

	@Override
	public MemberVO getMember(String name) {
		return null;
	}

	@Override
	public List<MemberVO> getList() {
		return null;
	}

}
