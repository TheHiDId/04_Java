package condition.service;

import java.util.Scanner;

/**
 * 기능(예제, 연습 문제) 제공용 클래스
 */
public class ConditionService {
	
	// 필드(field) == 멤버 변수 == 인스턴스 변수
	// 해당 클래스 내에서 언제 어디서든지 사용 가능한 변수
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 1 ~ 10 사이 난수(정수)의 짝홀 판별
	 */
	public void method1() {
		int randomNum = (int)(Math.random() * 10 + 1);
		
		boolean result = randomNum % 2 == 0; // 0이면 짝수, 1이면 홀수
		
		System.out.print(randomNum + "은 ");
		
		if(result) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
	}
	
	/**
	 * 나이를 입력 받아 어린이, 청소년, 성인 구분 1
	 */
	public void method2() {
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		if(age <= 13) {
			System.out.print("어린이입니다.");
		} else if(age <= 19) {
			System.out.print("청소년입니다.");
		} else {
			System.out.print("성인입니다.");
		}
	}
	
	
	/**
	 * 나이를 입력 받아 어린이, 청소년, 성인 구분 2
	 */
	public void method3() {
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		if(age < 0 || age >= 100) {
			System.out.print("잘못된 입력");
		} else if(age <= 13) {
			System.out.print("어린이");
		} else if(age <= 16) {
			System.out.print("청소년(중)");
		} else if(age <= 19) {
			System.out.print("청소년(고)");
		} else {
			System.out.print("성인");
		}
	}
	
	/**
	 * 컨디션서비스에 작성된 메서드를 골라서 실행하는 메서드
	 */
	public void displayMenu() {
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		
		System.out.print("메뉴 번호 입력 >> ");
		int input = sc.nextInt();
		
		switch(input) { // 같은 클래스 내 필드, 메서드는 이름만 부르면 호출 가능
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		default: System.out.println("잘못된 입력");
		}
	}
}