package section01;

public class RunHashCode {
	public static void main(String[] args) {
		/* int Object.hashCode();
		 * 객체를 식별하는 값
		 * 객체 메모리 주소를 이용해서 생성
		 * 
		 * hashCode() 오버라이딩
		 * equals() 결과가 참인 경우 hashCode() 결과도 같도록 오버라이딩 해야함 (Java 공식 문서) 
		 */
		
		Book book1 = new Book(2, "해리포터", "J.K.롤링", 8000);
		Book book2 = new Book(2, "해리포터", "J.K.롤링", 8000);
		
		System.out.println("book1.hashCode(): " + book1.hashCode()); // 전: 664740647, 후: 2049242871
		System.out.println("book2.hashCode(): " + book2.hashCode()); // 전: 321001045, 후: 2049242871
	}
}
