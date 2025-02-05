package section03.run;

import section03.dto.Calculator;
import section03.dto.BJYCalculator;
import section03.dto.BJYCalculator2;

public class RunCalculator {
	public static void main(String[] args) {
//		Calculator calcOfBJY = new BJYCalculator();
		Calculator calcOfBJY = new BJYCalculator2(); // 같은 인터페이스를 상속받은 다른 객체를 생성하면 쉽게 교체 가능
		
		System.out.println(calcOfBJY.plus(1234, 5678));
		System.out.println(calcOfBJY.minus(100000000, 99999999));
		System.out.println(calcOfBJY.multi(3333, 4444));
		System.out.println(calcOfBJY.div(1234, 123));
		System.out.println(calcOfBJY.mod(1234, 123));
		System.out.println(calcOfBJY.pow(2, 16));
		System.out.println(calcOfBJY.areaOfCircle(10.5));
	}
}