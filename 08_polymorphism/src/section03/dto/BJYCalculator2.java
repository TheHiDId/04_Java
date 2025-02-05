package section03.dto;

/**
 * Calculator 인터페이스 구현체
 * 모든 인터페이스 구현체는 같은 형태를 띔
 */
public class BJYCalculator2 implements Calculator {
	@Override
	public int plus(int a, int b) {
		int result = a + b;
		
		return result = checkNum(result);
	}

	@Override
	public int minus(int a, int b) {
		int result = a - b;
		
		result = checkNum(result);
		
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = a * b;
		
		result = checkNum(result);
		
		return result;
	}

	@Override
	public double div(int a, int b) {
		int result = a / b;
		
		result = checkNum(result);
		
		return result;
	}

	@Override
	public int mod(int a, int b) {
		int result = a % b;
		
		result = checkNum(result);
		
		return result;
	}

	@Override
	public int pow(int a, int x) {
		return checkNum((int)Math.pow(a, x));
	}

	@Override
	public double areaOfCircle(double r) {
		double result = PI * r * r;
		
		if(checkNum((int)result) == MAX_NUM) return MAX_NUM;
		
		if(checkNum((int)result) == MIN_NUM) return MIN_NUM;
		
		return result;
	}
}
