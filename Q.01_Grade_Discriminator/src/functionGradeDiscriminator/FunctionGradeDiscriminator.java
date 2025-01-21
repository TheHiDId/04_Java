package functionGradeDiscriminator;

import java.util.Scanner;

/**
 * 성적 판별 기능 제공 클래스
 */
public class FunctionGradeDiscriminator {
	
	Scanner sc = new Scanner(System.in);
	
	public void GradeDiscriminator() {
		System.out.print("이름 입력: ");
		String name = sc.next();
		
		System.out.print("중간고사 성적 입력: ");
		int midtermExResult = sc.nextInt();
		
		System.out.print("기말고사 성적 입력: ");
		int finalExResult = sc.nextInt();
		
		System.out.print("과제 성적 입력: ");
		int homeworkResult = sc.nextInt();
		
		double totalResult = (midtermExResult * 0.4) + (finalExResult * 0.5) + (homeworkResult * 0.1);
		
		String rating;
		
//		if(totalResult >= 95) {
//			rating = "A+";
//		} else if(totalResult >= 90) {
//			rating = "A";
//		} else if(totalResult >= 85) {
//			rating = "B+";
//		} else if(totalResult >= 80) {
//			rating = "B";
//		} else if(totalResult >= 75) {
//			rating = "C+";
//		} else if(totalResult >= 70) {
//			rating = "C";
//		} else if(totalResult >= 65) {
//			rating = "D+";
//		} else if(totalResult >= 60) {
//			rating = "D";
//		} else {
//			rating = "F";
//		}
		
		switch((int)(totalResult / 5)) {
		case 20, 19: rating = "A+"; break;
		case 18: rating = "A"; break;
		case 17: rating = "B+"; break;
		case 16: rating = "B"; break;
		case 15: rating = "C+"; break;
		case 14: rating = "C"; break;
		case 13: rating = "D+"; break;
		case 12: rating = "D"; break;
		default: rating = "F";
		}
		
		System.out.println();
		System.out.println("이름: " + name);
		System.out.println("중간고사 점수(40%): " + midtermExResult);
		System.out.println("기말고사 점수(50%): " + finalExResult);
		System.out.println("과제 점수(10%): " + homeworkResult);
		System.out.printf("\n%s의 최종 점수: %.1f점\n", name, totalResult);
		System.out.println("성적: " + rating);
	}
}