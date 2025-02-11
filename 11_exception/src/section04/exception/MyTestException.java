package section04.exception;

/* [사용자 정의 예외를 만드는 방법]
 * 예외 관련 클래스를 아무거나 상속받아야 함
 * 
 * [Checked / Unchecked Exception 만들기]
 * Checked : Checked Exception 클래스 상속
 * Unchecked : Unchecked Exception 클래스 상속 -> Runtime Exception 포함 자식 예외들
 */
public class MyTestException 
// extends Exception { // Checked Exception 생성
extends RuntimeException { // Unchecked Exception 생성
	
}
