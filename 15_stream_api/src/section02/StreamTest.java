package section02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {
	public static void main(String[] args) {
		/* [Stream 최종 연산]
		 * 스트림의 요소를 소모하여 결과를 만들어내는 연산
		 */
		List<Integer> numbers = Arrays.asList(2, 7, 14, 23, 34, 52);
		
		/* [Method Chaining]
		 * 앞선 메서드의 반환값을 이용해서 다른 메서드를 호출하는 연속된 모양
		 */
		
		// void forEach(): 각 요소에 대해 지정된 작업 수행
		numbers.stream().forEach(num -> System.out.print(num + " "));
		
		System.out.println();
		System.out.println();
		
		// long count(): 스트림에 저장된 요소의 개수 반환
		long count = numbers.stream().count();
		
		System.out.println("개수: " + count);
		
		System.out.println();
		
		// java.util.Optional<T> min(), max() : 최소대값 반환
		Optional<Integer> min = numbers.stream().min((n1, n2) -> n1.compareTo(n2));
		Optional<Integer> max = numbers.stream().max((n1, n2) -> n1.compareTo(n2));
		
		System.out.printf("최소값: %d, 최대값: %d", min.get(), max.get());
		
		System.out.println();
		System.out.println();
		
		/* T reduce(초기값, (a, b) -> {})
		 * 스트림 요소를 이용해서 하나의 값을 도출하는데, 도출하려는 결과가 초기값 변수에 누적됨
		 */
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		int multiSum = numbers.stream().reduce(1, (a, b) -> a * b);
		
		System.out.println("합 누적: " + sum);
		System.out.println("곱 누적: " + multiSum);
		
		System.out.println();
		
		
		/* [Stream 중간 연산]
		 * 기존 스트림을 이용해서 새로운 스트림을 만드는 연산
		 */
		
		// filter(): 기존 스트림에서 조건에 맞는 요소만을 이용해 새로운 스트림을 생성하는 메서드
		numbers.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
		
		System.out.println();
		
		int evenSum = numbers.stream().filter(num -> num % 2 == 0).reduce(0, (a, b) -> a + b);
		
		System.out.println("짝수 합 누적: " + evenSum);
		
		System.out.println();
		
		// map() : 스트림의 모든 요소를 새로운 형태로 변환한 후 새 스트림으로 반환, 기존 스트림과 새 스트림의 요소 개수가 같음
		numbers.stream().map(num -> num * 2).forEach(num -> System.out.print(num + " "));
		
		System.out.println();
		System.out.println();
		
		// sorted(): 객체에 정의된 기본 정렬 방법(Comparable Interface 상속 필요)으로 정렬된 스트림 생성
		List<Integer> list = Arrays.asList(33, 23, 6, 31, 14);
		
		list.stream().sorted().forEach(num -> System.out.print(num + " "));; // 정렬해서 출력
	}
}
