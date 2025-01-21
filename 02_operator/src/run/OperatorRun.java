package run;

// 다른 패키지의 클래스를 가져오기 위해 import 구문 작성
import ex.OperatorEx; // OperatorEx 가져오기

/**
 * 연산자 예제 실행용 클래스
 */
public class OperatorRun {
	
	public static void main(String[] args) {
		
		OperatorEx ex = new OperatorEx(); // 가져온 클래스를 객체로 생성
		
		// ex.test1();
		// ex.test2(); // 객체가 가지고 있는 메서드 호출
		
		// ex.method1();
		// ex.method2();
		ex.method3();
	}
}