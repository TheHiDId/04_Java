package section04.service;

import java.util.Scanner;

import section04.exception.MyTestException;
import section04.exception.NegativeQuantityException;

public class UserDefineExceptionService {
	private Scanner sc = new Scanner(System.in);
	
	public void test1() {
		System.out.println("[두 정수를 입력받아 곱한 값 출력]");
		
		System.out.print("정수 1: ");
		int num1 = sc.nextInt();
		
		System.out.print("정수 2: ");
		int num2 = sc.nextInt();
		
		// 곱했을 때 결과가 음수면 예외 발생!
		try {
			int result = num1 * num2;
			
			if(result < 0) {
//				throw new Exception(); // 현재 상황에 맞는 예외가 없음 따라서 사용자가 예외를 직접 정의해야 함
				throw new NegativeQuantityException("음수를 곱해서 결과가 음수가 나옴");
			}
			
			System.out.println("결과: " + result);
		} catch(NegativeQuantityException e) {
			System.out.println(e.getMessage());
			
			e.printStackTrace(); // 예외가 발생한 지점까지의 메서드 호출 상황을 출력하는 메서드
		} finally {
			System.out.println("-프로그램 종료-");
		}
	}
	
	public void test2() {
		throw new MyTestException();
		// 컴파일 에러 발생: Checked Exception
		// 컴파일 에러 미발생: Unchecked Exception
	}
}
