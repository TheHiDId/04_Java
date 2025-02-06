package generics;

import java.util.List;

public class RunGenerics {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		
		box1.setValue("String만 전달 가능");
		System.out.println(box1.getValue());
		
		Box<Integer> box2 = new Box<Integer>();
		
		box2.setValue(1234); // int -> Integer (Auto Boxing)
		System.out.println(box2.getValue());
		
		System.out.println();
		
		// [제네릭스를 이용한 구체적인 타입 제한]
		TextBox<Parent> t1 = new TextBox<Parent>();
		t1.setObj(new Parent());
		System.out.println(t1.getObj().getClass());
		
		TextBox<Child> t2 = new TextBox<Child>();
		t2.setObj(new Child());
		System.out.println(t2.getObj().getClass());
	}
	
	/* 와일드카드 <?>
	 * 제네릭 클래스의 타입 처리를 유연하게 대처해주는 문법
	 * <?>: ?에 어떤 타입이든 가능
	 * <? extends T>: T를 상속받은 ?만 가능(후손)
	 * <? super T>: ?는 T의 조상이어야만 가능
	 */
	public void test1(List<? extends Parent> list) {}
}
