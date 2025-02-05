package section01;

import java.util.Random;

public class RunEquals {
	public static void main(String[] args) {
		Book book1 = new Book(1, "어린 왕자", "생택쥐베리", 10000);
		Book book2 = new Book(1, "어린 왕자", "생택쥐베리", 10000);
		Book book3 = book1; // 얕은 복사
		
		System.out.println("book1 == book1: " + (book1 == book1));
		System.out.println("book1 == book2: " + (book1 == book2));
		System.out.println("book1 == book3: " + (book1 == book3)); // == 은 저장된 주소를 비교하므로 참
		
		System.out.println();
		
		// 오버라이딩 전: 주소를 비교하므로 거짓
		// 오버라이딩 후: 필드값을 비교하므로 참
		System.out.println("book1.equals(book2): " + book1.equals(book2)); 
		
		// equals() 오버라이딩에 추가할 내용
		// 1. 같은 객체를 참조하는데 비교하는 경우
		Book book4 = book1;
		System.out.println(book4.equals(book1));
		
		// 2. 전달되는 인자가 null인 경우
		Book book5 = null;
		System.out.println(book1.equals(book5));
		
		// 3. 비교대상이 같은 타입의 객체인지 확인
		Random random = new Random();
		System.out.println(book1.equals(random));
	}
}
