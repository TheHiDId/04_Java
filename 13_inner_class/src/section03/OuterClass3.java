package section03;

public class OuterClass3 {
	private String instaceMessage = "Hello"; // 외부 클래스의 인스턴스 변수
	
	public void outerDisplay() {
		String localMessage = " World!"; // 외부 클래스의 멤버 메서드에 선언된 지역 변수
		
		// 지역 내부 클래스 정의
		class LocalInnerClass { // 접근 제어자를 작성하지 않은 상태 == default
			public void innerDisplay() {
				System.out.println(instaceMessage + localMessage);
			}
		}
		
		// 지역 내부 클래스를 이용해 객체 생성
		LocalInnerClass inner = new LocalInnerClass();
		
		inner.innerDisplay();
	}
	
	// 다른 메서드에서는 지역 내부 클래스 호출 불가
	public void method() {
//		LocalInnerClass inner = new LocalInnerClass(); // 오류 발생
	}
}
