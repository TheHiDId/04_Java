package section02.dto;

/* 추상 클래스 (Abstract Class)
 * 1. 추상 메서드를 포함한 클래스
 * 2. 객체(instance)로 만들면 안되는 클래스
 * 
 * 추상 클래스는 보통 미완성 부분인 
 * 추상 메서드를 가지고 있어 객체 생성이 불가능
 * 
 * 직접 객체 생성은 불가능하지만 자식 클래스가 상속받아 
 * 부모의 추상 메서드를 오버라이딩하여 완성하면 자식 객체는 생성 가능 (오버라이딩 강제화, 동적 바인딩)
 * 
 * 추상 클래스도 생성자는 필수로 존재함
 * 상속받은 자식 객체 내부에 부모 부분이 생성되어야 하기 때문
 * 
 * 추상 클래스를 사용하는 이유
 * 1. 클래스간의 공통된 기능을 공유하면서도 일부 기능은 자식 클래스에서 강제로 구현하기 위해
 * 2. 상속, 다형성을 이용한 객체 지향 프로그래밍의 유연성을 높이기 위해
 */
public abstract class Animal {
	private String type;
	
	public Animal() {
		super();
	}
	
	public Animal(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "종류: " + type;
	}
	
	/* 추상 메서드 (Abstract Method)
	 * 공통된 기능의 이름을 가지지만 정의를 할 수 없는 메서드
	 */
	
	public abstract void move();
	
	public abstract void eat();
	
	public abstract void sleep();
}
