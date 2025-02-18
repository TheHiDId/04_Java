package section01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application02 {
	public static void main(String[] args) {
		// 1. 배열 -> 스트림
		String[] names = {"짱구", "철수", "유리"};
		
		Stream<String> nameStream = Arrays.stream(names);
		
		nameStream.forEach(System.out::println);
//	nameStream.forEach(System.out::println); // Stream은 일회용이므로 두번 사용 불가능
		
		System.out.println();
		
		// 2. 컬렉션 -> 스트림
		List<String> animals = Arrays.asList("Dog", "Cat", "Pig"); // 고정된 길이의 List 생성 및 요소 추가 방법
		
		Stream<String> animalStream = animals.stream();
		
		animalStream.filter(animal -> animal.endsWith("g")).forEach(System.out::println); // g로 끝나는 동물만 필터링
		
		System.out.println();
		
		// 3. Stream 객체 생성
		IntStream intStream1 = IntStream.range(3, 7); // 3이상 7미만
		IntStream intStream2 = IntStream.rangeClosed(3, 7); // 3이상 7이하
		
		intStream1.forEach(System.out::print);
		
		System.out.println();
		
		intStream2.forEach(System.out::print);
		
		System.out.println();
		System.out.println();
		
		LongStream longStream = LongStream.rangeClosed(1, 9);
		
		longStream.forEach(System.out::print);
		
		System.out.println();
		System.out.println();
		
		DoubleStream doubleStream = DoubleStream.of(3.14, 4.5, 11.7);
		
		double sum = doubleStream.reduce(0, (a, b) -> a + b); // 내부 요소를 누적하는 메서드
		
		System.out.println("합계: " + sum);
		
		System.out.println();
		
		Stream<String> fruitsStream = Stream.of("사과", "딸기", "바나나");
		
		fruitsStream.forEach(System.out::println);
	}
}
