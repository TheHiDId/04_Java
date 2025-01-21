package common;

import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		/* Scanner 클래스
		 * 사용자로부터 입력을 받기위해 자바에서 제공하는 클래스
		 * java.util 패키지에 존재 -> 사용 시, import java.util.Scanner 구문을 작성해 가져와야 함
		 */
		
		Scanner sc = new Scanner(System.in); // new 연산자: Heap 메모리 영역에 새 객체 생성
		
		System.out.print("정수 입력: ");
		
		int num1 = sc.nextInt(); // 입력 버퍼에서 다음 정수 읽어오기, 정수가 아닌 다른 값이 입력되면 예외 발생
		
		System.out.println("입력받은 num1: " + num1);
		
		System.out.print("두번째 정수 입력: ");
		
		int num2 = sc.nextInt();
		
		System.out.println("입력받은 num2: " + num2);
		
		System.out.println("num1 + num2: " + (num1 + num2));
	}
}