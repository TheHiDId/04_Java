package basic;

public class BasicRun {
	public static void main(String[] args) {
		// Car 객체 생성
		// Car 클래스에 작성된 내용을 토대로 Heap 메모리 영역에 생성
		Car myCar = new Car();
		
		myCar.start();
		myCar.stop();
		
		// myCar가 참조하는 Car 객체 필드에 값을 대입
		myCar.brand = "현대";
		myCar.model = "소나타";
		myCar.year = 2025;
		
		// myCar가 참조하는 Car 객체의 필드값 얻어오기
		System.out.println("myCar brand: " + myCar.brand);
		System.out.println("myCar model: " + myCar.model);
		System.out.println("myCar yaer: " + myCar.year);
		
		// Car 클래스 재사용
		Car myCar2 = new Car();
		
		myCar2.brand = "테슬라";
		myCar2.model = "모델 Y";
		myCar2.year = 2024;
		
		System.out.printf("저의 자동차는 %s %s이고 %d년식 입니다.", myCar2.brand, myCar2.model, myCar2.year);
		
		myCar2.start();
		
		System.out.println("안녕히계세요 여러분~");
	}
}