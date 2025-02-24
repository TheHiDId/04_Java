package section02;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		/* Supplier 계열
		 * 매개변수 없이 값을 제공하는 함수형 인터페이스
		 * 
		 * getXXX() 메서드를 제공 (반환값 있음)
		 */
		
		// Supplier<T>: 매개변수 없이 T 반환
		Supplier<String> nameSupplier = () -> {return "홍길동";};
		
		System.out.println("이름: " + nameSupplier.get());
		
		// IntSupplier: 매개변수 없이 정수 반환
		IntSupplier lottoNumber = () -> {
			Random random = new Random();
			
			return random.nextInt(45) + 1;
		};
		
		System.out.println("첫번째 번호: " + lottoNumber.getAsInt());
		System.out.println("두번째 번호: " + lottoNumber.getAsInt());
		System.out.println("세번째 번호: " + lottoNumber.getAsInt());
		System.out.println("네번째 번호: " + lottoNumber.getAsInt());
		System.out.println("다섯번째 번호: " + lottoNumber.getAsInt());
		System.out.println("여섯번째 번호: " + lottoNumber.getAsInt());
	}
}
