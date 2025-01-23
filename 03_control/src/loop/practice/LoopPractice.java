package loop.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요: ");
		int inputNum = sc.nextInt();
		
		if(inputNum < 1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			return;
		}
		
		for(int i = 1; i <= inputNum; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice2() {
		System.out.print("1이상의 숫자를 입력하세요: ");
		int inputNum = sc.nextInt();
		
		if(inputNum < 1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			return;
		}
		
		for(int i = inputNum; i >= 1; i--) {
			System.out.print(i + " ");
		}
	}
	
	public void practice3() {
		System.out.print("정수를 하나 입력하세요: ");
		int inputNum = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i <= inputNum; i++) {
			if(i == inputNum) {
				sum += i;
				System.out.printf("%d = %d", i, sum);
				return;
			}
			
			System.out.printf("%d + ", i);
			sum += i;
		}
	}
	
	public void practice4() {
		System.out.print("첫 번째 숫자: ");
		int inputNum1 = sc.nextInt();
		
		System.out.print("두 번째 숫자: ");
		int inputNum2 = sc.nextInt();
		
		if(inputNum1 < 1 || inputNum2 < 1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			return;
		}
		
		if(inputNum1 > inputNum2) {
			int temp = inputNum1;
			inputNum1 = inputNum2;
			inputNum2 = temp;
		}
		
		for(int i = inputNum1; i <= inputNum2; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice5() {
		System.out.print("숫자: ");
		int inputNum = sc.nextInt();
		
		System.out.printf("\n===== %d단 =====\n", inputNum);
		for(int i = 1; i <= 9; i++) {	
			System.out.printf("%d * %d = %d\n", inputNum, i, inputNum * i);
		}
	}
	
	public void practice6() {
		System.out.print("숫자: ");
		int inputNum = sc.nextInt();
		
		if(inputNum > 9 || inputNum < 2) {
			System.out.println("2 ~ 9사이 숫자만 입력해주세요.");
			return;
		}
		
		for(int i = inputNum; i <= 9; i++) {
			System.out.printf("\n===== %d단 =====\n", i);
			
			for(int j = 2; j <= 9; j++) {	
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
		}
	}
	
	public void practice7() {
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		for(int i = 1; i <= inputNum; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void practice8() {
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		for (int i = 0; i <= (inputNum - 1); i++) {
			for(int j = 1; j <= (inputNum - i); j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void practice9() {
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		for(int i = 1; i <= inputNum; i++) {
			for(int j = (inputNum - 1); j >= i; j--) {
				System.out.print(" ");
			}
			
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void practice10() {
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		for(int i = 1; i <= inputNum; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int i = 0; i <= (inputNum - 2); i++) {
			for(int j = 1; j <= (inputNum - (i + 1)); j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void practice11() {
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		for(int i = 1; i <= inputNum; i++) {
			for(int j = (inputNum - 1); j >= i; j--) {
				System.out.print(" ");
			}
			
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			for(int j = 1; j <= i; j++) {
				if (j == 1) {continue;}
				
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public void practice12() {
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		for(int i = 1; i <= inputNum; i++) {
			if(i == 1 || i == inputNum) {
				for(int j = 1; j <= inputNum; j++) {
						System.out.print("*");
				}
			} else {
				for(int j = 1; j <= inputNum; j++) {
					if(j == 1 || j == inputNum) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			
			System.out.println();
		}
	}
	
	public void practice13() {
		System.out.print("자연수 하나를 입력하세요: ");
		int inputNum = sc.nextInt();
		
		String numbers = "";
		int count = 0;
		
		
		for(int i = 1; i <= inputNum; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				numbers += (i + " ");
			}
			
			if(i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		
		System.out.println(numbers);
		System.out.println("count: " + count);
	}
	
	public void practice14() {
		System.out.print("숫자: ");
		int inputNum = sc.nextInt();
		
		if(inputNum < 2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		for(int i = 2; i < inputNum; i++) {
			if(inputNum % i == 0) {
				System.out.println("소수가 아닙니다.");
				return;
			}
		}
		
		System.out.println("소수입니다.");
	}
	
	public void practice15() {
		System.out.print("숫자: ");
		int inputNum = sc.nextInt();
		
		while(inputNum < 2) {
			if(inputNum < 2) {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			System.out.print("숫자: ");
			inputNum = sc.nextInt();
		}
		
		for(int i = 2; i < inputNum; i++) {
			if(inputNum % i == 0) {
				System.out.println("소수가 아닙니다.");
				return;
			}
		}
		
		System.out.println("소수입니다.");
	}
	
	public void practice16() {
		System.out.print("숫자: ");
		int inputNum = sc.nextInt();
		
		if(inputNum < 2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		String primeNum = "";
		int primeCount = 0;
		
		for(int i = 2; i <= inputNum; i++) {
			boolean flag = true;
			
			for(int j = 2; j <= i; j++) {
				if(i % j == 0 && i != j) {
					flag = false;
					break;
				} 
			}
			
			if(flag) {
				primeNum += (i + " ");
				primeCount++;
			}
		}
		
		System.out.println(primeNum);
		System.out.printf("2부터 %d까지 소수의 개수는 %d개입니다.", inputNum, primeCount);
	}
}