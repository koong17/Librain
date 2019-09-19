package lib.employee.mypage.model;

import java.util.Calendar;
import java.util.Date;

public class CommuteDTO {
	private int cmt_no;
	private String cmt_emp_no, cmt_status, cmt_year, cmt_month, cmt_day, cmt_hour, cmt_minute, cmt_second;
    
	public CommuteDTO() {}
	

	public CommuteDTO(String cmt_emp_no, String cmt_status) {
		this.cmt_emp_no = cmt_emp_no;
		this.cmt_status = cmt_status;
		Calendar cal = Calendar.getInstance();
		this.cmt_year = cal.get(Calendar.YEAR)+"";
		this.cmt_month = cal.get(Calendar.MONTH)+1 +"";
		this.cmt_day =  cal.get(Calendar.DAY_OF_MONTH) +"";
		this.cmt_hour = cal.get(Calendar.HOUR_OF_DAY) +"";
		this.cmt_minute = cal.get(Calendar.MINUTE) +"";
		this.cmt_second = cal.get(Calendar.SECOND) +"";
	}


	public int getCmt_no() {
		return cmt_no;
	}

	public void setCmt_no(int cmt_no) {
		this.cmt_no = cmt_no;
	}

	public String getCmt_emp_no() {
		return cmt_emp_no;
	}

	public void setCmt_emp_no(String cmt_emp_no) {
		this.cmt_emp_no = cmt_emp_no;
	}

	public String getCmt_status() {
		return cmt_status;
	}

	public void setCmt_status(String cmt_status) {
		this.cmt_status = cmt_status;
	}

	public String getCmt_year() {
		return cmt_year;
	}

	public void setCmt_year(String cmt_year) {
		this.cmt_year = cmt_year;
	}

	public String getCmt_month() {
		return cmt_month;
	}

	public void setCmt_month(String cmt_month) {
		this.cmt_month = cmt_month;
	}

	public String getCmt_day() {
		return cmt_day;
	}

	public void setCmt_DAY(String cmt_day) {
		this.cmt_day = cmt_day;
	}

	public String getCmt_hour() {
		return cmt_hour;
	}

	public void setCmt_hour(String cmt_hour) {
		this.cmt_hour = cmt_hour;
	}

	public String getCmt_minute() {
		return cmt_minute;
	}

	public void setCmt_minute(String cmt_minute) {
		this.cmt_minute = cmt_minute;
	}

	public String getCmt_second() {
		return cmt_second;
	}
	
	public void setCmt_second(String cmt_second) {
		this.cmt_second = cmt_second;
	}
	
}

