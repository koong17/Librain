package lib.member.book.model;

import java.sql.Timestamp;

public class BookDTO {
	private String bookNum; // 도서번호
	private String bookAuthor; // 저자
	private String bookName; // 도서명
	private String bookPubHouse; // 출판사
	private Timestamp bookPubDate; // 발행일
	private String bookISBN; // ISBN
	private String bookApdxStatus; // 부록여부
	private String bookCtgrNum; // 분류기호
	private String bookRsrvStatus; // 예약여부
	
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPubHouse() {
		return bookPubHouse;
	}
	public void setBookPubHouse(String bookPubHouse) {
		this.bookPubHouse = bookPubHouse;
	}
	public Timestamp getBookPubDate() {
		return bookPubDate;
	}
	public void setBookPubDate(Timestamp bookPubDate) {
		this.bookPubDate = bookPubDate;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBookApdxStatus() {
		return bookApdxStatus;
	}
	public void setBookApdxStatus(String bookApdxStatus) {
		this.bookApdxStatus = bookApdxStatus;
	}
	public String getBookCtgrNum() {
		return bookCtgrNum;
	}
	public void setBookCtgrNum(String bookCtgrNum) {
		this.bookCtgrNum = bookCtgrNum;
	}
	public String getBookRsrvStatus() {
		return bookRsrvStatus;
	}
	public void setBookRsrvStatus(String bookRsrvStatus) {
		this.bookRsrvStatus = bookRsrvStatus;
	}
	
}
