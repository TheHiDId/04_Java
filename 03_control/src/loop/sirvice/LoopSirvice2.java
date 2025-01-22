package loop.sirvice;

import java.util.Scanner;

/**
 * 반복문 기능 제공 클래스 2
 */
public class LoopSirvice2 {
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("[LoopSirvice2]");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		
		System.out.println();
		
		System.out.print("실행할 메서드 번호 입력 >> ");
		int input = sc.nextInt();
		
		System.out.println();
		
		switch(input) {
		case 1: method1(); break;
		case 2: method2(); break;
		case 3: method3(); break;
		case 4: method4(); break;
		case 5: method5(); break;
		default: System.out.println("잘못된 입력");
		}
	}
	
	/**
	 * 다음 모양 출력
	 * <pre>
	 * (0, 0) (0, 1) (0, 2)
	 * (1, 0) (1, 1) (1, 2)
	 * (2, 0) (2, 1) (2, 2)
	 * (3, 0) (3, 1) (3, 2)
	 * </pre>
	 */
	public void method1() {
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 2; j++) {
				System.out.printf("(%d, %d) ", i, j);
			}
			
			System.out.println();
		}
	}
	
	/*
	 * 분기문
	 * break: 현재 반복 종료
	 * continue: 다음 반복으로 이동
	 */
	
	/**
	 * 1 ~ 20까지 출력하되 입력 받은 수에서 반복을 중지
	 */
	public void method2() {
		System.out.print("반복을 중지할 정수 입력: ");
		int stopNum = sc.nextInt();
		
		for(int i = 1; i <= 20; i ++) {
			System.out.print(i + " ");
			
			if(i == stopNum) {
				break;
			}
		}
	}
	
	/**
	 * 1 ~ 20까지 출력하되 입력받은 정수의 배수는 미출력
	 */
	public void method3() {
		System.out.print("미출력할 정수 입력: ");
		int skipNum = sc.nextInt();
		
		for(int i = 1; i <= 20; i ++) {
			if(i % skipNum == 0) {
				continue;
			}
			
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 0이 입력될 때 까지 입력된 모든 숫자들의 합계 출력
	 */
	public void method4() {
		int sum = 0;
		int input = -1;
		
		while(input != 0) { // 0이 아닐 때 반복
			System.out.print("정수 입력: ");
			input = sc.nextInt();
			sum += input;
		}	
		
		System.out.println("합계: " + sum);
	}
	
	/*
	 * do ~ while
	 * while 조건식이 시작이 아닌 마지막 부분으로 이동한 반복문
	 * 최소 1회 이상의 반복이 보장됨 (무조건 한번은 실행)
	 * 
	 * do {} while(조건식);
	 */
	
	public void method5() {
		int sum = 0;
		int input = 0; // int 기본값 0으로 시작하고 싶을 때
		
		do { // 일단 1회 이상은 무조건 실행
			System.out.print("정수 입력: ");
			input = sc.nextInt();
			sum += input;
		}	while(input != 0);
		
		System.out.println("합계: " + sum);
	}
}