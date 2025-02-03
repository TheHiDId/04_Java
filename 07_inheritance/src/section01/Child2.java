package section01;

public class Child2 extends Parent {
	private String car;
	
	public Child2() {
		System.out.println("-Child2 객체 생성됨-");
		
		setFirstName("재석");
		setAddress("서울시 동대문구");
		setMoney(7000);
		car = "아반떼";
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
}
