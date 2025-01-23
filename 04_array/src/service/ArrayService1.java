package service;

import java.util.Scanner;

/*
 * [배열]
 * 같은 자료형의 변수를 하나의 묶음으로 다루는 것
 * 생성 시 Heap 메모리 영역에 할당
 * 주소를 참조해서 배열 요소 접근 가능
 */

public class ArrayService1 {
	Scanner sc = new Scanner(System.in);
	/**
	 * 자바 배열 선언, 할당, 초기화 하는 방법
	 */
	public void method1() {
		// 배열 선언
		int[] arr; // int arr[];
		// int[] 자료형을 저장하기 위한 공간(변수)을 메모리에 할당하고 해당 공간의 이름을 arr이라고 지정
		
		// 배열 할당
		arr = new int[4]; // Heap 메모리 영역에 생성된 int 4칸 짜리 배열의 시작 주소를 arr 참조형 변수에 대입
		// new: Heap 메모리 영역에 객체/배열을 생성(할당)하는 연산자, 생성 완료 후 생성된 객체/배열의 시작 주소를 반환
		// int[4]: int형 변수 4개가 묶인 배열 할당, Heap 메모리 영역은 빈칸으로 존재할 수 없음 따라서 JVM이 자료형 별 기본값으로 초기화 함
		
		// 배열 요소 접근
		// 1. JVM이 기본값으로 초기화 했는지 확인
		System.out.println("arr[0]: " + arr[0]);
		System.out.println("arr[1]: " + arr[1]);
		System.out.println("arr[2]: " + arr[2]);
		System.out.println("arr[3]: " + arr[3]);
		
		// 배열 모든 요소에 값 대입
		// 1. 각각 접근
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		
		// 확인
		System.out.println("arr[0]: " + arr[0]);
		System.out.println("arr[1]: " + arr[1]);
		System.out.println("arr[2]: " + arr[2]);
		System.out.println("arr[3]: " + arr[3]);
		
		// 2. for 이용
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 100;
		}
		
		// 확인
		System.out.println("arr[0]: " + arr[0]);
		System.out.println("arr[1]: " + arr[1]);
		System.out.println("arr[2]: " + arr[2]);
		System.out.println("arr[3]: " + arr[3]);
	}
	
	/**
	 * 선언과 동시에 할당/초기화
	 */
	public void method2() {
		int[] arr = {10, 20, 30}; // 값 대입 시 {} 사용!
		
		// 자바의 향상된 for
		for(int num : arr) {
			System.out.println(num);
		}
	}
	
	/**
	 * 점심 메뉴 뽑기
	 */
	public void method3() {
		String[] menus = {"순대국", "닭갈비", "마라탕", "햄버거", "짜장면", "짬뽕", "포케"};
		
		int randomNum = (int)(Math.random() * menus.length);
		
		System.out.println("오늘의 점심 메뉴: " + menus[randomNum]);
	}
	
	/**
	 * 자바 배열 사용 시 주의 점
	 */
	public void method4() {
		System.out.println("[입력 받은 정수를 각 배열 요소에 저장, 출력]");
		
		long[] arr = new long[3];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] 값 입력: ", i);
			arr[i] = sc.nextLong();
		}
		
		// 향상된 for
		for(long num : arr) {
			System.out.println(num);
		}
		
		// 배열 길이 이상의 index에 접근하는 경우
		// arr이 참조하는 배열에 존재하는 index: 0, 1, 2
		// 이 때 존재하지 않는 3번 인덱스에 값 대입
		
		System.out.print("arr[3]에 대입할 값: ");
		long input = sc.nextLong();
		
		arr[3] = input;
		// ArrayIndexOutOfBoundsException: 배열 범위 초과 예외
		// 자바 배열은 존재하지 않는 인덱스에 접근 불가
		// 처음 배열이 할당될 때의 크기로 고정 (줄어들지도 않음)
		
		System.out.println("확인 : " + arr[3]);
	}
	
	
	/**
	 * 인원 수를 입력받아 해당하는 크기를 가지는 정수 배열을 선언하고
	 * 각 배열 요소에 점수를 입력받아 저장. 입력이 완료되면 합계, 평균, 최대값, 최소값 출력
	 */
	public void method5() {
		System.out.print("인원 수 입력: ");
		int size = sc.nextInt();
		
		int[] scoreArr = new int[size]; // 입력받은 정수 만큼의 길이를 가지는 배열을 선언, 할당
		
		int sum = 0;
		
		for(int i = 0; i < scoreArr.length; i++) {
			System.out.printf("%d번째 인덱스 점수 입력: ", i);
			scoreArr[i] = sc.nextInt();
			
			sum += scoreArr[i]; // 합계 누적
		}
		
		System.out.println("합계: " + sum);
		System.out.println("평균: " + (double)sum / size);
		
		// 최대값/최소값이 기록된 인덱스 찾기
		int maxIndex = 0;
		int minIndex = 0; // 일단 첫번째 인덱스가 최고이자 최소임을 기록
		
		for(int i = 1; i < scoreArr.length; i++) {
			// 최대값 찾기
			if(scoreArr[i] > scoreArr[maxIndex]) {
				maxIndex = i; // 현재 인덱스 i를 maxIndex에 대입
			}
			
			// 최소값 찾기
			if(scoreArr[i] < scoreArr[minIndex]) {
				minIndex = i; // 현재 인덱스 i를 minIndex에 대입
			}
		}
		
		System.out.println("최대값: " + scoreArr[maxIndex]);
		System.out.println("최소값: " + scoreArr[minIndex]);
	}
}