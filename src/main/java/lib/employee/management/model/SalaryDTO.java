package lib.employee.management.model;

import java.sql.Timestamp;

public class SalaryDTO {
	private int sal_no, emp_no, sal_total, sal_real, sal_national_pension, sal_health_insurance, sal_longterm_care_insurance;
	private int sal_employment_insurance, sal_income_tax, sal_local_income_tax, sal_deducted;
	private int sal_basic_pay, sal_bonus, sal_food_pay, sal_year, sal_month;
	
	public SalaryDTO() {}

	public int getSal_no() {
		return sal_no;
	}

	public void setSal_no(int sal_no) {
		this.sal_no = sal_no;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public int getSal_total() {
		return sal_total;
	}

	public void setSal_total(int sal_total) {
		this.sal_total = sal_total;
	}

	public int getSal_real() {
		return sal_real;
	}

	public void setSal_real(int sal_real) {
		this.sal_real = sal_real;
	}

	public int getSal_national_pension() {
		return sal_national_pension;
	}

	public void setSal_national_pension(int sal_national_pension) {
		this.sal_national_pension = sal_national_pension;
	}

	public int getSal_health_insurance() {
		return sal_health_insurance;
	}

	public void setSal_health_insurance(int sal_health_insurance) {
		this.sal_health_insurance = sal_health_insurance;
	}

	public int getSal_longterm_care_insurance() {
		return sal_longterm_care_insurance;
	}

	public void setSal_longterm_care_insurance(int sal_longterm_care_insurance) {
		this.sal_longterm_care_insurance = sal_longterm_care_insurance;
	}

	public int getSal_employment_insurance() {
		return sal_employment_insurance;
	}

	public void setSal_employment_insurance(int sal_employment_insurance) {
		this.sal_employment_insurance = sal_employment_insurance;
	}

	public int getSal_income_tax() {
		return sal_income_tax;
	}

	public void setSal_income_tax(int sal_income_tax) {
		this.sal_income_tax = sal_income_tax;
	}

	public int getSal_local_income_tax() {
		return sal_local_income_tax;
	}

	public void setSal_local_income_tax(int sal_local_income_tax) {
		this.sal_local_income_tax = sal_local_income_tax;
	}

	public int getSal_deducted() {
		return sal_deducted;
	}

	public void setSal_deducted(int sal_deducted) {
		this.sal_deducted = sal_deducted;
	}

	public int getSal_basic_pay() {
		return sal_basic_pay;
	}

	public void setSal_basic_pay(int sal_basic_pay) {
		this.sal_basic_pay = sal_basic_pay;
	}

	public int getSal_bonus() {
		return sal_bonus;
	}

	public void setSal_bonus(int sal_bonus) {
		this.sal_bonus = sal_bonus;
	}

	public int getSal_food_pay() {
		return sal_food_pay;
	}

	public void setSal_food_pay(int sal_food_pay) {
		this.sal_food_pay = sal_food_pay;
	}

	public int getSal_year() {
		return sal_year;
	}

	public void setSal_year(int sal_year) {
		this.sal_year = sal_year;
	}

	public int getSal_month() {
		return sal_month;
	}

	public void setSal_month(int sal_month) {
		this.sal_month = sal_month;
	}
	
}
