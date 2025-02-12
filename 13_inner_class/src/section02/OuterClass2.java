package section02;

public class OuterClass2 {
	private int outerInstanceNum = 100; // 인스턴스 변수
	private static int outerStaticNum = 20; // 클래스 변수
	
	// 정적 내부 클래스 정의
	public static class StaticInnerClass {
		public int innerInstanceNum = 300; // 내부 클래스의 인스턴스 변수
		public static int innerStaticNum = 50; // 내부 클래스의 클래스 변수
		
		public void display() {
			System.out.println("[내부 클래스 display() 메서드]");
//			System.out.println("outerInstanceNum: " + outerInstanceNum); // Cannot make a static reference to the non-static field outerInstanceNum
			System.out.println("outerStaticNum: " + outerStaticNum); // 스태틱 멤버끼리는 호출하는데에 문제 없음
			System.out.println("innerInstanceNum: " + innerInstanceNum); // 정적 내부 클래스라도 내부의 non-static 멤버끼리는 호출 가능
			System.out.println("innerStaticNum: " + innerStaticNum); // non-static에서 static 호출 가능
		}
		
		public static void staticDisplay() {
			System.out.println("[내부 클래스 staticDisplay() 메서드]");
//			System.out.println("outerInstanceNum: " + outerInstanceNum); // 오류 발생
			System.out.println("outerStaticNum: " + outerStaticNum); // 외부 클래스의 클래스 변수는 정적 내부 클래스의 정적 메서드에서도 호출 가능
//			System.out.println("innerInstanceNum: " + innerInstanceNum); // 오류 발생
			System.out.println("innerStaticNum: " + innerStaticNum);
		}
	}
}
