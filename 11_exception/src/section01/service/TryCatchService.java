package section01.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {
	/* [Exception(예외)]
	 * 코드로 해결 가능한 Error(오류)
	 * 
	 * [Exception Handling(예외 처리)]
	 * 발생된 예외를 처리하는 구문 (try-catch, throws)
	 */
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * [try-catch 작성법]
	 * <pre>
	 * try {예외가 발생할 것 같은 구문}
	 * 			예외가 발생할 가능성이 있는 코드를 시도하는 구문
	 * catch(예외 참조 변수) {}
	 * 			try에서 던져진 예외를 괄호 내 예외 참조 변수가 잡아서 처리하는 구문
	 * 			잡아서 처리하면 예외가 사라지므로 프로그램이 종료되지 않고 계속 정상수행
	 * </pre>
	 */
	
	/**
	 * 입력받은 두 정수를 나눈 몫 계산
	 */
	public void test1() {
		System.out.println("입력받은 두 정수를 나눈 몫 계산_v1");
		
		System.out.println();
		
		System.out.print("첫 번째 정수: ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수: ");
		int num2 = sc.nextInt();
		
		System.out.println();
		
		try {
			System.out.println("몫: " + num1 / num2); // ArithmeticException: / by zero: 0으로 나누면 발생하는 예외, 프로그램 비정상 종료
		} catch(ArithmeticException e) { // try에서 ArithmeticException 객체가 던져지면 매개변수 e를 이용해서 catch해서 처리하면 예외가 사라지므로 프로그램 속행
			System.out.println("0으로 나눌 수 없습니다!");
		}
		
		System.out.println();
		
		System.out.println("-프로그램 종료-");
	}
	
	public void test2() {
		System.out.println("입력받은 두 정수를 나눈 몫 계산_v2");
		
		System.out.println();
		
		try {
			System.out.print("첫 번째 정수: ");
			int num1 = sc.nextInt();
			
			System.out.print("두 번째 정수: ");
			int num2 = sc.nextInt();
			
			System.out.println();
			
			System.out.println("몫: " + num1 / num2);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다!");
		} catch(InputMismatchException e) { // catch문은 여러번 작성 가능, 위에서 부터 알맞은 캐치문을 찾아 예외처리 수행
			System.out.println("\n정수만 입력하세요!");
		}
		
		System.out.println();
		
		System.out.println("-프로그램 종료-");
	}
	
	/**
	 * 예외처리 + 다형성(업 캐스팅)
	 */
	public void test3() {
		System.out.println("입력받은 두 정수를 나눈 몫 계산_v3");
		
		System.out.println();
		
		try {
			System.out.print("첫 번째 정수: ");
			int num1 = sc.nextInt();
			
			System.out.print("두 번째 정수: ");
			int num2 = sc.nextInt();
			
			System.out.println();
			
			System.out.println("몫: " + num1 / num2);
		} catch(RuntimeException e) { // ArithmeticException과 InputMismatchException의 공통 부모 타입을 매개 변수로 선언 -> 예외 발생 시 "예외 객체 참조 주소"가 던져짐
			System.out.println("\n프로그램 실행 중 예외 발생");
		}
		
		System.out.println();
		
		System.out.println("-프로그램 종료-");
	}
	
	/**
	 * 예외처리 + 다형성(업 캐스팅) + catch 작성 순서
	 * catch문은 하위 타입부터 작성
	 * 서로 상속관계가 아닌 Exception에 대한 catch 순서는 관계 없음
	 */
	public void test4() {
		System.out.println("입력받은 두 정수를 나눈 몫 계산_v4");
		
		System.out.println();
		
		try {
			System.out.print("첫 번째 정수: ");
			int num1 = sc.nextInt();
			
			System.out.print("두 번째 정수: ");
			int num2 = sc.nextInt();
			
			System.out.println();
			
			System.out.println("몫: " + num1 / num2);
			
			int[] arr = new int[3];
			
			arr[10] = 100; // 강제 예외 발생: ArrayIndexOutOfBoundsException
		} catch(InputMismatchException e) {
			System.out.println("\n정수만 입력하세요!");
		
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다!");
			
		} catch(RuntimeException e) { // 부모 타입 예외 처리 구문을 먼저 작성하면 자식 타입의 예외까지 잡기 때문에 아래있는 자식 catch문이 절대 실행될 수 없음 (컴파일 에러 발생)
			System.out.println("\n프로그램 실행 중 예외 발생");
		}
//		  catch(InputMismatchException e) {
//			System.out.println("\n정수만 입력하세요!");
//			
//		} catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다!");
//		}
		
		System.out.println();
		
		System.out.println("-프로그램 종료-");
	}
	
	/**
	 * 캐치문에 다형성 업 캐스팅 적용 + 예외 강제 발생(예외를 만들어 던짐)
	 * 예외도 클래스이기 때문에 객체로 만들 수 있음 -> new 연산자 사용
	 * 예외 강제 발생 구문: throw new 예외클래스();
	 */
	public void test5() {
		int input = 0;
		
		do {
			System.out.println("\n-강제로 발생시켜 던질 예외 선택-\n");
			System.out.println("1. ArithmeticException");
			System.out.println("2. ArrayIndexOutofBoundsException");
			System.out.println("3. RuntimeException");
			System.out.println("4. IOException");
			System.out.println("5. Exception");
			System.out.println("0. 종료");
			
			try {
				System.out.print("\n예외 선택: ");
				input = sc.nextInt(); // InputMismatchException
				
				switch(input) {
				case 1: throw new ArithmeticException();
				case 2: throw new ArrayIndexOutOfBoundsException();
				case 3: throw new RuntimeException();
				case 4: throw new IOException();
				case 5: throw new Exception();
				}
			} catch(InputMismatchException e) {
				System.out.println("\n잘못된 입력!");
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				
				input = -1; // 잘못 입력된 경우 종료되는 것을 방지
				
			} catch(ArithmeticException e) {
				System.out.println("\nArithmeticException 처리 완료!");
				
			} catch(RuntimeException e) {
				System.out.println("\nArrayIndexOutOfBoundsException 또는 RuntimeException 처리 완료!");
				
			} catch(Exception e) {
				System.out.println("\n예외 최상위 부모 Exception으로 나머지 모든 예외 잡아서 처리 완료!");
			}
			
		} while(input != 0);
		
		System.out.println("\n-프로그램 정상 종료-");
	}
	
	/* finally{}
	 * 뜻: 마침내, 마지막으로
	 * try 구문에서 예외 발생 여부 관계없이 마지막에 무조건 실행되어야하는 코드를 작성하는 구문
	 * 중간에 프로그램이 종료되거나 메서드 리턴되어도 무조건 실행함
	 * 외부 프로그램 / 장치와의 연결을 끊어낼 때 주로 사용
	 */
	public void test6() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("1. 정상 수행 / 2. 예외 강제 발생: ");
			int input = sc.nextInt();
			
			if(input == 1) System.out.println("예외없이 정상 수행");
			else {
				System.out.println("[예외 강제 발생]");
				
				throw new Exception("강제로 던져진 예외");
			}
			
		} catch (Exception e) { // 예외 객체 참조 변수 e: 예외와 관련된 기능 제공
			System.err.println(e.getMessage()); // 예외가 던져질 때 담긴 메시지 얻어와서 에러(err)로 출력
			
			return; // 메서드를 종료하고 호출한 곳으로 돌아가라는 의미
			
		} finally {
			System.out.println("<<<프로그램 종료>>>"); // try에서 예외 발생 여부 관계없이 무조건 수행
			
			scanner.close();
		}
	}
}
