package section01;

public class Main1 {
	public static void main(String[] args) {
		// Calculator 구현체 만들어서 메서드 수행
		
		// 1. 인터페이스를 상속받은 클래스 이용
		
		// 2. 익명 내부 클래스 이용
		Calculator calc = new Calculator() {
			
			@Override
			public int sumTwoNumber(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println("calc.sumTwoNumber(10, 55): " + calc.sumTwoNumber(10, 55)); // 65
		
		// 3. 람다식 이용 () -> {}: 함수형 인터페이스의 하나 존재하는 추상 메서드를 오버라이딩한 모습
		Calculator calc2 = (a, b) -> {return a + b;};
		
		System.out.println("calc2.sumTwoNumber(60, 13): " + calc2.sumTwoNumber(60, 13)); // 73
		
		Calculator calc3 = (a, b) -> 2 * (a + b);
		
		System.out.println("calc3.sumTwoNumber(6, 7): " + calc3.sumTwoNumber(6, 7)); // 26
		
		Calculator calc4 = (a, b) -> (a * a) + (b * b * b);
		
		System.out.println("calc4.sumTwoNumber(3, 2): " + calc4.sumTwoNumber(3, 2)); // 17
	}
}
