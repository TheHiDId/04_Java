package staticMember;

public class staticMemberRun {
	public static void main(String[] args) {
		// 아래 코드가 실행되기 전, 이미 static 멤버가 static 영역에 클래스명.필드명, 클래스명.메서드명으로 할당되어 있음
		System.out.println("Korean.nationalCode: " + Korean.nationalCode);

		Korean kor1 = new Korean("김철수", "051122-3456789");
		Korean kor2 = new Korean("신짱구", "050622-3123456");
		
		System.out.println(kor1.getKorInfo());
		System.out.println(kor2.getKorInfo());
		System.out.println();
		
		/*
		 * 만약 이미 생성된 모든 Korean 객체의 nationalCode를 수정해야 하는 경우
		 * 생성된 모든 Korean 객체에 하나하나 접근해서 값 수정을 해야하므로 static 이용해서 문제 해결
		 */
		
		// static 변수 값을 변경: 모든 Korean 객체의 nationalCode가 일괄 변경
		Korean.nationalCode = "1000";
		
		System.out.println(kor1.getKorInfo());
		System.out.println(kor2.getKorInfo());
		System.out.println();
		
		Korean kor3 = new Korean();
		Korean kor4 = new Korean();
		
		System.out.println(kor3.getKorInfo());
		System.out.println(kor4.getKorInfo());
		System.out.println();
	}
}