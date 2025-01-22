package loop.sirvice;

import java.util.Scanner;

/**
 * 반복문 기능 제공 클래스 1
 */
public class LoopSirvice1 {
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("[LoopSirvice1]");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		System.out.println("6. method6()");
		System.out.println("7. method7()");
		System.out.println("8. method8()");
		
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
		case 6: method6(); break;
		case 7: method7(); break;
		case 8: method8(); break;
		default: System.out.println("잘못된 입력");
		}
	}
	
	/**
	 * 1 ~ 10 출력
	 */
	public void method1() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * 9 ~ 1 출력
	 */
	public void method2() {
		for(int i = 9; i >= 1; i--) {
			System.out.print(i);
		}
		
		System.out.println();
		
		for(int i = 0; i < 9; i++) {
			System.out.print(9 - i);
		}
	}
	
	/**
	 * 두 정수를 입력 받아 두 정수 사이 모든 정수를 출력
	 * (무조건 첫 번째 입력이 작은 수)
	 */
	public void method3() {
		System.out.print("첫 번째 정수 입력: ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 입력: ");
		int num2 = sc.nextInt();
		
		for(int i = num1; i <= num2; i++) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 입력된 두 정수 사이의 모든 정수 출력
	 * <ul>
	 *  <li>입력1이 입력2보다 작은 경우: 증가하며 출력</li>
	 *  <li>입력1이 입력2보다 큰 경우: 감소하며 출력</li>
	 * </ul>
	 */
	public void method4() {
		System.out.print("첫 번째 정수 입력: ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 입력: ");
		int num2 = sc.nextInt();
		
		if(num1 <= num2) {
			for(int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		} else {
			for(int i = num1; i >= num2; i--) {
				System.out.print(i + " ");
			}
		}
	}
	
	/**
	 * 두 정수를 입력 받아 작은 수 부터 큰 수까지 1씩 증가하며 출력
	 */
	public void method5() {
		System.out.print("첫 번째 정수 입력: ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 입력: ");
		int num2 = sc.nextInt();
		
		if(num1 <= num2) {
			for(int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		} else {
			for(int i = num2; i <= num1; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	/**
	 * 1 ~ 100 사이 정수 중, 입력받은 정수의 배수가 몇 개인지, 배수의 합은 얼마인지 출력
	 */
	public void method6() {
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		int sum = 0;
		int count = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(i % num == 0) {
				sum += i;
				count++;
			}
		}
		
		System.out.printf("개수: %d, 합계: %d", count, sum);
	}
	
	/**
	 * 입력받은 정수에 해당하는 단(구구단) 출력
	 */
	public void method7() {
		System.out.print("구구단 단 입력: ");
		int num = sc.nextInt();
		
		for(int i = 2; i <= 9; i++) {
			System.out.printf("%2d * %d = %2d\n", num, i, (num * i)); // %2d: 2칸 확보하고 오른쪽 정렬
		}
	}
	
	/**
	 * 입력받은 두 정수 사이의 정수를 단으로 하는 구구단 전부 출력
	 */
	public void method8() {
		System.out.print("시작 단 입력: ");
		int num1 = sc.nextInt();
		
		System.out.print("종료 단 입력: ");
		int num2 = sc.nextInt();
		
		for(int i = num1; i <= num2; i++) {
			System.out.printf("\n[%d단]\n", i);
			
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, (i * j));
			}
			
			System.out.println();
		}
	}
}