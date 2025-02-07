package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공 클래스
 */
public class BookService {
	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	public BookService() {
		bookList.add(new BookDTO("채식주의자", "한강", 15000, "창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800, "포레스트북스"));
		bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
		bookList.add(new BookDTO("유대인의 상술", "후지다 덴", 18800, "지니의서재"));
		bookList.add(new BookDTO("싯다르타", "헤르만 헤세", 8000, "민음사"));
	}

	public List<BookDTO> getBookList() {
		return bookList;
	}
	
	/**
	 * 전달받은 인덱스번째 bookList 요소 반환
	 * 단, 범위 초과 시 null 반환
	 * @param index
	 * @return BookDTO 참조 주소 또는 null
	 */
	public BookDTO selectIndex(int index) {
		if(checkIndex(index) == false) return null;
		
		return bookList.get(index);
	}
	
	/**
	 * 전달받은 인덱스가 정상 범위인지 확인
	 * @param index
	 * @return 정상 true, 비정상 false
	 */
	public boolean checkIndex(int index) {
		if(index < 0 || index >= bookList.size()) return false;
		
		return true;
	}
	
	/**
	 * 전달받은 book을 bookList에 추가
	 * 단, 책 정보가 모두 일치하는 책이 있다면 추가하지 않음
	 * @param book
	 * @return 추가하면 true, 추가 안하면 false
	 */
	public boolean addBook(BookDTO book) {
		/* 책 정보 비교 방법
		 * 1. 필드 값 하나씩 꺼내서 비교
		 * 2. equals 오버라이딩 후 이용
		 */
		
//		for(BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		if(bookList.contains(book)) return false; // 사용하기 위해서 BookDTO의 equals()를 오버라이딩 해야함
		
		return bookList.add(book); // 컬렉션은 크기 제한이 없어서 무조건 추가가 성공
	}
	
	/**
	 * 전달받은 index번째 요소의 가격을 afterPrice로 수정
	 * @param index
	 * @param afterPrice
	 * @return "[제목] 가격이 [이전 가격] -> [수정된 가격]으로 수정되었습니다!"
	 */
	public String modifyPrice(int index, int afterPrice) {
		BookDTO book = bookList.get(index);
		
		int beforePrice = book.getPrice();
		
		book.setPrice(afterPrice);
		
		return String.format("\n[%s] 가격이 [%d] -> [%d] 으로 수정되었습니다!\n", book.getTitle(), beforePrice, afterPrice);
	}
	
	public String dropBook(int index) {
		BookDTO book = bookList.get(index);
		
		String title = book.getTitle();
		
		bookList.remove(index);

		return String.format("[%s]이 제거되었습니다!\n", title);
	}
	
	/**
	 * 제목이 일치하는 책 한권 조회
	 * @param title
	 * @return 도서정보, 제목이 [%s]인 도서가 존재하지 않습니다!
	 */
	public String selectTitle(String title) {
		for(int i = 0; i < bookList.size(); i++) {
			BookDTO book = bookList.get(i);
			
			if(book.getTitle().equals(title)) {
				return "\n도서 정보 [제목: " + title + ", 저자: " + book.getAuthor() + ", 가격: " + book.getPrice() + ", 출판사: " + book.getPublisher() + "]\n";
			}
		}
		
		return String.format("\n제목이 [%s]인 도서가 존재하지 않습니다!\n", title);
	}
	
	public String removeTitle(String title) {
		for(int i = 0; i < bookList.size(); i++) {
			BookDTO book = bookList.get(i);
			
			if(book.getTitle().equals(title)) {
				bookList.remove(i);
				
				return String.format("\n제목이 [%s]인 도서가 삭제되었습니다!\n", title);
			}
		}
		
		return String.format("\n제목이 [%s]인 도서가 존재하지 않습니다!\n", title);
	}
	
	public List<BookDTO> selectPublisher(String publisher) {
		List<BookDTO> resultList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			if(book.getPublisher().equals(publisher)) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}
	
	public List<BookDTO> selectAuthorAll(String author){
		List<BookDTO> resultList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			if(book.getAuthor().equals(author)) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}
	
	public List<BookDTO> searchBook(String input){
		List<BookDTO> resultList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			if(book.getTitle().contains(input) || book.getAuthor().contains(input)) {
				resultList.add(book);
			}
		}
		
		if(resultList.isEmpty()) {
			return null;
		}
		
		return resultList;
	}
	
	public void sortBookList() {
		Collections.sort(bookList);
	}
}