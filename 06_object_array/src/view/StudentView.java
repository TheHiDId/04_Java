package view;

import java.util.Scanner;

import dto.StudentDTO;
import service.StudentService;

public class StudentView {
	private Scanner sc = new Scanner(System.in);
	
	private StudentService service = new StudentService();
	
	public void mainMenu() {
		int input = 0;
		
		do {
			System.out.println("\n[학생 관리 프로그램]");
			
			System.out.println();
			
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(인덱스 / 점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("8. 학생 삭제(인덱스)");
			System.out.println("0. 종료");
			
			System.out.println();
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			
			switch(input) {
			case 1: addStudent(); break;
			case 2: allStudent(); break;
			case 3: selectIndex(); break;
			case 4: selectName(); break;
			case 5: updateIndex(); break;
			case 6: selectScore(); break;
			case 7: selectMaxMin(); break;
			case 8: deleteIndex(); break;
			case 0: System.out.println("-프로그램 종료-"); break;
			default: System.out.println("-잘못된 입력-");
			}
		} while(input != 0);
	}
	
	/**
	 * 학생 전체 조회 메서드
	 */
	private void allStudent() {
		System.out.printf("\n[학생 전체 조회]\n\n");
		
		StudentDTO[] studentInfo = service.getStudentInfo();
		
		for(StudentDTO student : studentInfo) {
			if(student == null) {
				continue;
			}
			
			/*
			 * 참조 변수를 문자열 만들 때, 또는 print() 관련 메서드에 사용될 때,
			 * 참조 변수에 저장된 주소가 출력되면 이상하므로 컴파일러가 자동으로 참조 변수를 호출하도록 변경
			 */
			
			System.out.println(student.toString());
		}
	}
	
	/**
	 * 학생 추가 메서드
	 * <pre>
	 * 	학번, 이름, 성별을 입력받아
	 * 	StudentDTO 객체로 만들어서
	 * 	StudentService.addStudent() 메서드에 전달
	 * 	-> 추가 성공 시 true, 실패 시 false 반환받아 결과 출력
	 * </pre>
	 */
	private void addStudent() {
		System.out.println("\n-학생 추가-\n");
		
		System.out.print("학번: ");
		String studentNumber = sc.next();
		
		System.out.print("이름: ");
		String studentName = sc.next();
		
		System.out.print("성별: ");
		char gender = sc.next().charAt(0);
		
		StudentDTO student = new StudentDTO(studentNumber, studentName, gender);
		
		boolean result = service.addStudent(student);
		
		if(result) {
			System.out.println(studentName + " 학생이 추가 되었습니다.\n");
		} else {
			System.out.println("더 이상 학생을 추가할 수 없습니다.\n");
		}
	}
	
	/**
	 * 학생 1명 정보 조회 메서드
	 * <pre>
	 * 인덱스를 입력받아 
	 * StudentService.selectIndex()로 전달
	 * 학생 객체 배열에서 해당 인덱스 번째 학생을 반환
	 * 반환받은 학생정보를 출력
	 * 단, 반환받은 학생이 없을 경우(null)
	 * "해당 인덱스에 학생이 존재하지 않습니다" 출력
	 * </pre>
	 */
	private void selectIndex() {
		System.out.println("\n-학생 1명 정보 조회-\n");
		
		System.out.print("조회할 인덱스 입력: ");
		int index = sc.nextInt();
		
		StudentDTO student = service.selectIndex(index);
		
		if(student == null) {
			System.out.println("\n해당 인덱스에 학생이 존재하지 않습니다.");
		} else {
			System.out.println(index + "번쨰 학생 정보");
			System.out.println(student.toString());
		}
	}
	
	/**
	 * 학생 이름으로 조회
	 * <pre>
	 * 이름을 입력받아 StudentDTO 
	 * StudentService.selectName(String studentName) 호출
	 * 학생정보 반환 받아서 출력
	 * 단, 반환받은 학생이 없을 경우
	 * "OOO 학생은 존재하지 않습니다." 출력
	 * </pre>
	 */
	private void selectName() {
		System.out.println("\n-학생 이름으로 조회-\n");
		
		System.out.print("조회하고 싶은 학생 이름: ");
		String StudentName = sc.next();
		
		StudentDTO student = service.selectName(StudentName);
		
		if(student == null) {
			System.out.println("\n" + StudentName + " 학생은 존재하지 않습니다.");
		} else {
			System.out.println("\n" + student.toString());
		}
	}
	
	/**
	 * 학생 정보 수정
	 * <pre>
	 * 인덱스 번호를 입력받아 해당 인덱스에 학생이 있는지 확인
	 * 1) 인덱스 범위 초과: "인덱스 범위가 올바르지 않습니다."
	 * 2) 참조하는 학생이 없을 경우: "해당 인덱스에 학생이 존재하지 않습니다."
	 * 
	 * 입력받은 인덱스에 학생이 있을 경우
	 * HTML, CSS, JS, Java 점수를 순서대로 입력 받은 후
	 * void StudentService.updateScore(index, 점수...) 호출
	 * </pre>
	 */
	private void updateIndex() {
		System.out.println("\n-학생 정보 수정(인덱스)-\n");
		
		System.out.print("수정할 학생의 인덱스 번호 입력: ");
		int index = sc.nextInt();
		
		int check = service.checkIndex(index);
		
		if(check == 1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}
		
		if(check == 2) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		System.out.print("HTML, CSS, JS, Java 점수를 순서대로 입력: ");
		int html = sc.nextInt();
		int css = sc.nextInt();
		int js = sc.nextInt();
		int java = sc.nextInt();
		
		service.updateScore(index, html, css, js, java);
		
		System.out.println("-점수 수정 완료-");
	}
	
	/**
	 * 학생 1명 점수 조회 메서드
	 * <pre>
	 * 인덱스 번호를 입력받아 해당 인덱스에 학생이 있는지 확인
	 * 1) 인덱스 범위 초과: "인덱스 범위가 올바르지 않습니다."
	 * 2) 참조하는 학생이 없을 경우: "해당 인덱스에 학생이 존재하지 않습니다."
	 * 
	 * 인덱스가 정상 입력되었다면 해당 인덱스번째 학생(StudentDTO)을 반환
	 * 
	 * 합계, 평균 구하고 아래와 같은 형식으로 출력
	 * [20250001] 짱구(남)
	 * HTML: 10, CSS: 20, JS: 30, JAVA: 40
	 * 합계: 100
	 * 평균: 25.0
	 * </pre>
	 */
	private void selectScore() {
		System.out.println("\n-학생 1명 점수 조회(인덱스 / 점수, 합계, 평균)-\n");
		
		System.out.print("점수를 조회하고 싶은 학생의 인덱스 입력: ");
		int index = sc.nextInt();
		
		int check = service.checkIndex(index);
		
		if(check == 1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}
		
		if(check == 2) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		StudentDTO student = service.selectIndex(index);
		
		System.out.println(student.toString());
		System.out.println("합계: " + (student.getHtmlScore() + student.getCssScore() + student.getJsScore() + student.getJavaScore()));
		System.out.printf("평균: %.1f\n", ((student.getHtmlScore() + student.getCssScore() + student.getJsScore() + student.getJavaScore()) / 4.0));
	}
	
	/**
	 * 평균의 최고점, 최저점 학생 조회 메서드
	 * <pre>
	 * String StudentService.selectMaxMin() 메서드를 호출
	 * 
	 * 아래와 같은 문자열을 반환받아 출력
	 * 최고점 : OO(00.0)
	 * 최저점 : OO(00.0)
	 * </pre>
	 */
	private void selectMaxMin() {
		String result =  service.selectMaxMin();
		
		System.out.println(result);
	}
	
	/**
	 * 학생 삭제 메서드
	 * 
	 * 인덱스 입력받아 검사
	 * 
	 * 정말로 삭제할지 확인 절차 추가
	 * "정말 삭제 하시겠습니까?(Y/N): "
	 * 
	 * N 입력 시 "취소 되었습니다." 출력 후 리턴;
	 * 
	 * Y 입력 시 students 배열에서 입력받은 인덱스번째 요소를 null로 변경
	 * 삭제 된 인덱스 뒤의 요소를 하나씩 앞 인덱스로 이동
	 * "삭제 되었습니다." 출력 후 return;
	 */
	private void deleteIndex() {
		System.out.println("\n-학생 삭제(인덱스)-\n");
		
		System.out.print("삭제하고 싶은 학생의 인덱스 입력: ");
		int index = sc.nextInt();
		
		int check = service.checkIndex(index);
		
		if(check == 1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}
		
		if(check == 2) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		System.out.print("정말 삭제 하시겠습니까?(Y/N): ");
		char yesOrNo = sc.next().charAt(0);
		
		if(yesOrNo == 'N') {
			System.out.println("\n취소 되었습니다.");
			return;
		}
		
		service.deleteIndex(index);
		
		System.out.println("삭제 되었습니다.");
			
		return;
	}
}