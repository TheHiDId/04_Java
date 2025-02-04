package section01.run;

import section01.dto.Child;
import section01.dto.Parent;

/**
 * 다형성 확인 + 기초
 */
public class RunTest {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		
		// p1이 호출 가능한 메서드: Parent 메서드 + Object 상속받은 메서드
		System.out.println("p1.getLastName(): " + p1.getLastName());
		System.out.println("p1.hashCode(): " + p1.hashCode());
		
		System.out.println();
		
		Child c1 = new Child("신", 500, "붕붕이");
		
		// c1이 호출 가능한 메서드: Child + Object, Parent 상속받은 메서드
		System.out.println("c1.getCar(): " + c1.getCar());
		System.out.println("c1.getLastName(): " + c1.getLastName());
		System.out.println("c1.hashCode(): " + c1.hashCode());
		
		/*
		 * 다형성(Polymorphism)
		 * 하나의 객체가 다양한 객체 형태로 변하는 성질
		 * 
		 * 업캐스팅(Up Casting)
		 * 자식 객체의 형태를 부모 객체 형태로 변환
		 * 부모 참조 변수 = new 자식 객체; -> 자식 객체가 부모 객체 형태로 변한 것 처럼 보임
		 * 
		 * 다운캐스팅(Down Casting)
		 * 업캐스팅 상태에서 부모 참조 변수가 자식 개체를 참조할 때
		 * 참조 변수의 자료형을 자식 타입으로 강제형변환 하는 것
		 */
		
		Parent p2 = new Child("김", 9999, "아반떼");
		
		// p2가 호출 가능한 메서드: Parent, Object 메서드만 호출 가능
		// -> Child 객체이지만 Parent 객체로 변경되어 Child 메서드 인식 불가
		System.out.println("p2.getLastName(): " + p2.getLastName());
		System.out.println("p2.hashCode(): " + p2.hashCode());
		// System.out.println("p2.getCar(): " + p2.getCar()); // 오류 발생
		
		System.out.println("((Child)p2).getCar(): " + ((Child)p2).getCar()); // 다운 캐스팅
		Child c2 = (Child)p2; // 얕은 복사를 이용한 다운 캐스팅
		
		System.out.println("c2.getCar(): " + c2.getCar());
	}
}