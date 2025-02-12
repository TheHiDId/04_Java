package section01;

public class Main1 {
	public static void main(String[] args) {
		OuterClass1 outer = new OuterClass1();
		
		// 외부 클래스 내에 존재하는 내부 클래스 인스턴스 생성
		OuterClass1.InstanceInnerClass inner = outer.new InstanceInnerClass();
		
//		inner.display();
		outer.displayMessage();
	}
}
