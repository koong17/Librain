package lib.member.model;

public class MemberDTO {

	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_jumin;
	private String mem_address;
	private String mem_phone;
	private String mem_email;
	private String mem_address_number;
	private int mem_rank;
	
	///////////constructor///////////
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String mem_id, String mem_pw, String mem_name, String mem_jumin, String mem_address,
			String mem_phone, String mem_email, String mem_address_number, int mem_rank) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_jumin = mem_jumin;
		this.mem_address = mem_address;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_address_number = mem_address_number;
		this.mem_rank = mem_rank;
	}
	
	////////getter and setter/////////
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_jumin() {
		return mem_jumin;
	}
	public void setMem_jumin(String mem_jumin) {
		this.mem_jumin = mem_jumin;
	}
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_address_number() {
		return mem_address_number;
	}
	public void setMem_address_number(String mem_address_number) {
		this.mem_address_number = mem_address_number;
	}
	public int getMem_rank() {
		return mem_rank;
	}
	public void setMem_rank(int mem_rank) {
		this.mem_rank = mem_rank;
	}
	
}