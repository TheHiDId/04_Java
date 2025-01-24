package staticMember;

public class Korean {
	/*
	 * 인스턴스 변수 
	 * 객체 생성 시 생성되고 객체 소멸 시 소멸
	 * 어떤 변수도 객체를 참조하지 않을 경우 Heap 메모리 영역의 GC가 메모리 반환
	 */
	private String personName;
	private String identifyNum;
	
	/*
	 * 클래스 변수
	 * 클래스명.변수명으로 접근하기 때문에 클래스 변수라고 함
	 * 프로그램 실행 시 스태틱 영역에 생성이 되고 프로그램 종료 시 소멸
	 */
	public static String nationalCode = "82"; // 명시적 초기화
	
	/*
	 * static(정적인, 고정된)
	 * 고정된 메모리 영역(static 메모리 영역)에 모든 객체가 공유할 멤버(필드/메서드)를 생성해서 공유
	 * static 멤버는 프로그램 실행 시 static 영역에 할당되고 프로그램 종료 시 사라지게 됨
	 */
	
	// 인스턴스 초기화 블럭: 인스턴스 변수 초기화 목적
	{
		System.out.println("객체 생성 시 마다 수행");
		personName = "홍길동";
		identifyNum = "900101-1234567";
		
	}
	
	// 클래스 초기화 블럭: 클래스 변수 초기화 목적
	static {
		System.out.println("프로그램 실행 시 수행");
		nationalCode = "999";
	}
	
	public Korean() {}
	
	public Korean(String personName, String identifyNum) {
		this.personName = personName;
		this.identifyNum = identifyNum;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getIdentifyNum() {
		return identifyNum;
	}
	
	public void setIdentifyNum(String identifyNum) {
		this.identifyNum = identifyNum;
	}
	
	public String getNationalCode() {
		return nationalCode;
	}
	
	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}
	
	public String getKorInfo() {
		return String.format("이름: %s / 주민등록번호: %s / 국가코드: %s", personName, identifyNum, nationalCode);
	}
}