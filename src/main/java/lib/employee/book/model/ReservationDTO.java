package lib.employee.book.model;

public class ReservationDTO {
    private String rent_num; //대여번호
    private String mem_id; //회원번호
    private int rsrv_num; //예약번호
    
	public String getRent_num() {
		return rent_num;
	}
	public void setRent_num(String rent_num) {
		this.rent_num = rent_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getRsrv_num() {
		return rsrv_num;
	}
	public void setRsrv_num(int rsrv_num) {
		this.rsrv_num = rsrv_num;
	}
    
}
