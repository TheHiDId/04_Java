package section02;

public class StringService {
	/* [String]
	 * java.lang 패키지에서 제공
	 * 문자열을 저장하고 관련된 기능을 제공하는 클래스
	 * 
	 * [String 불변성(Immutable)]
	 * String은 문자열을 저장하는 필드가 final로 선언되어있음 -> 따라서 한번만 값 대입이 가능하고 수정할 수 없음
	 * 저장된 문자열 수정이 불가능하기 때문에 수정하려 시도할 경우 새로운 String 객체를 생성해서 참조함
	 * ex) String s1 = "Hello"; 참조 주소: 0x100
	 * 		 s1 += " World"; 참조 주소: 0x300
	 */
	public void test1() {
		/* int System.identityHashCode(Object obj);
		 * 객체를 구분하는 해시코드 반환 -> 주소를 이용해서 만들었기 때문에 모든 객체가 다른값을 지님
		 */
		String s1 = "Hello";
		
		System.out.println("s1: " + s1);
		System.out.println(System.identityHashCode(s1));
		
		System.out.println();
		
		s1 += " World";
		
		System.out.println("s1: " + s1);
		System.out.println(System.identityHashCode(s1));
		
		System.out.println();
	}
	
	/* [String 객체 생성법]
	 * 1. String 리터럴("")을 이용하여 생성: String s1 = "Hello"; 
	 * 		-> Heap 메모리 영역에 존재하는 String Constant Pool에 String 객체 생성
	 * 2. new 연산자를 이용하여 생성: String s2 = new String("Hello"); 
	 * 		-> Heap 메모리 영역에 독립된 String 객체 생성
	 * 
	 * [String Constant Pool]
	 * String 리터럴("")을 이용해 생성된 String 객체가 저장되는 Heap 내부 영역
	 * String 리터럴을 이용해 동일한 값의 String 객체를 생성하는 경우,
	 * 새로운 객체가 생성되지 않고 기존에 같은 값을 지닌 객체의 주소가 반환됨
	 * ex) String s1 = "Hello"; 참조 주소: 0x100
	 * 		 String s2 = "Hello"; 참조 주소: 0x100 -> 다른 객체와 값이 같을 경우 같은 메모리 주소를 가지게 만들어 메모리 효율을 높여줌
	 */
	public void test2() {
		String s1 = "Hello";
		
		System.out.println("s1: " + System.identityHashCode(s1)); // 664740647
		
		String s2 = "Hello";
		
		System.out.println("s2: " + System.identityHashCode(s2)); // 664740647 -> 같은 값을 가진 서로 다른 객체가 같은 곳(String Constant Pool 내부)을 참조하게 함
		
		String s3 = new String("Hello");
		
		System.out.println("s3: " + System.identityHashCode(s3)); // 321001045 -> new 연산자를 통해 객체를 생성하면 같은 값을 가지더라도 독립된 다른 곳을 참조 함
		
		System.out.println();
		
		System.out.println("[참조 주소 비교] s1 == s2: " + (s1 == s2)); // 참
		System.out.println("[참조 주소 비교] s1 == s3: " + (s1 == s3)); // 거짓
		
		System.out.println();
		
		System.out.println("[필드값 비교] s1.equals(s2): " + s1.equals(s2)); // 참
		System.out.println("[필드값 비교] s1.equals(s3): " + s1.equals(s3)); // 참 -> String 클래스에서 오버라이딩된 equals()
	}
	
	/* [StringBuilder & StringBuffer]
	 * String의 불변성 문제를 해결한 클래스 따라서 가변성(Mutable)
	 * 기본 16글자를 저장할 수 있는 크기로 생성
	 * 저장되는 문자열의 길이에 따라서 자동으로 크기가 증가하거나 감소
	 * 문자열에 추가/수정/삭제가 발생해도 별도 String 객체의 생성이 없어서 메모리 효율이 높음
	 * StringBuilder: Thread Safe 미지원(비동기, 빠름, 안정성 비교적 낮음)
	 * StringBuffer: Thread Safe 지원(동기, 느림, 안정성 비교적 높음)
	 */
	public void test3() {
		StringBuilder sb = new StringBuilder();
		
		System.out.println("sb 크기: " + sb.capacity()); // 16
		System.out.println("sb 주소: " + System.identityHashCode(sb)); // 424058530
		
		System.out.println();
		
		// append(String str): 문자열 제일 뒤에 문자열 str 추가
		sb.append("abcde");
		sb.append("fghij");
		sb.append("klmno");
		
		// toString(): StringBuilder 객체에 저장된 값을 String 형태로 반환
		System.out.println("sb.toString(): " + sb.toString());
		System.out.println("sb 크기: " + sb.capacity()); // 16
		System.out.println("sb 주소: " + System.identityHashCode(sb)); // 424058530 -> 주소가 같으므로 가변성 확인
		
		System.out.println();
		
		// insert(int offset, String s): offset 위치에 s 삽입
		sb.insert(0, "가나다라");
		
		System.out.println("sb.toString(): " + sb.toString());
		System.out.println("sb 크기: " + sb.capacity()); // 34 -> (기존 용량 + 1) * 2 와 같이 크기 증가
		System.out.println("sb 주소: " + System.identityHashCode(sb)); // 424058530 -> 주소가 같으므로 가변성 확인
		
		System.out.println();
		
		// delete(int start, int end): start 이상 ~ end 미만 삭제
		sb.delete(0, 4);
		
		System.out.println("sb.toString(): " + sb.toString());
		System.out.println("sb 크기: " + sb.capacity()); // 34 -> 한번 늘어난 크기는 별도로 조치하지 않는 이상 줄어들지 않음
		System.out.println("sb 주소: " + System.identityHashCode(sb)); // 424058530 -> 주소가 같으므로 가변성 확인
		
		System.out.println();
		
		// trimToSize(): 버퍼 크기를 문자열 길이에 맞춤
		sb.trimToSize();
		System.out.println("sb 크기: " + sb.capacity());
		
		System.out.println();
	}
}