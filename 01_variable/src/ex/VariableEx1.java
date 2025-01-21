package ex; // 현재 클래스 파일이 저장된 폴더

// 자바는 소문자, 카멜 케이스를 사용
// 단, 클래스명은 대문자로 시작

public class VariableEx1 {
	public static void main(String[] args) { // main method: 자바 프로그램을 실행시키기 위한 구문
		System.out.println("[자바 변수와 자료형]"); 
		// 변수: 메모리에 값을 저장하는 공간, 해당 공간에 저장할 수 있는 값을 바꿀 수 있음
		// 자바는 자바스크립트와 다르게 처음부터 변수에 자료형을 지정해야 함
		
		// 1byte == 8bit -> 컴퓨터가 데이터 처리(연산)를 하기 위한 최소 단위
		
		// [자바 기본 자료형 8가지]
		// 논리형: boolean (1byte) -> 참/거짓 저장
		// 정수형: byte(1byte), short(2byte), int(4byte, 정수 기본형), long(8byte, L 또는 l로 표시(리터럴)) -> 양의 정수, 음의 정수, 0 저장
		// 실수형: float(4byte, F 또는 f로 표시), double(8byte, 실수 기본형) -> 실수 저장
		// 문자형: char(2byte) -> 문자 하나를 지정하는 유니코드 저장
		
		// 변수 선언
		int num1; // 메모리에 int형 정수를 저장할 공간 4byte를 할당하고 해당 공간(변수)의 이름은 num1이라고 지정
		num1 = 0; // 자바 지역 변수는 초기화(초기값 대입)를 하지않은 경우 출력, 연산을 할 수 없음. 단, 대입 연산은 제외
		System.out.println("num1: " + num1);
		
		System.out.println("");
		System.out.println("[자료형별 리터럴 작성법]");
		
		// 논리형: boolean(1byte)
		System.out.println("");
		System.out.println("-논리형-");
		
		boolean bool1 = true;
		boolean bool2 = false;
		
		System.out.println("bool1: " + bool1);
		System.out.println("bool2: " + bool2);
		
		if(bool1 && !bool2) {
			System.out.println("이거 출력 될까?");
		}
		
		// 정수형: byte(1byte), short(2byte), int(4byte), long(8byte)
		System.out.println("");
		System.out.println("-정수형-");
		
		int intNum1 = 2147483647; // int 최대값
		long longNum1 = 2147483648L; // 일반 정수 표기법은 int로 인식하기 때문에 L표기
		long longNum2 = 30_000_000_000L; // 300억
		
		System.out.println("intNum1: " + intNum1);
		System.out.println("longNum1: " + longNum1);
		System.out.println("longNum2: " + longNum2);
		// 리터럴 표기법은 출력결과에 표시되지 않음
		
		// byte, short: 다른 언어와의 호환을 위해 남겨진 자료형 -> 별도의 리터럴 표기법이 없음
//		byte byteNum = 100;
//		short shortNum = 20000;
		
		// 실수형: float(4byte), double(8byte)
		System.out.println("");
		System.out.println("-실수형-");
		
		float floatNum = 1.123456789f; // 일반 실수 표기법은 double로 인식하기 때문이 f표기
		double doubleNum = 1.123456789;
		
		System.out.println("floatNum: " + floatNum); // 소수점 아래 8번째 자리에서 반올림
		System.out.println("doubleNum: " + doubleNum); // 소수점 아래 16번째 자리에서 반올림 -> 더 정밀한 값 표기 가능
		
		// 문자형: char(2byte) -> 리터럴 표기법: ''
		// 문자형은 실제로는 정수(유니코드)를 저장 -> 문자형이지만 정수형으로 취급
		System.out.println("");
		System.out.println("-문자형-");
		
		char ch1 = 'A'; // A를 나타내는 유니코드 65(\u0041)가 저장됨
		char ch2 = '가';
		char ch3 = '白';
		char ch4 = '★';
		
		System.out.println("ch1; " + ch1);
		System.out.println("ch2: " + ch2);
		System.out.println("ch3: " + ch3);
		System.out.println("ch4: " + ch4);
		System.out.printf("%c, %d, %x \n", ch1, (int)ch1, (int)ch1);
 
		// 문자열: String(4 또는 8byte) -> 값이 아닌 주소를 저장하는 참조 자료형(참조형), 리터럴: ""
		// String은 몇 글자가 작성될지 모르기 때문에 기본적으로 크기가 정해져있는 기본 자료형에 포함되지 않음
		// 대신 다른 곳에 문자열이 byte[] 모양으로 만들어지고 해당 배열의 주소를 참조하는 "참조형"이 됨
		String str1 = "A";
		String str2 = "AB";
//		String str3 = "ABC";
//		String str4 = "ABCD";
		
		System.out.println("str1: " + str1);
		System.out.println(System.identityHashCode(str1)); // hashCode: 주소와 유사한 것 -> 주소가 다르면 같은 결과가 나올 수 없음
		
		System.out.println("str2: " + str2);
		System.out.println(System.identityHashCode(str2));
	}
}