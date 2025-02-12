package section02;

import java.time.LocalDate;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjLongConsumer;

public class ConsumerTest {
	public static void main(String[] args) {
		/* Consumer 계열
		 * 매개변수를 받아서 소비하는 함수형 인터페이스
		 * 매개변수가 소비되기 때문에 반환값이 없음
		 * 
		 * accept() 메서드 제공 (반환값 없음)
		 */
		
		// Consumer<T>: 매개변수 T를 전달받아 소비
		Consumer<String> printString = (message) -> {System.out.println("전달받은 message: " + message);};
//		Consumer<String> printString = System.out::println; // 메서드 참조
		
		printString.accept("쉬는 시간입니다");
		
		// BiConsumer<T, U>: 매개변수 T, U를 전달받아 소비
		BiConsumer<String, Integer> printNameAge = (name, age) -> {System.out.println(name + " / " + age);};
		
		printNameAge.accept("짱구", 5);
		
		// ObjLongConsumer<T> : T와 long을 전달받아 소비
		ObjLongConsumer<LocalDate> objLongConsumer = (date, days) -> {System.out.printf("%s일 %d일 후의 날짜는 %s\n", date , days, date.plusDays(days));};
		
		objLongConsumer.accept(LocalDate.now(), 5);
		
		/* LocalDate
		 * 자바에서 시간(날짜)을 저장하는 객체
		 * 예전에는 Date, Calendar 등을 이용했지만 다 deprcated 되어 LocalDate를 사용함
		 * 
		 * LocalDate.now(): 현재 시간을 저장한 LocalDate 객체 반환
		 * LocalDate.plusDays(long l): 현재 날짜에 날짜를 더하여 반환
		 */
	}
}
