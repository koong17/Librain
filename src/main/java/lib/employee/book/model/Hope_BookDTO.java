package lib.employee.book.model;

import java.sql.Timestamp;

public class Hope_BookDTO {
    private int hope_book_num; //희망 도서 번호
    private String book_author; //저자
    private String book_name; //도서명
    private String book_pub_house; //출판사
    private Timestamp book_pub_date; //발행일
    private String book_ISBN; //isbn
    private int book_price; //도서 가격
    private String hope_status; //승인 상태
    private Timestamp hope_input_date; //신청일
	
    public int getHope_book_num() {
		return hope_book_num;
	}
	public void setHope_book_num(int hope_book_num) {
		this.hope_book_num = hope_book_num;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_pub_house() {
		return book_pub_house;
	}
	public void setBook_pub_house(String book_pub_house) {
		this.book_pub_house = book_pub_house;
	}
	public Timestamp getBook_pub_date() {
		return book_pub_date;
	}
	public void setBook_pub_date(Timestamp book_pub_date) {
		this.book_pub_date = book_pub_date;
	}
	public String getBook_ISBN() {
		return book_ISBN;
	}
	public void setBook_ISBN(String book_ISBN) {
		this.book_ISBN = book_ISBN;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getHope_status() {
		return hope_status;
	}
	public void setHope_status(String hope_status) {
		this.hope_status = hope_status;
	}
	public Timestamp getHope_input_date() {
		return hope_input_date;
	}
	public void setHope_input_date(Timestamp hope_input_date) {
		this.hope_input_date = hope_input_date;
	}
    
}
