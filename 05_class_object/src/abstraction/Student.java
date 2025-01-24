package abstraction;

public class Student {
	/*
	 * class: 객체의 멤버(필드, 메서드)를 정의한 문서
	 * 
	 * 필드 == 멤버 변수
	 */
	// private 접근 제한자: 외부의 직접 접근을 제한
	private String studentName;
	private String studentNumber;
	private int htmlScore;
	private int cssScore;
	private int jsScore;
	private int javaScore;
	
	/*
	 * 생성자
	 * 객체가 생성될 때 수행할 명령어를 작성한 특수한 메서드, 객체 생성 시 한번만 수행
	 * 
	 * [작성법]
	 * 접근제어자 클래스명() {}
	 * 반환형이 없음, 이름은 클래스명과 동일
	 */
	
	// 기본 생성자: 매개 변수가 없는 생성자, 클래스 내의 생성자가 하나도 없으면 컴파일러가 자동으로 추가
	public Student() {
		System.out.println("-Student 객체 기본 생성자로 생성-");
		System.out.println();
		
		// 객체가 Heap 영역에 생성될 때, 필드값이 모두 JVM 초기값으로 세팅이 진행 (Heap 영역은 비어있는 상태로 존재 불가)
		// 초기값 -> 정수형: 0, 실수형: 0.0, 논리형: false, 문자형: '\u0000', 참조형: null
		
		// 생성자를 이용해서 객체가 생성될 때 필드값을 원하는 값으로 초기화 할 수 있음
		studentName = "미입력";
		studentNumber = "2025XXXX";
		htmlScore = 100;
		cssScore = 100;
		jsScore = 100;
		javaScore = 100;
	}
	
	// 매개 변수가 있는 생성자
	public Student(String studentName, String studentNumber) {
		System.out.println("-Student(String, String) 생성자로 객체 생성-");
		System.out.println();
		
		// 생성되는 객체의 필드 초기화
		this.studentName = studentName;
		this.studentNumber = studentNumber;
	}
	
	public Student(String studentName, String studentNumber, int htmlScore, int cssScore, int jsScore, int javaScore) {
		System.out.println("-모든 필드를 초기화하는 생성자로 객체 생성-");
		System.out.println();
		
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.htmlScore = htmlScore;
		this.cssScore = cssScore;
		this.jsScore = jsScore;
		this.javaScore = javaScore;
	}
	
	/*
	 * 오버로딩(Overloading, 과적)
	 * 하나의 클래스 내에 같은 이름의 메서드를 여러개 작성하는 기술
	 * 같은 이름의 메서드는 원래 하나만 존재할 수 있지만 매개 변수를 다르게하여 같은 이름의 메서드라도 구분할 수 있음
	 * (순서, 타입, 개수) 
	 */
	
	// 직접 접근이 제한된 필드에 간접 접근하는 방법을 제공하는 메서드 (getter/setter)
	// getter
	public String getStudentName() {
		return studentName;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public int getHtmlScore() {
		return htmlScore;
	}
	
	public int getCssScore() {
		return cssScore;
	}
	
	public int getJsScore() {
		return jsScore;
	}
	
	public int getJavaScore() {
		return javaScore;
	}
	
	// setter
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public void setHtmlScore(int htmlScore) {
		this.htmlScore = htmlScore;
	}
	
	public void setCssScore(int cssScore) {
		this.cssScore = cssScore;
	}
	
	public void setJsScore(int jsScore) {
		this.jsScore = jsScore;
	}
	
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	
	// 총합, 평균
	public int getSumScore() {
		return htmlScore + cssScore + jsScore + javaScore;
	}
	
	public double getAvgScore() {
		return getSumScore() / 4.0;
	}
	
	// 정보 반환
	public String getGradeInfo() {
		String str = String.format("[%s] %s\nHTML: %d / CSS: %d / JS: %d / Java: %d\n총합: %d / 평균: %.2f"
				, studentNumber, studentName, htmlScore, cssScore, jsScore, javaScore, getSumScore(), getAvgScore());
		
		return str;
	}
}