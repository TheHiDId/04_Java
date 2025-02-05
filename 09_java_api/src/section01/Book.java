package section01;

import java.util.Objects;

public class Book {
	private long bookNumber;
	private String bookTitle;
	private String author;
	private int price;
	
	public Book() {
		super();
	}

	public Book(long bookNumber, String bookTitle, String author, int price) {
		super();
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
		this.author = author;
		this.price = price;
	}

	public long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + ", author=" + author + ", price=" + price + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true; // 같은 객체를 비교하는 경우 아래 코드들을 실행하지 않도록 하기위한 코드
		
		if(obj == null) return false; // 비교 대상이 없는 경우 아래 코드들을 실행하지 않도록 하기위한 코드

		if(!(obj instanceof Book)) return false; // 비교 대상 서로 타입이 다를 경우 아래 코드들을 실행하지 않도록 하기위한 코드
		
		Book other = (Book)obj;
		
		if(this.bookNumber != other.bookNumber) return false;
		
		if(!this.bookTitle.equals(other.bookTitle)) return false;
		
		if(!this.author.equals(other.author)) return false;
		
		if(this.price != other.price) return false;
		
		return true;
	}
	
	/* 해시코드 오버라이딩
	 * 동등한 객체는 같은 식별번호를 가져야함
	 * A.equals(B) -> true 이면 A.hashCode() == B.hashCode() -> true
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bookNumber, bookTitle, author, price);
	}
}
