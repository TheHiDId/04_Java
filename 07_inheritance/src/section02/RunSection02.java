package section02;

public class RunSection02 {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student("홍길동", 17, "종로고등학교");
		
		System.out.println(s2.toString());
		
		Person p3 = new Person("짱구", 5);
		System.out.println(p3);
//		print 관련 메서드 또는 문자열 + 연결 시 참조 변수명만 작성하면 자동으로 toSting() 호출
		
		Student s3 = new Student("철수", 8, "떡잎초등학교");
		System.out.println(s3);
		System.out.println(s3.introduce("모범생"));
	}
}