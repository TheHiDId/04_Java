package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* [Collection Framework]
 * 자바에서 제공하는 자료구조의 모음으로 java.util 패키지에 존재
 * 
 * [특징]
 * 1. 크기 제한이 없음
 * 2. 추가/수정/삭제 등의 기능이 제공
 * 3. 객체만 저장 가능
 * 		기본 자료형은 Wrapper Class 이용해서 저장
 * 		기본적으로 타입 제한은 없지만 개발의 편의성을 위해 제네릭스를 이용해 한가지 타입으로 제한
 */
public class ListService {
	/* [List(목록)]
	 * 데이터를 순차적으로 나열한 자료구조(배열과 유사)
	 * List는 인터페이스이므로 직접 객체 생성 불가능
	 * 
	 * [특징]
	 * 1. 각 데이터를 인덱스를 이용해 구분 -> 순서가 존재
	 * 2. 인덱스로 데이터가 구분되기 때문에 중복값이 저장 가능
	 */
	public void test1() {
		/* [ArrayList]
		 * 배열처럼 생긴 List
		 */
		ArrayList list = new ArrayList(); // 제네릭을 이용한 타입 제한이 없는 객체
		
		// boolean add(E e): 리스트 객체에 요소 E 추가 후 true 반환
		list.add(new Object());
		list.add("Hello World");
		list.add(12345);
		
		// E get(int index): 리스트에서 인덱스번째 요소E 반환
		list.get(0); // Object 타입 반환
		
		Object obj = list.get(1);
		
		if(obj instanceof String) { // 타입 검증
			System.out.println(((String)obj).length()); // 다운 캐스팅
		}
	}
	
	/* [불편하게 타입 검증, 다운 캐스팅을 하는 이유]
	 * 여러 타입을 저장할 수 있다는 컬렉션의 특징이 오히려 독이 됨
	 * 따라서 제네릭스를 이용해서 타입을 제한하면 하나의 타입만 존재해 검증과 다운 캐스팅이 필요 없음
	 */
	public void test2() {
		ArrayList<String> menuList = new ArrayList<String>();
		
		// menuList.add(123); // 타입 불일치 오류 발생
		menuList.add("김치찌개");
		menuList.add("족발");
		menuList.add("보쌈");
		menuList.add("치킨");
		menuList.add("피자");
		menuList.add("떡볶이");
		menuList.add("마라탕");
		
		// int size(): 저장된 객체의 개수 반환
		for(int i = 0; i < menuList.size() ; i++) { 
			String menu = menuList.get(i); // i번째 인덱스 값 얻어오기
			// 타입 검증과 다운 캐스팅이 필요 없어짐
			
			System.out.println(menu);
		}
		
		System.out.println();
		
		for(String menu : menuList) {
			System.out.println(menu);
		} // 향상된 for문 가능
		
		System.out.println();
		
		// void add(int index, E e): 인덱스번째에 e추가(중간 삽입)
		menuList.add(1, "갈비탕");
		
		// String toString(): 리스트에 저장된 값을 하나의 문자열로 반환
		System.out.println(menuList.toString());
		
		System.out.println();
		
		/* E set(int index, E e)
		 * 인덱스번째 요소에 전달받은 e를 세팅(수정)
		 * 결과로 이전에 존재하던 요소(E)를 반환
		 */
		menuList.set(2, "불족발");
		System.out.println(menuList);
		
		System.out.println();
		
		/* boolean contains(E e)
		 * 같은 객체가 있는지 확인 (있으면 true, 없으면 false)
		 * 비교하려는 객체가 equals()를 오버라이딩 해야함
		 */
		System.out.println("보쌈: " + menuList.contains("보쌈"));
		System.out.println("막국수: " + menuList.contains("막국수"));
		
		System.out.println();
		
		/* int indexOf(E e)
		 * 같은 객체가 있는 index 번호를 반환하고 없으면 -1 반환
		 */
		System.out.println("치킨 인덱스: " + menuList.indexOf("치킨"));
		System.out.println("햄버거 인덱스: " + menuList.indexOf("햄버거"));
		
		System.out.println();
		
		/* E remove(int index)
		 * index 번째 요소 삭제하고 삭제된 요소(E) 반환
		 * 중간 요소가 삭제되면 알아서 빈 공간을 채움 (앞으로 당기기)
		 */
		System.out.println(menuList.remove(1) + " 제거");
		
		System.out.println();
		
		System.out.println(menuList);
	}
	
	/* [컬렉션 객체의 참조 변수는 부모 타입(List 인터페이스)로 설정하면 좋은 이유]
	 * 프로그래밍 과정에서 미처 생각하지 못한 비효율적인 요소를 쉽게 개선하기 위해서
	 * 
	 * 1. ArrayList
	 * 		배열처럼 요소가 붙어서 존재
	 * 		장점: 검색 속도가 비교적 빠름
	 * 		단점: 중간에 추가/수정/삭제가 비효율적
	 * 
	 * 2. LinkedList
	 * 		요소를 서로 참조하는 형식으로 연결
	 * 		장점: 중간에 추가/수정/삭제가 효율적
	 * 		단점: 검색 속도가 비교적 느림
	 */
	public void test3() {
		// 부모 타입 참조 변수 List
//		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new LinkedList<Integer>(); // 중간 부분 추가/수정/삭제가 빠른 linkedList로 교체
		
		Random random = new Random();
		
		/* currentTimeMillis()
		 * 1970년 1월 1일 09:00:00.000 (대한민국 기준)
		 * 위 시간을 기준으로 현재 시간이 지났는지 ms(1/1000초) 단위로 계산해서 반환
		 */
		long start = System.currentTimeMillis();
		
//		try {
//			Thread.sleep(1000); // 현재 쓰레드를 1초 동안 멈춤
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
		
		list.add(random.nextInt(Integer.MAX_VALUE));
		list.add(random.nextInt(Integer.MAX_VALUE));
		
		for(int i = 0; i < 500_000; i++) {
			list.add(1, random.nextInt(Integer.MAX_VALUE)); // 1번 인덱스에 난수 삽입(중간 삽입)
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("걸린 시간: " + (end - start) + "ms");
	}
}
