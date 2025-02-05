package section03.dto;

/*
 * 인터페이스 다중 상속 가능 이유
 * 인터페이스의 메서드는 디폴트 메서드를 제외하면 모두 추상 메서드
 * 따라서 상속받은 자식이 오버라이딩을 해야만 사용 가능
 * 미완성된 메서드는 이름이 같아도 하나만 구현하면 오류없이 사용 가능
 * 디폴트 메서드가 같은 이름이 존재하면 다중 상속 불가능
 */
public class BJYCalculator3 implements Calculator, Machine {

	@Override
	public int plus(int a, int b) {
		
		return 0;
	}

	@Override
	public int minus(int a, int b) {

		return 0;
	}

	@Override
	public int multi(int a, int b) {

		return 0;
	}

	@Override
	public double div(int a, int b) {

		return 0;
	}

	@Override
	public int mod(int a, int b) {

		return 0;
	}

	@Override
	public int pow(int a, int x) {

		return 0;
	}

	@Override
	public double areaOfCircle(double r) {

		return 0;
	}

	@Override
	public void powerOn() {
		
	}

	@Override
	public void powerOff() {
		
	}
	
}
