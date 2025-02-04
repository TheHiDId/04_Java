package section01.dto;

public class Parent {
	private String lastName = "제갈";
	private int money = 10000;
	
	public Parent() {
		super(); // -> Object() 기본 생성자 호출
	}

	public Parent(String lastName, int money) {
		super();
		this.lastName = lastName;
		this.money = money;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Parent [lastName=" + lastName + ", money=" + money + "]";
	}
}