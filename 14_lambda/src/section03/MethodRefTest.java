package section03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefTest {
	/* [메서드 참조]
	 * 이미 존재하는 메서드를 람다식으로 표현할 때 사용하는 축약된 표시 방식
	 * 새로운 람다식을 작성하는 것이 아니라 이미 구현된 같은 기능의 메서드를 참조하는 것
	 */
	public static void main(String[] args) {
		// 문자열 길이 반환
		String str = "Hello, World!";
		String str2 = "Show Me The Money!";
		
		// 1. 람다식 작성 방식
		Function<String, Integer> strLength = (s) -> {return s.length();};
		
		System.out.printf("%s의 길이 %d\n", str, strLength.apply(str));
		
		// 2. 메서드 참조 방식
		Function<String, Integer> strLength2 = String::length; // String을 매개변수로 전달하면 String.length() 메서드를 참조해서 실행 후 Integer값을 반환
		
		System.out.printf("%s의 길이 %d\n", str2, strLength2.apply(str2));
		
		System.out.println();
		
		List<String> nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("유리");
		nameList.add("훈이");
		nameList.add("맹구");
		nameList.add("철수");
		
//		Consumer<String> printName = (name) -> System.out.println(name);
		
		// 모든 요소를 반복하면서 출력
		nameList.forEach((name) -> System.out.println(name));
		
		System.out.println();
		
		// 메서드 참조
		// -> nameList에서 하나씩 꺼낸 값을 System.out.println()에 전달하여 실행
		nameList.forEach(System.out::println);
		
		System.out.println();
		
		// 절대값을 반환하는 람다식 작성
		Function<Integer, Integer> abs1 = (num) -> {
			if(num < 0) return num * -1;
			return num;
		};
		
		Function<Integer, Integer> abs2 = Math::abs; // 이미 똑같은 메서드가 존재하면 또 작성하지 말고 참조하는 방식 -> 메서드 참조
		
		System.out.println("-6의 절대값: " + abs1.apply(-6));
		System.out.println("-100의 절대값: " + abs2.apply(-100));
	}
}
