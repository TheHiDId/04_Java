package view;

import service.MemberService;
import service.MemberServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Member;

public class MemberView {
	private MemberService service = null;
	private Scanner sc = null;
	
	BufferedReader br = null;

	/**
	 * 기본 생성자 - MemberView 객체 생성 시 필드 초기화 - MemberService 초기화 시 예외가 발생할 수 있으므로 try -
	 * catch 작성
	 */
	public MemberView() {

		try {
			// 객체 생성 중 발생한 예외를 View에 모아서 처리
			service = new MemberServiceImpl();

			// 키보드를 입력 받기 위한 스트림 생성
			sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

		} catch (Exception e) {

			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
	}

	// -------------------------------------------------------------------
	// [메인 메뉴]
	public void mainMenu() {

		int input = 0;
		do {

			try {
				// 메뉴 출력 후 입력된 번호를 반환 받기
				System.out.println("\n===== 회원 관리 프로그램 =====\n");

				System.out.println("1. 회원 가입(추가)");
				System.out.println("2. 회원 전체 조회");
				System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
				System.out.println("4. 특정 회원 사용 금액 누적하기");
				System.out.println("5. 회원 정보 수정");
				System.out.println("6. 회원 탈퇴");
				System.out.println("0. 종료");
				
				System.out.println();

				System.out.print("메뉴 선택 >>> ");

				// 입력 받은 문자열을 int 형태로 변환
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				
				System.out.println();

				// 선택된 메뉴 번호에 따라 case 선택
				switch (input) {
				case 1: addMember(); break;
				case 2: selectAll(); break;
				case 3:	selectName(); break;
				case 4: updateAmount();	break;
				case 5:	updateMember();	break;
				case 6:	deleteMember();	break;
				case 0:	System.out.println("*** 프로그램 종료 ***");	break;
				default:	System.out.println("### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				System.out.println("=======================================");

				
				/* 모든 메서드에서 던져진 예외를 모아서 처리*/
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요 ###\n");
				input = -1; // 첫 반복에서 종료되지 않게 값 변경

			} catch (IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace(); // 예외 추적

			} catch (Exception e) { // 나머지 예외 처리
				e.printStackTrace();
			}

		} while (input != 0);
	}

	
	// ---------------------------------------------------------------
	// [1. 회원 가입(추가)]
	public void addMember() throws IOException, ClassNotFoundException {
		System.out.println("----- 회원 가입(추가) -----\n");

		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.println();
		
		String phone = null;
		
		do {
			System.out.print("휴대폰 번호 입력: ");
			phone = sc.nextLine();
			
			System.out.println();
			
			if(phone.length() != 11) System.out.println("*** 다시 입력 해주세요 ***\n");
		} while(phone.length() != 11);
		
		if(service.addMember(name, phone)) {
			System.out.println("*** 회원이 추가 되었습니다 ***\n");
		} else {
			System.out.println("### 중복되는 휴대폰 번호가 존재합니다 ###\n");
		}
	}

	
	// -------------------------------------------------------------
	// [2. 회원 전체 조회]
	public void selectAll() throws IOException, ClassNotFoundException {
		System.out.println("----- 회원 전체 조회 -----\n");
		
		String grade = null;
		
		System.out.println("---------------------------------------");
		System.out.println("[이름] [휴대폰 번호] [누적 금액] [등급]");
		System.out.println("---------------------------------------");
		
		for(Member member : service.getMemberList()) {
			if(member.getGrade() == 0) grade = "일반";
			else if(member.getGrade() == 1) grade = "골드";
			else grade = "다이아";
			
			System.out.printf("%3s %12s %11d %4s\n", member.getName(), member.getPhone(), member.getAmount(), grade);
		}
	}

	// ------------------------------------------------------------------------
	// [3. 이름으로 검색(동명이인)]
	public void selectName() throws IOException, ClassNotFoundException {
		System.out.println("----- 이름 검색(동명이인 모두 조회) -----\n");
		
		System.out.print("검색할 이름 입력: ");
		String searchName = sc.nextLine();
		
		System.out.println();
		
		for(Member result : service.selectName(searchName)) {
			System.out.println(result);
		}
	}

	// ------------------------------------------------------------
	// [4. 특정 회원 사용 금액 누적하기]
	public void updateAmount() throws IOException, ClassNotFoundException {
		System.out.println("----- 특정 회원 사용 금액 누적하기 -----\n");
		
		// 회원 이름 입력
		System.out.print("회원 이름 입력: ");
		String targetName = sc.nextLine();
		
		System.out.println();
		
		Member target = null;
		
		// 입력받은 이름과 같은 이름을 가진 회원 리스트
		List<Member> targetNameList = service.selectName(targetName);
		
		// 입력받은 이름이 존재하지 않을 경우 리턴
		if(targetNameList.isEmpty()) {
			System.out.println("### 이름이 일치하는 회원이 존재하지 않습니다 ###");
			
			return;
		}
		
		// 입력받은 이름과 같은 회원이 하나일 경우 타겟에 입력
		target = targetNameList.get(0);
		
		// 입력받은 이름과 같은 회원이 둘 이상일 경우
		if(targetNameList.size() > 1) {
			// 선택지 출력
			for(int i = 0; i < targetNameList.size(); i++) {
				System.out.println((i + 1) + ") " + targetNameList.get(i).getName() + " (" + targetNameList.get(i).getPhone() + ")");
			}
			
			System.out.println();
			
			// 선택지 번호 입력
			System.out.print("선택할 회원의 번호를 입력: ");
			int selectNum = sc.nextInt();
			
			// 선택지에 없는 번호 입력 시 리턴
			if(selectNum < 1 || selectNum > targetNameList.size()) {
				System.out.println("### 잘못된 번호를 입력하셨습니다. 다시 시도해주세요 ###");
				
				return;
			}
			
			// 입력한 선택지 번호에 해당하는 회원 타겟에 입력
			target = targetNameList.get(selectNum - 1);
		}
		
		// 추가로 누적시킬 금액 입력
		System.out.print("누적할 금액 입력: ");
		int acc = sc.nextInt();
		
		System.out.println(service.updateAmount(target, acc));
	}

	// -----------------------------------------------------------------
	// [5.회원 정보 수정]
	public void updateMember() throws IOException {
		System.out.println("----- 회원 정보 수정 -----\n");

	}

	
	// ------------------------------------------------------------
	// [6.회원 탈퇴]
	public void deleteMember() throws IOException, ClassNotFoundException {
		System.out.println("----- 회원 탈퇴 -----\n");
		
		System.out.print("회원 이름 입력: ");
		String targetName = sc.nextLine();
		
		Member target = null;
		
		// 입력받은 이름과 같은 이름을 가진 회원 리스트
		List<Member> targetNameList = service.selectName(targetName);
		
		// 입력받은 이름이 존재하지 않을 경우 리턴
		if(targetNameList.isEmpty()) {
			System.out.println("### 이름이 일치하는 회원이 존재하지 않습니다 ###");
			
			return;
		}
		
		// 입력받은 이름과 같은 회원이 하나일 경우 타겟에 입력
		target = targetNameList.get(0);
		
		// 입력받은 이름과 같은 회원이 둘 이상일 경우
		if(targetNameList.size() > 1) {
			// 선택지 출력
			for(int i = 0; i < targetNameList.size(); i++) {
				System.out.println((i + 1) + ") " + targetNameList.get(i).getName() + " (" + targetNameList.get(i).getPhone() + ")");
			}
			
			System.out.println();
			
			// 선택지 번호 입력
			System.out.print("선택할 회원의 번호를 입력: ");
			int selectNum = sc.nextInt();
			
			// 선택지에 없는 번호 입력 시 리턴
			if(selectNum < 1 || selectNum > targetNameList.size()) {
				System.out.println("### 잘못된 번호를 입력하셨습니다. 다시 시도해주세요 ###");
				
				return;
			}
			
			// 입력한 선택지 번호에 해당하는 회원 타겟에 입력
			target = targetNameList.get(selectNum - 1);
			
			System.out.print("정말 탈퇴 하시겠습니까? (y/n): ");
			char check = sc.next().toLowerCase().charAt(0);
			
			if(check == 'n') {
				System.out.println("### 탈퇴 취소 ###");
				
				return;
			}
			
			if(check != 'y') {
				System.out.println("### 잘못된 입력입니다. 다시 시도해주세요 ###");
				
				return;
			}
			
			System.out.println(service.deleteMember(target));
		}
	}
}