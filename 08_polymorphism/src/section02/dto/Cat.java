package section02.dto;

public class Cat extends Animal {
	private String fur;
	
	public Cat() {
		super();
	}
	
	public Cat(String type, String fur) {
		super(type);
		this.fur = fur;
	}
	
	public String getFur() {
		return fur;
	}

	public void setFur(String fur) {
		this.fur = fur;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / 털색: " + fur;
	}

	@Override
	public void move() {
		System.out.println("고양이: 4족 보행, 가볍게 움직임");
	}
	
	@Override
	public void eat() {
		System.out.println("고양이: 깨작 깨작 먹음");
	}
	
	@Override
	public void sleep() {
		System.out.println("고양이: 엎드려서 잠");
	}
}
