package ex;

import java.util.Scanner;

/**
 * 예제 기능(메서드)을 제공하는 클래스
 */
public class OperatorEx {
	
	/**
	 * 테스트용 메서드(기능, 함수) 1
	 */
	public void test1() {
		System.out.println("test1() 호출됨");
	}
	
	/**
	 * 테스트용 메서드 2
	 */
	public void test2() {
		System.out.println("test2() 호출됨");
	}
	
	/**
	 * 입력받은 두 정수의 산술 연산 결과 출력
	 * 
	 * <pre>
	 * [실행 화면]
	 * 정수 입력 1: 10
	 * 정수 입력 2: 3
	 * 
	 * 10 + 3 = 13
	 * 10 - 3 = 7
	 * 10 * 3 = 30
	 * 10 / 3 = 3
	 * 10 % 3 = 1
	 * </pre>
	 */
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1: ");
		long num1 = sc.nextLong();
		
		System.out.print("정수 입력 2: ");
		long num2 = sc.nextLong();
		
		System.out.println();
		System.out.printf("%d + %d = %d\n", num1, num2, (num1 + num2));
		System.out.printf("%d - %d = %d\n", num1, num2, (num1 - num2));
		System.out.printf("%d * %d = %d\n", num1, num2, (num1 * num2));
		System.out.printf("%d / %d = %d\n", num1, num2, (num1 / num2));
		System.out.printf("%d %% %d = %d\n", num1, num2, (num1 % num2)); // printf() % 출력 시 %%
	}
	
	/**
	 * 입력받은 정수가 3의 배수가 맞는지 확인
	 * <pre>
	 * [실행 화면]
	 * 정수 입력: 6
	 * 6은 3의 배수가 맞습니다.
	 * 
	 * 정수 입력: 7
	 * 7은 3의 배수가 아닙니다.
	 * </pre>
	 */
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		long num = sc.nextLong();
		
		String result = (num % 3 == 0) ? "맞습니다." : "아닙니다.";
		
		System.out.printf("%d은 3의 배수가 %s", num, result);
	}
	
	/**
	 * 입력받은 나이에 따라 어린이, 청소년, 성인 구분
	 * <pre>
	 * 13세 이하 어린이
	 * 14세 이상 19세 이하 청소년
	 * 20세 이상 성인
	 * </pre>
	 */
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		
		// 삼항 연산자 중첩 사용
		String result = (age <= 13) ? "어린이" : ((age <= 19) ? "청소년" : "성인");
		
		System.out.println(result);
	}
}