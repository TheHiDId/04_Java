package service;

import java.util.Random;

import dto.StudentDTO;

public class StudentService {
	// 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5]; 
	/*
	 * new StudentDTO[5]: 참조형 변수 5칸짜리 배열 생성
	 * 인덱스 0 ~ 4, 각 인덱스 요소의 초기값: null (참조 객체 없음)
	 */
	
	// 기본 생성자
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨...]");
		
		students[0] = new StudentDTO("20250001", "짱구", '남');
		students[1] = new StudentDTO("20250002", "철수", '남');
		students[2] = new StudentDTO("20250003", "유리", '여');
		
		Random random = new Random();
		
		for(StudentDTO std : students) {
			
			if(std == null) {
				continue;
			}
			
			// random.nextInt(101) : 0 이상 101 미만의 정수형 난수 생성
			std.setHtmlScore( random.nextInt(101) );
			std.setCssScore( random.nextInt(101) );
			std.setJsScore( random.nextInt(101) );
			std.setJavaScore( random.nextInt(101) );
			
		}
	}
	
	
	
	/**
	 * students 객체 배열을 반환하는 메서드
	 * 저장된 주소가 복사되서 반환 == 얕은 복사
	 */
	public StudentDTO[] getStudentInfo() {
		return students;
	}
}