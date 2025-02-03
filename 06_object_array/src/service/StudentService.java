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
	
	/**
	 * <pre>
	 * students 객체 배열 요소 중
	 * 비어있는(null) 인덱스를 찾아
	 * 전달받은 studentDTO 객체를 추가하고 true 반환
	 * 단, 비어있는 인덱스가 없으면 false 반환
	 * </pre>
	 * @param student: 추가하려는 학생 객체 주소
	 * @return 추가 성공 시 ture, 실패 시 false
	 */
	public boolean addStudent(StudentDTO student) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 인덱스 번째 학생 반환 서비스 메서드
	 * @param index
	 * @return 인덱스 번째 학생 객체 참조 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		if(index < 0 || index >= students.length) {
			return null;
		}
		
		return students[index];
	}
	
	/**
	 * studentName과 이름이 일치하는 학생 객체 반환 메서드
	 * @param studentName: 입력받은 이름
	 * @return null || 이름이 일치하는 학생 객체 주소
	 */
	public StudentDTO selectName(String studentName) {
		for(StudentDTO std : students) {
			if(std == null) {
				return null;
			}
			
			if(std.getStudentName().equals(studentName)) {
				return std;
			}
		}
		
		return null;
	}
	
	/**
	 * 전달받은 인덱스가 students 범위 내 인덱스가 맞는지
	 * 맞다면 인덱스 번째 참조하는 학생이 있는지 확인하는 메서드
	 * @param index
	 * @return 1: 범위 초과 / 2: null / 3: 참조하는 학생 있음
	 */
	public int checkIndex(int index) {
		if(index < 0 || index >= students.length) {
			return 1;
		}
		
		if(students[index] == null) {
			return 2;
		}
		
		return 3;
	}
	
	/**
	 * 인덱스 번째 학생의 점수 수정 서비스 메서드
	 * @param index
	 * @param html
	 * @param css
	 * @param js
	 * @param java
	 */
	public void updateScore(int index, int html, int css, int js, int java) {
		students[index].setHtmlScore(html);
		students[index].setCssScore(css);
		students[index].setJsScore(js);
		students[index].setJavaScore(java);
	}
	
	/**
	 * students 배열에서 점수 평균 최고, 최저 학생 찾기
	 * @return result(문자열)
	 */
	public String selectMaxMin() {
		String maxName = null;
		double maxAvg = 0.0;
		String minName = null;
		double minAvg = 100.0;
		
		for(StudentDTO std : students) {
			if(std == null) {
				break;
			}
			
			int sum = std.getHtmlScore() + std.getCssScore() + std.getJsScore() + std.getJavaScore();
			double avg = sum / 4.0;
			
			if(avg > maxAvg) {
				maxAvg = avg;
				maxName = std.getStudentName();
			}
			
			if(avg < minAvg) {
				minAvg = avg;
				minName = std.getStudentName();
			}
		}
		
		String result = String.format("최고점: %s(%.1f)\n" + "최저점: %s(%.1f)", maxName, maxAvg, minName, minAvg);
		
		return result;
	}
	
	public void deleteIndex(int index) {
		for(int i = index; i < students.length - 1; i++) {
			students[i] = students[i + 1];
			students[i + 1] = null;
		}
	}
}