package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**
 * 도서 관리 프로그램 입출력 담당 클래스(UI)
 */
public class BookView {
	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();
	
	/**
	 * 프로그램 메인 메뉴
	 */
	public void displayMenu() {
		int input = 0;
		
		do {
			System.out.println("\n[도서 관리 프로그램]\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. 인덱스 번호로 조회");
			System.out.println("3. 도서 정보 추가");
			System.out.println("4. 도서 가격 수정");
			System.out.println("5. 도서 정보 제거");
			
			System.out.println("6. 제목이 일치하는 책 한권 조회");
			System.out.println("7. 제목이 일치하는 책 제거");
			
			System.out.println("8. 출판사가 일치하는 책 모두 조회");
			System.out.println("9. 작가가 일치하는 책 모두 조회");
			
			System.out.println("10. 검색어가 제목, 저자에 포함된 모든 책 조회");
			
			System.out.println("11. bookList 제목 오름차순 정렬");
			
			System.out.println("0. 프로그램 종료");
			
			System.out.println();
			
			System.out.print("메뉴 번호 입력: ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거 (오류 방지)
			
			System.out.println();
			
			switch(input) {
			case 1: selectAll(); break;
			case 2: selectIndex(); break;
			case 3: addBook(); break;
			case 4: modifyPrice(); break;
			case 5: dropBook(); break;
			case 6: selectTitle(); break;
			case 7: removeTitle(); break;
			case 8: selectPublisher(); break;
			case 9: selectAuthorAll(); break;
			case 10: searchBook(); break;
			case 11: sortBookList(); break;
			case 0: System.out.println("프로그램 종료");; break;
			default: System.out.println("잘못된 입력");;
			}
		} while (input != 0);
	}

	/**
	 * 전체 조회
	 * BookService 필드 bookList를 얻어와
	 * 일반 for문을 이용하여 모든 요소 정보를 출력
	 * 단, bookList에 저장된 정보가 없으면 "저장된 책이 존재하지 않습니다." 출력
	 */
	private void selectAll() {
		System.out.println("\n[전체 조회]\n");
		
		List<BookDTO> list = service.getBookList();
		
		// int size(): 저장된 객체의 개수 반환
		// boolean isEmpty(): 저장된 객체가 없으면 true 반환
//		if(list.size() == 0) {
		if(list.isEmpty()) {
			System.out.println("저장된 책이 존재하지 않습니다.");
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + ") " + list.get(i));
		}
	}
	
	/**
	 * 인덱스 번호로 조회
	 * 조회하려는 책의 인덱스 번호를 입력받아 책 정보를 출력
	 * bookService로부터 인덱스 번째 BookDTO 반환
	 * 단, 인덱스 번호가 bookList의 범위를 초과하면 
	 * "해당 인덱스에 책이 존재하지 않습니다." 출력
	 */
	private void selectIndex() {
		System.out.println("\n[인덱스 번호로 조회]\n");
		
		System.out.print("조회할 도서의 인덱스 번호: ");
		int input = sc.nextInt();
		
		BookDTO book = service.selectIndex(input);
		
		if(book == null) {
			System.out.println("\n해당 인덱스에 책이 존재하지 않습니다!\n");
			return;
		}
		
		System.out.println();
		
		System.out.println("제목: " + book.getTitle());
		System.out.println("저자: " + book.getAuthor());
		System.out.println("가격: " + book.getPrice());
		System.out.println("출판사: " + book.getPublisher());
	}
	
	/**
	 * 도서 정보 추가
	 * 책 정보를 입력받아 BookService의 bookList에 마지막 요소로 추가
	 * 단, 모든 정보가 중복되는 책은 추가하지 않음
	 */
	private void addBook() {
		System.out.println("\n[도서 정보 추가]\n");
		
		System.out.println("제목: ");
		String title = sc.nextLine(); // 줄바꿈되기 전까지 문자열 얻어오기
		
		System.out.println("\n저자: ");
		String author = sc.nextLine();
		
		System.out.println("\n가격: ");
		int price = sc.nextInt();
		sc.nextLine(); // 입력 수행 후 무조건 작성
		
		System.out.println("\n출판사: ");
		String publisher = sc.nextLine();
		
		boolean result = service.addBook(new BookDTO(title, author, price, publisher));
		
		if(result) {
			
		} else {
			System.out.println("\n제목이 " + title + "인 책이 이미 존재합니다!\n");
		}
	}
	
