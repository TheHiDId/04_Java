package section02.run;

import section02.dto.Animal;
import section02.dto.Cat;
import section02.dto.Snake;

public class RunAbstraction {
	public static void main(String[] args) {
		Cat c = new Cat("포유류", "단모, 파랑색");
		
		c.eat();
		c.move();
		c.sleep();
		
		System.out.println();
		
		Animal c2 = new Cat("포유류", "장모, 갈색"); // 업 캐스팅, 동적 바인딩
		
		c2.eat();
		c2.move();
		c2.sleep();
		
		System.out.println();
		
		Animal s = new Snake("물뱀");
		
		s.eat();
		s.move();
		s.sleep();
		
		System.out.println();
		
		printAnimal(new Cat("스핑크스", "털 없음"));
		printAnimal(new Snake("코브라"));
		
	}
	
	/* static: 
	 * 프로그램 실행 시 해석되어 스태틱 메모리 영역에 생성되는 키워드 
	 * -> 객체 생성 없이 클래스명.메서드명 호출 가능 
	 * 같은 클래스라도 스태틱 메서드 내에서 다른 메서드를 호출하려면
	 * 1. 현재 클래스를 이용해 객체 생성
	 * 2. 다른 메서드를 스태틱으로 지정
	 */
	public static void printAnimal(Animal animal) {
		System.out.println();
		
		System.out.println(animal.getClass().getName());
		
		animal.eat();
		animal.move();
		animal.sleep();
		
		System.out.println(animal);
	}
}
