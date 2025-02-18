package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import dto.Todo;
import service.TodoListService;

public class TodoListView {
	private TodoListService service = null;
	private BufferedReader br = null; // Scanner 대신 사용

	// 기본 생성자
	public TodoListView() {
		
		try {
			service = new TodoListService();		
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			
			e.printStackTrace();
			
			System.exit(0); // 프로그램 종료
		}
	}
	
	// 시작 화면
	public void startView() {

		int selectNumber = 0;
		
		do {
			try {
				selectNumber = selectMenu();
				
				switch (selectNumber) {
				case 1: todoListFullView(); break; 
				case 2: todoDetailView(); break; 
				case 3: todoAdd(); break; 
				case 4: todoComplete(); break; 
				case 5: todoUpdate(); break; 
				case 6: todoDelete(); break; 
				
				case 0: 
					System.out.println("@@@ 프로그램 종료 @@@"); 
					br.close();
				break; 
				
				default: System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
				}
				
				System.out.println();
				

			} catch (NumberFormatException e) {
				System.out.println("### 숫자만 입력해 주세요 ###");
				
			} catch (IOException e) {
				System.err.println("### 입/출력 관련 예외 발생 ###");
				
				e.printStackTrace();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (selectNumber != 0);
		
		try {
			if (br != null) 	br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 메뉴 선택
	private int selectMenu() throws NumberFormatException, IOException {

		System.out.println("====== Todo List =====");
		
		System.out.println();
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.println();
		
		System.out.print("select menu number >>> ");
		int input = Integer.parseInt(br.readLine());
		
		System.out.println();
		
		return input;
	}
	
	/**
	 * 할 일 목록 모두 보기
	 */
	private void todoListFullView() {
		System.out.println("[1. Todo List Full View]\n");
		
		Map<String, Object> todoMap = service.todoListFullView();
		
		List<Todo> todoList = (List<Todo>)todoMap.get("todoList");
		
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수: %d / %d ]\n", todoMap.get("completeCount"), todoList.size());
		
		System.out.println("인덱스, 등록일, 완료 여부, 할 일 제목");
		
		for(int i = 0; i < todoList.size(); i++) {
			System.out.printf("[%2d] %19s (%s) %10s\n", i, service.dateFormat(todoList.get(i).getRegDate()), todoList.get(i).isComplete() ? "O" : "X", todoList.get(i).getTitle());
		}
	}

	/**
	 * 할 일 상세 보기
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoDetailView() throws NumberFormatException, IOException {
		System.out.println("[2. Todo Detail View]\n");
		
		System.out.print("인덱스 번호 입력: ");
		int index = Integer.parseInt(br.readLine());
		
		String result = service.todoDetailView(index);
		
		if(result == null) {
			System.out.println("### 해당 인덱스에 할 일이 존재하지 않습니다 ###");
			
			return;
		}
		
		System.out.println(result);
	}

	/**
	 * 할 일 추가
	 * @throws IOException 
	 */
	private void todoAdd() throws IOException {
		System.out.println("[3. Todo Add]\n");
		
		System.out.print("할 일 제목 입력: ");
		String title = br.readLine();
		
		System.out.println();
		
		System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)\n");
		StringBuilder sb = new StringBuilder();
		
		while(br.readLine() != "!wq") {
			sb.append(br.readLine());
		}
		
		String detail = sb.toString();
		
		int index = service.todoAdd(title, detail);
		
		if(index == -1) {
			return;
		}
		
		System.out.printf("[%d]번 인덱스에 추가 되었습니다\n", index);
	}

	/**
	 * 할 일 완료
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoComplete() throws NumberFormatException, IOException {
		System.out.println("[4. Todo Complete]\n");
		
		System.out.print("O <-> X 변경할 인덱스 번호 입력: ");
		int index = Integer.parseInt(br.readLine());
		
		boolean result = service.todoComplete(index);
		
		if(result) {
			System.out.println("[변경 되었습니다]");
		} else {
			System.out.println("### 해당 인덱스에 할 일이 존재하지 않습니다 ###");
		}
	}

	/**
	 * 할 일 수정
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void todoUpdate() throws NumberFormatException, IOException {
		System.out.println("[5. Todo Update]\n");
		
		System.out.print("수정할 To do 인덱스 번호 입력: ");
		int index = Integer.parseInt(br.readLine());
		
		System.out.println();
		
		System.out.print("할 일 제목 입력: ");
		String title = br.readLine();
	}

	/**
	 * 할 일 삭제
	 */
	private void todoDelete() {
		// TODO Auto-generated method stub
		
	}
}
