package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDAOImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	
	public MemberServiceImpl() {}

	@Override
	public boolean addMember(String name, String phone) throws IOException, ClassNotFoundException {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		Member newMember = new Member();
		
		List<Member> memberList = mDAO.getMemberList();
		
		for(Member member : memberList) {
			if(member.getPhone().equals(phone)) return false;
		}
		
		newMember.setName(name);
		newMember.setPhone(phone);
		newMember.setAmount(0);
		newMember.setGrade(0);
		
		mDAO.addMember(newMember);
		
		return true;
	}

	@Override
	public List<Member> getMemberList() throws IOException, ClassNotFoundException {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		
		List<Member> memberList = mDAO.getMemberList();
		
		return memberList;
	}

	@Override
	public List<Member> selectName(String searchName) throws IOException, ClassNotFoundException {
		List<Member> searchResult = new ArrayList<Member>();
		
		for(Member member : getMemberList()) {
			if(member.getName().equals(searchName)) {
				searchResult.add(member);
			}
		}
		
		return searchResult;
	}

	@Override
	public String updateAmount(Member target, int acc) throws IOException {

		return null;
	}

	@Override
	public String updateMember(Member target, String phone) throws IOException {

		return null;
	}

	@Override
	public String deleteMember(Member target) throws IOException {

		return null;
	}
}
