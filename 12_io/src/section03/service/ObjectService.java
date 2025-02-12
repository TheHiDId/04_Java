package section03.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import section03.dto.Member;

public class ObjectService {
	/**
	 * 멤버 객체 하나를 파일로 출력하기
	 */
	public void outputMember() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			Member m1 = new Member("m1234", "qwer1234", "짱구"); // 출력할 멤버 객체 생성
			
			fos = new FileOutputStream("io_test\\byte\\Member.bin"); // 파일 출력 기반 스트림 객체 생성
			
			oos = new ObjectOutputStream(fos); // 객체 출력 보조 스트림 객체 생성
			
			oos.writeObject(m1); // 보조 스트림을 이용해서 파일에 멤버 객체 출력
			
			System.out.println("출력 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(oos != null) oos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void inputMember() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("io_test\\byte\\Member.bin"); // 입력 기반 스트림 생성
			
			ois = new ObjectInputStream(fis); // 객체 입력 보조 스트림 생성
			
			Member member = (Member)ois.readObject(); // 파일에 존재하는 멤머 객체는 직렬화된 상태이므로 readObject() 호출 시 자동으로 역직렬화 수행
			
			System.out.println("읽어온 Member");
			System.out.println(member);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
				try {
					if(ois != null) ois.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void outputMemberList() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			List<Member> memberList = new ArrayList<Member>();
			
			memberList.add(new Member("m1", "p1", "짱구"));
			memberList.add(new Member("m2", "p2", "철수"));
			memberList.add(new Member("m3", "p3", "유리"));
			memberList.add(new Member("m4", "p4", "맹구"));
			memberList.add(new Member("m5", "p5", "훈이"));
			
			fos = new FileOutputStream("io_test\\byte\\MemberList.bin");
			
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(memberList);
			
			System.out.println("회원 목록 출력 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(oos != null) oos.close(); // 보조 스트림 닫으면 기반 스트림도 같이 닫힘
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void inputMemberList() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("io_test\\byte\\MemberList.bin");
			
			ois = new ObjectInputStream(fis);
			
			List<Member> members = (List<Member>)ois.readObject();
			
			for(Member m : members) {
				System.out.println(m);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(ois != null) ois.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