	/**
	 * 도서 가격 수정
	 * 인덱스 번호를 입력받아 해당 인덱스에 
	 * 책이 없다면 "해당 인덱스에 책이 존재하지 않습니다!" 출력하고 
	 * 책이 있다면 "수정할 가격: " 출력하고 스캐너로 가격을 입력받은 뒤
	 * 입력받은 인덱스번째 요소에 가격을 입력받은 값으로 수정하고
	 * "[제목] 가격이 [이전 가격] -> [수정된 가격]으로 수정되었습니다!" 출력
	 */
	
//	private void modifyPrice() {
//		System.out.println("\n[도서 가격 수정]\n");
//		
//		System.out.print("가격을 수정할 도서의 인덱스 번호: ");
//		int index = sc.nextInt(); 
//		sc.nextLine();
//		
//		BookDTO book = service.selectIndex(index);
//		
//		if(book == null) {
//			System.out.println("해당 인덱스에 책이 존재하지 않습니다!");
//			return;
//		}
//		
//		System.out.println();
//		
//		System.out.print("수정할 가격: ");
//		int afterPrice = sc.nextInt();
//		sc.nextLine();
//		
//		int beforePrice = book.getPrice();
//		
//		book.setPrice(afterPrice);
//		
//		System.out.println("\n[" + book.getTitle() + "] 가격이 [" + beforePrice + "] -> [" + afterPrice + "]으로 수정되었습니다!\n");
//	}
	
	private void modifyPrice() {
		System.out.println("\n[도서 가격 수정]\n");
		
		System.out.print("가격을 수정할 도서의 인덱스 번호: ");
		int index = sc.nextInt(); 
		sc.nextLine();
		
		if(service.checkIndex(index) == false) {
			System.out.println("\n해당 인덱스에 책이 존재하지 않습니다!\n");
			return;
		}
		
		System.out.println();
		
		System.out.print("수정할 가격: ");
		int afterPrice = sc.nextInt();
		sc.nextLine();
		
		System.out.println(service.modifyPrice(index, afterPrice));
	}
	
	private void dropBook() {
		System.out.println("\n[도서 정보 제거]\n");
		
		System.out.print("삭제할 도서의 인덱스 입력: ");
		int index = sc.nextInt();
		sc.nextLine();
		
		if(service.checkIndex(index) == false) {
			System.out.println("\n해당 인덱스에 책이 존재하지 않습니다!\n");
			return;
		}
		
		System.out.println();
		
		System.out.println(service.dropBook(index));
	}
	
	private void selectTitle() {
		System.out.println("\n[제목이 일치하는 책 한권 조회]\n");
		
		System.out.print("조회할 도서 제목: ");
		String title = sc.nextLine();
		
		System.out.println(service.selectTitle(title));
	}
	
	private void removeTitle() {
		System.out.println("\n[제목이 일치하는 책 제거]\n");
		
		System.out.print("삭제할 도서 제목: ");
		String title = sc.nextLine();
		
		System.out.println(service.removeTitle(title));
	}
	
	private void selectPublisher() {
		System.out.println("\n[출판사가 일치하는 책 모두 조회]\n");
		
		System.out.print("조회할 출판사: ");
		String publisher = sc.nextLine();
		
		System.out.println();
		
		List<BookDTO> resultList = service.selectPublisher(publisher);
		
		if(resultList.isEmpty()) {
			System.out.println("\n출판사가 [" + publisher + "]인 책이 존재하지 않습니다!\n");
			return;
		}
		
		for(int i = 0; i < resultList.size(); i++) {
			System.out.println((i + 1) + ") " + resultList.get(i));
		}
	}
	
	private void selectAuthorAll() {
		System.out.println("\n[작가가 일치하는 책 모두 조회]\n");
		
		System.out.print("조회할 작가: ");
		String author = sc.nextLine();
		
		System.out.println();
		
		List<BookDTO> resultList = service.selectAuthorAll(author);
		
		if(resultList.isEmpty()) {
			System.out.println("\n작가가 [" + author + "]인 책이 존재하지 않습니다!\n");
			
			return;
		}
		
		for(int i = 0; i < resultList.size(); i++) {
			System.out.println((i + 1) + ") " + resultList.get(i));
		}
	}
	
	private void searchBook() {
		System.out.println("\n[검색어가 제목, 저자에 포함된 모든 책 조회]\n");
		
		System.out.print("검색어: ");
		String input = sc.nextLine();
		
		System.out.println();
		
		List<BookDTO> resultList = service.searchBook(input);
		
		if(resultList == null) {
			System.out.println("검색어 [" + input + "]이/가 포함된 책이 존재하지 않습니다!\n");
			
			return;
		}
		
		for(int i = 0; i < resultList.size(); i++) {
			System.out.println((i + 1) + ") " + resultList.get(i));
		}
	}
	
	private void sortBookList() {
		System.out.println("\n[제목 오름차순 정렬 ]\n");

		service.sortBookList();
	}
}
