package ex;

public class VariableEx4 {
	public static void main(String[] args) {
		/* 상수(Constant)
		 * 한 번 값을 대입하면 바꿀 수 없는 변수
		 * 
		 * 작성법
		 * final 자료형 변수명 = 값;
		 * 단, 변수명은 대문자 + _(Underscore Case)
		 */
		
		final double PI = 3.141592;
		final int NATIONAL_CODE = 82;
		// NATIONAL_CODE = 1; -> 오류 발생: The final local variable NATIONAL_CODE cannot be assigned. It must be blank and not using a compound assignment
		
		// 자바에서 상수는 선언과 초기화 구문이 분리될 수 있음
		final int TEMP;
		TEMP = 100;
		// TEMP = 200; -> 오류 발생: The final local variable TEMP may already have been assigned
		
		System.out.println("[상수 확인]");
		
		int r = 5; // 반지름
		
		System.out.println("원의 둘레: " + (2 * PI * r));
		System.out.println("원의 넓이: " + (PI * r * r));
		System.out.println("국가 코드: " + NATIONAL_CODE);
		System.out.println("TEMP: " + TEMP);
		
		System.out.println("");
		System.out.println("오버플로우(Overflow)");
		// 오버플로우: 연산 결과가 자료형의 값의 범위를 초과(+ 방향)한 경우
		// 언더플로우: 연산 결과가 자료형의 값의 범위를 초과(- 방향)한 경우
		// 초기화 때 최대값을 초과하여 값을 부여할 수는 없음
		
		int num = Integer.MAX_VALUE; // int 최대값으로 초기화
		
		System.out.println("num: " + num);
		
		num += 1; // 오버플로우 발생
		
		System.out.println("num + 1: " + num);
		
		num -= 1; // 언더플로우 발생
		
		System.out.println("num - 1: " + num);
		
		// 문제 원인: 자료형의 범위가 사용자가 다루려는 범위보다 좁기 때문에 발생
		// 문제 해결: num의 자료형을 long으로 변경
		
		
	}
}