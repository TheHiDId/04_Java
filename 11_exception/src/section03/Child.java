package section03;

import java.io.EOFException;
import java.io.IOException;

public class Child extends Parent {
	/* 오버라이딩 성립 조건
	 * 1. 반환형, 메서드명, 매개변수 모두 일치
	 * 2. 접근 제어자는 같거나 넓은 범위
	 * 3. 예외처리 구문(throws)의 예외 타입은 같거나 좁은 범위 + 예외 제거
	 */
	@Override
	public void method1() throws EOFException { // 부모 타입의 예외를 자식 타입의 예외로 변경 가능
		
	}
	
//	@Override
//	public void method2() throws Exception { // 부모 타입의 예외를 더 상위 타입으로 변경 불가능
//		
//	}
	
	@Override
	public void method3() { // 예외처리 구문 제거 가능 -> 재정의 시 예외 발생 가능성이 있는 코드가 제거될 수도 있기 때문
		System.out.println("예외 발생할 코드가 없음");
	}
}
