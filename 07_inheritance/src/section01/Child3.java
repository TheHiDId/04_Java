package section01;

public class Child3 extends Parent {
	private double bitcoin;
	
	public Child3() {
		System.out.println("-Child3 객체 생성됨-");
		
		setFirstName("동엽");
		setAddress("서울시 은평구");
		setMoney(9000);
		bitcoin = 0.1;
	}

	public double getBitcoin() {
		return bitcoin;
	}

	public void setBitcoin(double bitcoin) {
		this.bitcoin = bitcoin;
	}
}
