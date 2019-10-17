package lib.employee.book.model;

import java.sql.Timestamp;

public class BookRentDTO extends EmpBookDTO {
	private String rent_num; //대여번호
    private int book_num; //도서번호
    private String mem_id; //회원번호
    private Timestamp rent_startdate; //대여일
    private Timestamp rent_enddate; //반납일
    private String rent_appendix_status; //부록대출여부
    private String rent_extension; //대여연장
    
	public String getRent_num() {
		return rent_num;
	}
	public void setRent_num(String rent_num) {
		this.rent_num = rent_num;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Timestamp getRent_startdate() {
		return rent_startdate;
	}
	public void setRent_startdate(Timestamp rent_startdate) {
		this.rent_startdate = rent_startdate;
	}
	public Timestamp getRent_enddate() {
		return rent_enddate;
	}
	public void setRent_enddate(Timestamp rent_enddate) {
		this.rent_enddate = rent_enddate;
	}
	public String getRent_appendix_status() {
		return rent_appendix_status;
	}
	public void setRent_appendix_status(String rent_appendix_status) {
		this.rent_appendix_status = rent_appendix_status;
	}
	public String getRent_extension() {
		return rent_extension;
	}
	public void setRent_extension(String rent_extension) {
		this.rent_extension = rent_extension;
	}
	   
    
}
