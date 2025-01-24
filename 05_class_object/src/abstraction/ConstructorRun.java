package abstraction;

public class ConstructorRun {
	public static void main(String[] args) {
		// 기본 성생자로 객체를 생성
		Student std1 = new Student();
		
		System.out.println(std1.getGradeInfo());
		System.out.println();
		
		// Student(String, String) 매개 변수가 있는 생성자 이용
		Student std2 = new Student("맹구", "20250004");
		
		System.out.println(std2.getGradeInfo());
		System.out.println();
		
		// 모든 필드를 초기화하는 생성자로 객체 생성
		Student std3 = new Student("훈이", "20250005", 60, 80, 40, 95);
		
		System.out.println(std3.getGradeInfo());
		System.out.println();
		
		Student std4 = new Student("수지", "20250006", 100, 100, 90, 95);
		
		System.out.println(std4.getGradeInfo());
		System.out.println();
	}
}