package ex;

public class VariableEx3 {
	public static void main(String[] args) {
		/* 강제 형변환
		 * 1. 값의 범위가 큰 자료형에서 작은 자료형으로 변환할 때
		 * 		이때 데이터 손실을 고려해야 함
		 * 2. 의도적으로 자료형을 변환하고 싶을 때
		 * 		- (double)int -> double
		 * 
		 * [작성법]
		 * (자료형)변수명/값;
		 */
		System.out.println("-강제 형변환 예제 1: 데이터 손실 1-");
		
		int num1 = 290;
		byte result1 = (byte)num1; // byte 강제 형변환
		
		System.out.println("num1: " + num1);
		System.out.println("result1: " + result1);
		
		System.out.println("-강제 형변환 예제 2: 데이터 손실 2-");
		
		double num2 = 123.999;
		int result2 = (int)num2; // 실수를 정수로 강제 형변환 -> 소수점 버림 처리
		
		System.out.println("num2: " + num2);
		System.out.println("result2: " + result2);
		
		System.out.println("-강제 형변환 예제 3: 의도적 데이터 손실 사용-");
		
		for(int i = 0; i < 5; i++) {
			int randomNumber = (int)(Math.random() * 10 + 1); // 1 ~ 10사이의 난수를 정수 형태로 반환
			System.out.println("randomNumber: " + randomNumber);
		}
		
		System.out.println("-강제 형변환 예제 4: 의도적 자료형 변환 1-");
		
		int a3 = 5;
		int b3 = 2;
		double result3 = (double)a3 / (double)b3;
		double result4 = (double)a3 / b3;
		
		System.out.println("result3: " + result3);
		System.out.println("result4: " + result4); // 자동 형변환 적용
		
		System.out.println("-강제 형변환 예제 4: 의도적 자료형 변환 2-");
		
		System.out.println("A의 유니코드 번호: " + (int)'A');
		System.out.println("A 뒤 열번째 문자: " + (char)('A' + 10));
	}
}
