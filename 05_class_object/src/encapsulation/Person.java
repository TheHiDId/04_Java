package encapsulation;

public class Person {
	// private 접근 제어자를 이용해 필드 직접 접근 제한
//	private String name;
	private String presonName;
//	private double height;
	private double height;
	
	/**
	 * private 접근이 제한된 필드를 간접 접글할 수 있는 public 메서드
	 */
	public void setName(String name) {
		// 현재 객체의 name(this.name)에 매개 변수 name 대입
		this.presonName = name;
	}
	
	public void setHeight(double height) {
		// 검증 로직(키는 음수일 수 없음) 추가
		if(height >= 0) {
			this.height = height;
		} else {
			this.height = height * -1; // 음수 * 음수 = 양수
		}
	}
	
	/**
	 * person 객체 정보를 하나의 문자열로 반환하는 메서드
	 */
	public String getInfo() {
		return "이름: " + presonName + " / 키: " + height;
	}
}
