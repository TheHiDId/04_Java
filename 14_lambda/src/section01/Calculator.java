package section01;

/* [함수형 인터페이스]
 * 람다식을 사용하기 위한 인터페이스로 추상 메서드 1개만 갖고 있음
 * 
 * [@FunctionalInterface]
 * 함수형 인터페이스 작성법이 맞는지 컴파일러에게 검증하라는 어노테이션
 */
@FunctionalInterface
public interface Calculator {
	/**
	 * 두 수의 합을 반환하는 메서드
	 * @param a
	 * @param b
	 * @return 
	 */
	public abstract int sumTwoNumber(int a, int b);
	
	/* 자바는 람다식을 구현하는데 왜 인터페이스를 사용했을까?
	 * 
	 * 자바는 클래스 또는 인터페이스 내부에만 메서드 선언이 가능함
	 * 여기서 인터페이스는 오로지 추상 메서드만 작성 가능하고 오버라이딩이 강제화 됨
	 * 따라서 메서드를 선언할 수 있는 클래스 중에서 인터페이스만 조건을 만족함
	 * 인터페이스는 여러 추상 메서드의 작성이 가능하기 때문에 
	 * @FunctionalInterface를 이용해서 추상 메서드를 1개만 작성했는지 검사하는 것
	 */
}
