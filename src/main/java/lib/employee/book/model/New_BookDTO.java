package lib.employee.book.model;

public class New_BookDTO {
	private int new_book_num; //신청 번호
	private String book_author; //저자
	private String book_name; //도서명
	private String book_pub_house; //출판사
	
	
	public int getNew_book_num() {
		return new_book_num;
	}
	public void setNew_book_num(int new_book_num) {
		this.new_book_num = new_book_num;
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
	
	
}
