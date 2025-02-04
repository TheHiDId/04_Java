package section02;
/*
 * Object 클래스
 * 모든 클래스(객체)의 최상위 부모
 * 모든 클래스가 공통적으로 가져야하는 기능이 모여있음
 * 클래스 선언부에 아무런 상속 구문이 
 * 작성되지 않으면 자동으로 extends Object 추가
 */

/*
 * final 클래스, 메서드
 * 클래스: 상속 불가 -> 다른 클래스가 필드/메서드를 상속받아 사용하지 못하게 함
 * 메서드: 오버라이딩 불가 -> 이미 완벽한 기능 또는 바꾸면 문제가 생기는 경우 기능 재정의 방지
 */

public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("[Person 기본 생성자로 생성됨]");
	}

	public Person(String name, int age) {
		System.out.println("[Person 매개 변수 포함 생성자로 생성됨]");
		
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * Object.toString() 메서드
	 * 객체를 사람이 읽기 쉬운 간단한 문자열 형태로 반환하는 목적의 메서드
	 * 모든 자식 클래스에서 재정의해서 사용
	 * 
	 * [오버라이딩 성립 조건]
	 * 1. 변경 불가
	 * 	- 메서드명, 반환형, 매개변수의 타입과 개수와 순서
	 * 
	 * 2. 변경 가능
	 * 	- 접근제어자(같거나 넓은 범위), 예외처리(같거나 좁은 범위)
	 * 
	 * -주의사항-
	 * 부모의 private 메서드는 오버라이딩 불가(직접 접근이 차단되어 있음)
	 * 
	 * @Override (어노테이션, Annotation, 컴파일러를 위한 주석)
	 *  - 코드의 추가적인 정보제공 목적, 컴파일러에게 지시하는 목적
	 *  - 해당 메서드가 오버라이딩 되었음을 명시
	 *  - 컴파일러에게 해당 메서드 오버라이딩이 문제없이 작성되었는지 확인하라 지시
	 *  	(성립조건 위배 관련)
	 */
	@Override
	public String toString() {
		return String.format("name: %s / age: %d", name, age);
	}
	
	public String introduce(String alias) {
		return String.format("[Person] 이름은 %s, 별명은 %s 입니다.", name, alias);
	}
}