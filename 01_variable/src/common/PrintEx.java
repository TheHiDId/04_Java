package common;

public class PrintEx {
	public static void main(String[] args) {
		/* System.out: 지정된 출력용 화면(기본값: 이클립스 콘솔)
		 * 1. System.out.print(출력 내용);
		 * 		출력 내용을 콘솔에 출력, 줄바꿈 없음
		 * 
		 * 2. System.out.println(출력 내용);
		 * 		출력 내용을 콘솔에 출력, 출력 후 줄바꿈
		 * 
		 * 3. System.out.printf("문자열 템플릿(패턴)", 패턴에 대입될 값/변수...);
		 * 		정해진 형식(템플릿)에 맞는 문자열을 출력, 
		 * 		문자열 템플릿 중간에 %로 시작하는 패턴을 입력하여 원하는 값/변수를 대입 가능
		 * 
		 * [패턴 종류]
		 * 1. %d(Decimal, 10진 정수): 정수를 대입
		 * 2. %c(Character, 문자): 문자를 대입
		 * 3. %s(String, 문자열): 문자열을 대입
		 * 4. %b(boolean, 논리형): 참/거짓을 대입
		 * 5. %f(float, 실수): 실수를 대입 (double 포함)
		 * 
		 * 양의 정수: 정수 크기만큼 칸 확보하고 오른쪽 정렬: %4d, 3 대입 -> OOO3 (O는 빈칸)
		 * 음의 정수: 정수 크기만큼 칸 확보하고 왼쪽 정렬: %-4d, 3 대입 -> 3OOO (O는 빈칸)
		 * 소수점: 소수점 아래 몇번 째 자리까지 표시할지 지정 (지정된 자리 아래에서 반올림 처리): %.1f, 3.15 대입 -> 3.2
		 */
		
		System.out.print("이름: "); // 줄바꿈(개행) 없음
		System.out.print("홍길동");
		System.out.print(", 나이: 20세"); // 출력 결과: 이름: 홍길동, 나이: 20세
		
		System.out.println();
		System.out.println();
		System.out.println(); // 줄바꿈 3회
		
		String name = "신짱구"; // 참조형: 값을 저장하는 것이 아닌 값의 위치인 주소를 저장
		int age = 5; // 정수 기본형, 4byte
		double height = 80.5; // 실수 기본형, 8byte
		char gender = '남'; // 문자형, 2byte
		boolean javaStudy = false; // 논리형, 1byte
		
		// 신짱구는 5세 남아로 키는 80.5cm이며, 자바 공부 여부: false
		System.out.println(name + "는 " + age + "세 " + gender + "아로 키는 " + height + "cm이며, 자바 공부 여부: " + javaStudy);
		System.out.printf("%s는 %d세 %c아로 키는 %.1fcm이며, 자바 공부 여부: %b", name, age, gender, height, javaStudy);
		
		System.out.println();
		System.out.printf("%-6s/%-6d", name, age); // 왼쪽 정렬
		
		System.out.println();
		System.out.printf("%6s/%6d", name, age); // 오른쪽 정렬
		
		// 참고: 0: 빈칸에 0 추가 (숫자만 가능)
		System.out.println();
		System.out.printf("%6s/%06d", name, age);
		
		// escape 문자: 문자열 내에서 \로 시작하는 특수 문자
		// - \n 또는 \r 또는 \r\n: 줄바꿈
		// - \t: tab
		// - \u0000: 유니코드
		// - \\: \
		// - \' 또는 \": 리터럴 아닌 기호로 출력
		System.out.println();
		System.out.print("1\t2\t3\n");
		System.out.print("\"홍길동!\"의 자료형은 String\r");
		System.out.print("\\o/\n");
	}
}