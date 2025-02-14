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
		
		for(Member member : mDAO.getMemberList()) {
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
		
		return mDAO.getMemberList();
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
	public String updateAmount(Member target, int acc) throws IOException, ClassNotFoundException {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		
		// 누적 금액 전후
		int beforeAmount = target.getAmount();
		int totalAmount = target.getAmount() + acc;
		
		// 등급 변경에 따른 메시지
		String alertMassege = "등급이 유지됩니다"; 
		
		// 기존 정보 삭제
		
		
		// 등급 변경 로직
		if(beforeAmount < 100_000) {
			if(totalAmount >= 1_000_000) {
				target.setGrade(2);
				
				alertMassege = "* 다이아 * 등급으로 변경 되셨습니다";
			} else if(totalAmount >= 100_000) {
				target.setGrade(1);
				
				alertMassege = "* 골드 * 등급으로 변경 되셨습니다";
			}
		}
		
		if(beforeAmount >= 100_000 && beforeAmount < 1_000_000) {
			if(totalAmount >= 1_000_000) {
				target.setGrade(2);
				
				alertMassege = "* 다이아 * 등급으로 변경 되셨습니다";
			}
		}
		
		// 타겟에 후 누적 금액 입력
		target.setAmount(totalAmount);
		
		// 타겟 회원 목록에 추가
		mDAO.addMember(target);
		
		// 메시지 리턴
		return beforeAmount + " -> " + totalAmount + "\n" + alertMassege;
	}

	@Override
	public String updateMember(Member target, String phone) throws IOException {

		return null;
	}

	@Override
	public String deleteMember(Member target) throws IOException, ClassNotFoundException {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		
		// 기존에 존재하는 정보 삭제
		mDAO.getMemberList().remove(target);
		
		mDAO.saveFile();
		
		return null;
	}
}
