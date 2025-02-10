package section02;

import java.io.IOException;

/* [throws]
 * 메서드에서 발생한 예외를 호출부로 던지는 키워드
 * 
 * [사용 이유]
 * 1. 경고의 의미
 * 		특정 메서드 호출 시 예외가 발생할 가능성을 안내
 * 2. 예외처리를 한 곳에서 처리하기 위해
 * 		try-catch가 코드 여기저기 흩어져 있는 것은 바람직하지 않음
 * 		예외를 한 곳에 모아 처리해야만 유지보수성이 향상
 */
public class ThrowsTest  {
	public void method1() throws IOException {
		method2(); // method2에서 IOException 전달되서 넘어옴
	}
	
	public void method2() throws IOException {
		method3(); // method3에서 IOException 전달되서 넘어옴
	}
	
	public void method3() throws IOException {
		throw new IOException();
	}
	
	/* [Unchecked Exception]
	 * 예외 발생 여부를 확인하지 않아도되는 예외
	 * 예외처리 구문을 작성하지 않아도되는 예외
	 * RuntimeException의 자식 예외들이 이에 속함
	 * 
	 * [Checked Exception]
	 * 예외 발생 여부를 반드시 확인해야하는 예외
	 * 예외처리 구문을 반드시 작성해야하는 예외
	 * RuntimeException의 자식 예외들을 제외한 나머지 예외
	 */
	public void test1() throws IOException{
		// Checked Exception 강제 발생
		throw new IOException(); // 컴파일 에러 발생 -> 예외처리 후 해결
	}
	
	public void test2() { // throws 구문을 작성하지 않아도 Unchecked Exception 발생 시 자동으로 호출부로 던짐
		// Unchecked Exception 강제 발생
		int num = 3 / 0; // ArithmeticException 발생
		
		throw new RuntimeException(); // 컴파일 에러 미발생
	}
}
