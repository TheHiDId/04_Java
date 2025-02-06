package section03;

public class WrapperService {
	/* [Wrapper Class]
	 * 기본 자료형을 감싸 객체 형태로 바꿀 수 있는 클래스
	 * 객체만 취급하는 상황에 대응하기 위해 기본 자료형을 객체로 변경하는 방법을 제공
	 * Boxing / Unboxing: 기본 자료형을 Wrapper Class를 이용해 변경하거나 그 반대를 뜻하는 용어
	 * 
	 * *중요*
	 * 자바에서는 박싱 언박싱을 자동으로 수행하도록 구현되어있음 (jdk11부터는 강제) -> Auto Boxing/Unboxing
	 * 
	 * Wrapper Class도 객체이기 때문에 추가적인 필드/메서드를 제공
	 */
	public void printValue(Object obj) {
		// Integer를 전달받았지만 Object로 업 캐스팅된 상태이므로 사용 시 다운 캐스팅 필요
		Integer wrap = (Integer)obj;
		
		int num = wrap.intValue();
		
		System.out.println("값 출력: " + num); // 자동으로 .toString() 호출
	}
	
	public void test1() {
		// int -> Integer Boxing
		int num1 = 100;
		
		Integer wrap1 = new Integer(num1); // The constructor Integer(int) has been deprecated since version 9 and marked for removal
		
		printValue(wrap1); // int를 Wrapper Class 객체 Integer로 변경 후 Object를 전달받는 메서드 printValue의 전달 인자로 작성
	}
	
	// Auto Unboxing
	public void printValue2(Object obj) {
		int num = (int)obj; // Object -> Integer -> int
		
		System.out.println("Auto Unboxing 후, 값 출력: " + num);
	}
	
	// Auto Boxing
	public void test2() {
		int num = 200;
		
		printValue2(num); // num을 자동으로 Integer로 Boxing
	}
	
	/* [Wrapper Class 제공 필드/메서드]
	 * 대부분의 필드/메서드가 스태틱으로 작성되어있음 -> 별도 객체 생성없이 사용가능
	 */
	
	public void test3() {
		// 정수형, 실수형 공통 필드
		System.out.println("int는 몇 바이트? " + Integer.BYTES);
		System.out.println("int는 몇 비트? " + Integer.SIZE);
		System.out.println("int 최대값: " + Integer.MAX_VALUE);
		System.out.println("int 최소값: " + Integer.MIN_VALUE);
		
		System.out.println();
		
		System.out.println("double은 몇 바이트? " + Double.BYTES);
		System.out.println("double은 몇 비트? " + Double.SIZE);
		System.out.println("double 최대값: " + Double.MAX_VALUE);
		System.out.println("double 최소값: " + Double.MIN_VALUE);
		
		System.out.println();
		
		// 실수형만 사용 가능한 필드
		System.out.println(Double.NaN); // 숫자 아님
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY);
		
		System.out.println();
		
		/* [String -> 기본 자료형으로 변환]
		 * Parsing: 구문을 분석해서 알맞은 형태로 변환
		 * 단, char는 parsing 없음! 문자 하나라는 개념은 자바와 몇 안되는 언어에만 존재
		 */
		byte b = Byte.parseByte("100");
		int i = Integer.parseInt("12345");
		long l = Long.parseLong("1234567890");
		double d = Double.parseDouble("3.1415926538");
		boolean bool = Boolean.parseBoolean("true");
		
		System.out.println(b);
		System.out.println(i);
		System.out.println(l);
		System.out.println(d);
		System.out.println(bool);
		
		System.out.println();
		
		/* [기본 자료형 -> String 변환]
		 * 1. 기본 자료형 + ""(String 리터럴) -> 이 연산으로 객체가 2개 생성되므로 메모리 효율이 나쁨
		 * 2. Wrapper Class의 valueOf() 또는 toString() 사용
		 */
		int num1 = 500;
		
//		String s1 = num1; // 자료형 불일치 오류
		String s1 = num1 + ""; // String으로 변하지만 이 연산으로 객체가 2개 생성되므로 메모리 효율이 나쁨
		
		int num2 = 700;
		
		String s2 = Integer.valueOf(num2).toString(); // int값에 필드에 세팅된 Integer 객체를 반환
		
		String s3 = Integer.toString(num2);
		
		System.out.println("s2: " + s2);
		System.out.println(s2.getClass());
		
		System.out.println("s3: " + s3);
		System.out.println(s3.getClass());
	}
}
