package section01;

/*
 * 상속: 부모의 코드를 물려받아 자식이 자신의 것처럼 사용
 * 
 * 부모의 코드 중 생성자는 상속 불가
 * 
 * 부모의 private 필드/메서드는 상속은 되지만 간접 접근이 필요
 */
public class Child1 extends Parent {
	private String laptop;
	
	public Child1() {
		System.out.println("-Child1 객체 생성됨-");
		
		setFirstName("호동");
		setAddress("서울시 강남구");
		setMoney(5000);
		laptop = "맥북 M4 Pro";
	}

	public String getLaptop() {
		return laptop;
	}

	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}
}
