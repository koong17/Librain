package lib.member.book.model;

import java.sql.Timestamp;

public class MemBookDTO {
	private String book_num; // 도서번호
	private String book_author; // 저자
	private String book_name; // 도서명
	private String book_pub_house; // 출판사
	private Timestamp book_pub_date; // 발행일
	private String book_ISBN; // ISBN
	private String book_apdx_status; // 부록여부
	private String book_ctgr_num; // 분류기호
	private String book_rsrv_status; // 예약여부
	private String rent; //대출여부
	private int book_rent_cnt; //대출 횟수
    private Timestamp book_input_date;
	
	public String getBook_num() {
		return book_num;
	}
	public void setBook_num(String book_num) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		this.book_num = book_num;
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
	public String getBook_apdx_status() {
		return book_apdx_status;
	}
	public void setBook_apdx_status(String book_apdx_status) {
		this.book_apdx_status = book_apdx_status;
	}
	public String getBook_ctgr_num() {
		return book_ctgr_num;
	}
	public void setBook_ctgr_num(String book_ctgr_num) {
		this.book_ctgr_num = book_ctgr_num;
	}
	public String getBook_rsrv_status() {
		return book_rsrv_status;
	}
	public void setBook_rsrv_status(String book_rsrv_status) {
		this.book_rsrv_status = book_rsrv_status;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public int getBook_rent_cnt() {
		return book_rent_cnt;
	}
	public void setBook_rent_cnt(int book_rent_cnt) {
		this.book_rent_cnt = book_rent_cnt;
	}
	public Timestamp getBook_input_date() {
		return book_input_date;
	}
	public void setBook_input_date(Timestamp book_input_date) {
		this.book_input_date = book_input_date;
	}
	
}
