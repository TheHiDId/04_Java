package service;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayService2 {
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 얕은 복사와 깊은 복사 확인
	 */
	public void method1() {
		int [] arr1 = {10, 20, 30, 40, 50};
		int [] copyArr1 = arr1; // arr1에 저장된 주소를 copyArr1에 대입, 얕은 복사
		
		System.out.println("[변경 전]");
		System.out.println("arr1: " + Arrays.toString(arr1));
		System.out.println("copyArr1: " + Arrays.toString(copyArr1)); // 배열에 저장된 모든 값을 하나의 문자열로 반환
		
		// copyArr1을 이용해서 값 수정
		copyArr1[0] = 999;
		
		System.out.println("[변경 후]");
		System.out.println("arr1: " + Arrays.toString(arr1));
		System.out.println("copyArr1: " + Arrays.toString(copyArr1));
		
		// 해시코드(): 주소를 이용해서 만든 해시함수 결과 값
		System.out.println(arr1.hashCode());
		System.out.println(copyArr1.hashCode());
		
		System.out.println();
		
		// 깊은 복사
		int[] arr2 =  {5, 6, 7, 8}; 
		int[] copyArr2 =  new int[arr2.length];
		
		for(int i = 0; i < arr2.length; i++) {
			copyArr2[i] = arr2[i];
		}
		
		System.out.println("[변경 전]");
		System.out.println("arr2: " + Arrays.toString(arr2));
		System.out.println("copyArr2: " + Arrays.toString(copyArr2));
		
		copyArr2[0] = 1234;
		
		System.out.println("[변경 후]");
		System.out.println("arr2: " + Arrays.toString(arr2));
		System.out.println("copyArr2: " + Arrays.toString(copyArr2)); // 원본 상태 유지
		
		System.out.println(arr2.hashCode());
		System.out.println(copyArr2.hashCode()); // 서로 다름
		
		System.out.println();
		
		// 깊은 복사 다른 방법
		// System.arraycopy(A, B, C, D, E)
		// A: 원본 배열명
		// B: 원본 배열에서 복사를 시작할 인덱스
		// C: 복사된 배열 요소값이 저장될 배열명
		// D: 복사하려는 배열에 값을 저장하기 시작할 인덱스
		// E: 원본 배열에서 복사할 요소 개수(길이)
		
		int[] copyArr3 =  new int[arr2.length];
		
		System.arraycopy(arr2, 0, copyArr3, 0, arr2.length);
		
		System.out.println("[변경 전]");
		System.out.println("arr2: " + Arrays.toString(arr2));
		System.out.println("copyArr3: " + Arrays.toString(copyArr3));
		
		copyArr3[0] = 2222;
		
		System.out.println("[변경 후]");
		System.out.println("arr2: " + Arrays.toString(arr2));
		System.out.println("copyArr3: " + Arrays.toString(copyArr3)); // 원본 상태 유지
	}
	
	/**
	 * 2차원 배열 선언, 할당, 초기화
	 */
	public void method2() {
		// 자바에서 배열 기호 []는 하나당 1차원을 의미
		// [][] => 2차원
		// [][][] => 3차원
		
		// 2차원 배열: 같은 자료형 1차원 배열 참조 변수 묶음
		int[][] arr = new int[2][3];
		
		// 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		// 확인
		System.out.println("arr[0]: " + arr[0]); // int[] 참조 주소
		System.out.println("arr[0]: " + arr[1]); // int[] 참조 주소
		
		System.out.println();
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 2차원 배열 선언 및 초기화
	 */
	public void method3() {
		int[] arr1 = {30, 40, 50, 60};
		int[] arr2 = {15, 25, 35, 45};
		
		// 2차원 배열 선언 및 초기화
		int[][] arr = {arr1, arr2, {99, 88, 77, 66}}; // 3행 4열 2차원 배열
		
		System.out.print("검색할 숫자 입력: ");
		int input = sc.nextInt();
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				if(arr[row][col] == input) {
					System.out.printf("%d행 %d열에 있습니다.\n", row, col);
					
					return;
				}
			}
		}
		
		System.out.println("존재하지 않습니다.");
	}
}