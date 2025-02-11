package section03.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
}
