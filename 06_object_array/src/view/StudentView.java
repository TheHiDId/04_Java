package view;

import java.util.Scanner;

import dto.StudentDTO;
import service.StudentService;

public class StudentView {
	private Scanner sc = new Scanner(System.in);
	
	private StudentService service = new StudentService();
	
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n[학생 관리 프로그램]");
			System.out.println();
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			System.out.println();
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			
			switch(input) {
			case 1: ; break;
			case 2: allStudent(); break;
			case 3: ; break;
			case 4: ; break;
			case 5: ; break;
			case 6: ; break;
			case 7: ; break;
			case 0: System.out.println("-프로그램 종료-"); break;
			default: System.out.println("-잘못된 입력-");
			}
		} while(input != 0);
	}
	
	/**
	 * 학생 전체 조회 메서드
	 */
	private void allStudent() {
		System.out.printf("\n[학생 전체 조회]\n");
		
		StudentDTO[] studentInfo = service.getStudentInfo();
		
		for(StudentDTO student : studentInfo) {
			if(student == null) {
				continue;
			}
			
			/*
			 * 참조 변수를 문자열 만들 때, 또는 print() 관련 메서드에 사용될 때,
			 * 참조 변수에 저장된 주소가 출력되면 이상하므로 컴파일러가 자동으로 참조 변수를 호출하도록 변경
			 */
			
			System.out.println(student.toString());
		}
	}
}
