package ex;

public class VariableEx2 {
	public static void main(String[] args) {
		/* 컴퓨터 값 처리 원칙
		 * 같은 자료형끼리만 연산이 가능하고 연산결과도 같은 자료형만 반환
		 * 
		 * 형변환(Type Casting)
		 * 값의 자료형을 변환하는 것
		 * 
		 * 자동 형변환(묵시적 형변환)
		 * 값의 범위가 다른 값(다른 자료형)들끼리 연산 시 
		 * 컴파일러가 자동으로 값의 범위가 작은 값을 큰 범위의 자료형으로 변환
		 */
		
		System.out.println("-자동 형변환 예시 1-");
		
		int a1 = 12;
		double b1 = 1.3;
		
		double result1 = a1 + b1;
		
		System.out.println("result1: " + result1);
		
		System.out.println("-자동 형변환 예시 2-");
		
		char ch2 = 'A'; // A는 유니코드 65번
		int num2 = 100;
		
		int result2 = ch2 + num2;
		
		System.out.println("result2: " + result2);
		
		System.out.println("-자동 형변환 예시 3-");
		
		int a3 = 3;
		int b3 = 2;
		
		int result3 = a3 / b3;
		
		System.out.println("result3: " + result3); // 값의 범위가 관계없는 자동 형변환의 예외 경우
		
		System.out.println("-자동 형변환 예시 4-"); // 자동 형변환이 안되는 경우, 강제 형변환 이용
		
		int a4 = 100;
		double b4 = 23.4;
		
		int result4 = (int)(a4 + b4); // a4 + b4 결과를 int 강제 형변환
		
		System.out.println("result4: " + result4);
	}
}