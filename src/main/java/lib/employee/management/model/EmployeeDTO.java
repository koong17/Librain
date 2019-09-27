package lib.employee.management.model;

import java.sql.Timestamp;

public class EmployeeDTO {
	private String emp_no, emp_name , emp_telephone ,emp_address, emp_address_number, emp_dept_code, emp_jumin, emp_gender;
    private Timestamp emp_join_date, emp_retire_date;
    private String emp_email, emp_rank_position, emp_duty_responsibility, emp_continuous_service_date, emp_bank_name;
    private String emp_account_holder, emp_account_number, emp_picture, emp_attach_file, emp_join_company_division, emp_password;
	
    public EmployeeDTO() {}
    
    EmployeeDTO(String emp_no, String emp_name, String emp_telephone, String emp_dept_code, Timestamp emp_join_date,
			String emp_email, String emp_rank_position) {
		super();
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_telephone = emp_telephone;
		this.emp_dept_code = emp_dept_code;
		this.emp_join_date = emp_join_date;
		this.emp_email = emp_email;
		this.emp_rank_position = emp_rank_position;
	}

	public EmployeeDTO(String emp_no, String emp_name, String emp_telephone, String emp_address, String emp_address_number,
			String emp_dept_code, String emp_jumin, String emp_gender, Timestamp emp_join_date,
			Timestamp emp_retire_date, String emp_email, String emp_rank_position, String emp_duty_responsibility,
			String emp_continuous_service_date, String emp_bank_name, String emp_account_holder,
			String emp_account_number, String emp_picture, String emp_attach_file, String emp_join_company_division,
			String emp_password) {
		super();
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_telephone = emp_telephone;
		this.emp_address = emp_address;
		this.emp_address_number = emp_address_number;
		this.emp_dept_code = emp_dept_code;
		this.emp_jumin = emp_jumin;
		this.emp_gender = emp_gender;
		this.emp_join_date = emp_join_date;
		this.emp_retire_date = emp_retire_date;
		this.emp_email = emp_email;
		this.emp_rank_position = emp_rank_position;
		this.emp_duty_responsibility = emp_duty_responsibility;
		this.emp_continuous_service_date = emp_continuous_service_date;
		this.emp_bank_name = emp_bank_name;
		this.emp_account_holder = emp_account_holder;
		this.emp_account_number = emp_account_number;
		this.emp_picture = emp_picture;
		this.emp_attach_file = emp_attach_file;
		this.emp_join_company_division = emp_join_company_division;
		this.emp_password = emp_password;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_telephone() {
		return emp_telephone;
	}

	public void setEmp_telephone(String emp_telephone) {
		this.emp_telephone = emp_telephone;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_address_number() {
		return emp_address_number;
	}

	public void setEmp_address_number(String emp_address_number) {
		this.emp_address_number = emp_address_number;
	}

	public String getEmp_dept_code() {
		return emp_dept_code;
	}

	public void setEmp_dept_code(String emp_dept_code) {
		this.emp_dept_code = emp_dept_code;
	}

	public String getEmp_jumin() {
		return emp_jumin;
	}

	public void setEmp_jumin(String emp_jumin) {
		this.emp_jumin = emp_jumin;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public Timestamp getEmp_join_date() {
		return emp_join_date;
	}

	public void setEmp_join_date(Timestamp emp_join_date) {
		this.emp_join_date = emp_join_date;
	}

	public Timestamp getEmp_retire_date() {
		return emp_retire_date;
	}

	public void setEmp_retire_date(Timestamp emp_retire_date) {
		this.emp_retire_date = emp_retire_date;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_rank_position() {
		return emp_rank_position;
	}

	public void setEmp_rank_position(String emp_rank_position) {
		this.emp_rank_position = emp_rank_position;
	}

	public String getEmp_duty_responsibility() {
		return emp_duty_responsibility;
	}

	public void setEmp_duty_responsibility(String emp_duty_responsibility) {
		this.emp_duty_responsibility = emp_duty_responsibility;
	}

	public String getEmp_continuous_service_date() {
		return emp_continuous_service_date;
	}

	public void setEmp_continuous_service_date(String emp_continuous_service_date) {
		this.emp_continuous_service_date = emp_continuous_service_date;
	}

	public String getEmp_bank_name() {
		return emp_bank_name;
	}

	public void setEmp_bank_name(String emp_bank_name) {
		this.emp_bank_name = emp_bank_name;
	}

	public String getEmp_account_holder() {
		return emp_account_holder;
	}

	public void setEmp_account_holder(String emp_account_holder) {
		this.emp_account_holder = emp_account_holder;
	}

	public String getEmp_account_number() {
		return emp_account_number;
	}

	public void setEmp_account_number(String emp_account_number) {
		this.emp_account_number = emp_account_number;
	}

	public String getEmp_picture() {
		return emp_picture;
	}

	public void setEmp_picture(String emp_picture) {
		this.emp_picture = emp_picture;
	}

	public String getEmp_attach_file() {
		return emp_attach_file;
	}

	public void setEmp_attach_file(String emp_attach_file) {
		this.emp_attach_file = emp_attach_file;
	}

	public String getEmp_join_company_division() {
		return emp_join_company_division;
	}

	public void setEmp_join_company_division(String emp_join_company_division) {
		this.emp_join_company_division = emp_join_company_division;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
    
}

