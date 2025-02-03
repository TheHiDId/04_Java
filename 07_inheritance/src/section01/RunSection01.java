package section01;

public class RunSection01 {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		System.out.println("Parent의 toString(): " + p1.toString());
		
		System.out.println();
		
		Child1 c1 = new Child1();
		System.out.println("Child1의 toString(): " + c1.toString());
		System.out.println("Child1만의 필드 laptop: " + c1.getLaptop());
		
		System.out.println();
		
		Child2 c2 = new Child2();
		System.out.println("Child2의 toString(): " + c2.toString());
		System.out.println("Child2만의 필드 car: " + c2.getCar());
		
		System.out.println();
		
		Child3 c3 = new Child3();
		System.out.println("Child3의 toString(): " + c3.toString());
		System.out.println("Child3만의 필드 bitcoin: " + c3.getBitcoin());
	}
}
