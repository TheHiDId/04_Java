package abstraction;

public class AbstractionRun {
	public static void main(String[] args) {
		// 철수
		Student student1 = new Student();
		
		student1.setStudentName("철수");
		student1.setStudentNumber("20250001");
		student1.setHtmlScore(100);
		student1.setCssScore(70);
		student1.setJsScore(80);
		student1.setJavaScore(30);
		
		String student1Result = student1.getGradeInfo();
		
		System.out.println(student1Result);
		System.out.println();
		
		// 짱구
		Student student2 = new Student();
		
		student2.setStudentName("짱구");
		student2.setStudentNumber("20250002");
		student2.setHtmlScore(50);
		student2.setCssScore(40);
		student2.setJsScore(70);
		student2.setJavaScore(80);
		
		String student2Result = student2.getGradeInfo();
		
		System.out.println(student2Result);
		System.out.println();
		
		// 유리
		Student student3 = new Student();
		
		student3.setStudentName("유리");
		student3.setStudentNumber("20250003");
		student3.setHtmlScore(75);
		student3.setCssScore(80);
		student3.setJsScore(85);
		student3.setJavaScore(90);
		
		String student3Result = student3.getGradeInfo();
		
		System.out.println(student3Result);
		System.out.println();
	}
}