package section04;

/* 인터페이스
 * 상속받은 클래스 간의 접점을 만듦
 * 
 * 상수형 필드(public static final)만 작성 가능
 * 추상 메서드(public abstract) 또는 default 메서드만 작성 가능
 */
public interface Animal {
	public abstract void move(); // 추상 메서드: 메서드 정의 부분이 없는 미완성 메서드
	
	void eat();
}
