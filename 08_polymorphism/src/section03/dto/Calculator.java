package section03.dto;

/* [인터페이스(Interface)]
 * 객체 간의 접점을 만드는 용도로 사용
 * 1. 클래스와 객체 간의 접점을 만들 수 있음
 * 2. 극한의 추상화를 통해서 유연한 코딩 가능
 * 3. 상속받은 자식 클래스가 모두 같은 형태를 가짐
 * 
 * 대부분의 인터페이스를 상속받은 클래스는 인터페이스에서 제공하는 메서드만 오버라이딩하고 별도의 필드/메서드를 작성하지 않음
 * (개발자들 간의 규약) -> 특정 인터페이스를 통해서는 언제든지 같은 특정 형태의 클래스만 작성될 수 있도록 하기 위해
 * 
 * [인터페이스 작성법]
 * 1. 상수형 필드만 작성 가능 -> [public static final] 자료형 변수명;
 * 2. 기본적으로 모든 메서드는 추상 메서드 -> [public abstract] 반환형 메서드명();
 * 3. default 메서드 작성 가능 (오버라이딩 가능) -> default void 메서드명() {}
 * 
 * [인터페이스 사용법]
 * 1. 해당 인터페이스를 상속받을 클래스에 implements(구현하다) 키워드를 작성
 * 		-> public class 클래스명 implements 인터페이스명 {}
 * 2. 상속받은 추상 메서드를 전부 오버라이딩
 * 3. 상속받은 클래스를 객체로 만들어서 사용
 * 		-> 사용법은 추상 클래스와 동일
 * 			1. 인터페이스는 객체 생성 불가
 * 			2. 부모 타입 참조 변수로는 사용 가능
 */

/**
 * Calculator 인터페이스
 * 객체 생성 용도가 아닌 클래스/객체 간의 접점을 만드는 용도
 */
public interface Calculator {
	public static final int MAX_NUM = 1_000_000_000;
	int MIN_NUM = -1_000_000_000; // 앞부분 생략
	double PI = 3.141592;
	
	/**
	 * 두 수의 합을 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	public abstract int plus(int a, int b);
	
	/**
	 * 두 수의 차를 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int minus(int a, int b); // 앞부분 생략
	
	/**
	 * 두 수의 곱을 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int multi(int a, int b);
	
	/**
	 * 두 수를 나눈 몫을 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	double div(int a, int b);
	
	/**
	 * 두 수를 나눈 나머지를 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param b
	 * @return 결과
	 */
	int mod(int a, int b);
	
	/**
	 * a를 x만큼 거듭 제곱한 결과를 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param a
	 * @param x
	 * @return 결과
	 */
	int pow(int a, int x);
	
	/**
	 * 원의 넓이를 반환하는 메서드
	 * 단, 결과는 최대, 최소 값을 넘을 수 없음
	 * @param r
	 * @return 결과
	 */
	double areaOfCircle(double r);
	
	/**
	 * 반환한 값이 최대/최소 값을 초과하는지 확인하는 디폴트 메서드
	 * 초과 시 MAX_NUM, 미만 시 MIN_NUM 반환
	 * 범위 내 숫자는 그냥 반환
	 * @param num
	 * @return 결과
	 */
	default int checkNum(int num) {
		if(num > MAX_NUM) return MAX_NUM;
		if(num < MIN_NUM) return MIN_NUM;
		return num;
	}
}
