package lib.employee.book.model;

import java.sql.Timestamp;

public class BookRentDisDTO extends BookRentDTO {
	private int dis_book_num; //폐기 신청 번호
    private int book_num; //도서번호
    private Timestamp dis_input_date; //신청일
    private String dis_status; //상태
	public int getDis_book_num() {
		return dis_book_num;
	}
	public void setDis_book_num(int dis_book_num) {
		this.dis_book_num = dis_book_num;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public Timestamp getDis_input_date() {
		return dis_input_date;
	}
	public void setDis_input_date(Timestamp dis_input_date) {
		this.dis_input_date = dis_input_date;
	}
	public String getDis_status() {
		return dis_status;
	}
	public void setDis_status(String dis_status) {
		this.dis_status = dis_status;
	}
    
    
}
