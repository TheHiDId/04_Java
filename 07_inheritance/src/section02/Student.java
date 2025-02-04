package section02;

public class Student extends Person {
	private String schoolName;
	
	/*
	 * super() 생성자
	 * super: 상위의
	 * 현재 클래스의 상위 클래스(부모) 생성자를 호출
	 * super() 생성자는 자식 생성자의 첫번째 줄에 작성되어야 함
	 * 미작성 시 컴파일러 자동 추가
	 */
	public Student() {
		super(); // 부모 기본 생성자
		System.out.println("[Student 기본 생성자로 생성됨]");
	}
	
	public Student(String name, int age, String schoolName) {
		super(name, age);
		
		System.out.println("[Student 매개 변수 포함 생성자로 생성됨]");
		
//		setName(name);
//		setAge(age);
		
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	/*
	 * super 참조 변수(부모 참조 변수)
	 * 자식 내 부모 객체를 참조하는 변수
	 * 부모의 필드, 메서드에 접근하기 위해 사용
	 */
	public String toString() {
		return super.toString() + " / schoolName: " + schoolName; // 부모의 toString() 메서드 호출
//		return String.format("name: %s / age: %d / schoolName: %s", getName(), getAge(), schoolName);
	}
	
	@Override
	public String introduce(String alias) {
		return String.format("[Student가 재정의] 내 이름은 %s, %s 입니다.", getName(), alias);
	}
}