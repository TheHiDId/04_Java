package common;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드 입력을 읽어오는 스캐너 객체를 생성해 변수에 저장
		
		System.out.println("-자기소개 문장 생성 프로그램-");
		System.out.print("이름 입력: ");
		
		String name = sc.next();
		
		System.out.print("나이 입력: ");
		
		int age = sc.nextInt();
		
		System.out.print("키 입력(cm): ");
		
		double height = sc.nextDouble();
		
		System.out.print("성별(남/여) 입력: ");
		
		char gender = sc.next().charAt(0); // String.charAt(index): String에서 index번째 문자 하나만 반환
		
		System.out.println();
		System.out.println("자기 소개");
		System.out.printf("제 이름은 %s이고 나이는 %d세, 키는 %.1fcm인 %c성입니다.", name, age, height, gender);
	}
}