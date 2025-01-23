package encapsulation;

public class EncapsulationRun {
	public static void main(String[] args) {
		Person person1 = new Person();
		
//		person1.name = "홍길동";
//		person1.height = 195.5;
		person1.setName("홍길동");
		person1.setHeight(195.5);
		
		Person person2 = new Person();
		
//		person2.name = "김미영";
//		person2.height = -160.7; // 미 캡슐화의 문제점 1: 잘못된 데이터 대입
		person2.setName("김미영");
		person2.setHeight(-160.7);
		
		System.out.println("person1 " + person1.getInfo());
		System.out.println("person2 " + person2.getInfo());
	}
}