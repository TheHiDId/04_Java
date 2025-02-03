package section02;

public class RunSection02 {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student("홍길동", 17, "종로고등학교");
		
		System.out.println(s2.toString());
	}
}