package lib.employee.facilityinspection.model;

import java.security.Timestamp;

public class FacilitiesDTO {
	private int Fac_serialnum;
	private String Fac_name;
	private String Fac_address;
	private String Fac_status;
	private String Fac_category;
	
	public int getFac_serialnum() {
		return Fac_serialnum;
	}
	public void setFac_serialnum(int fac_serialnum) {
		Fac_serialnum = fac_serialnum;
	}
	public String getFac_name() {
		return Fac_name;
	}
	public void setFac_name(String fac_name) {
		Fac_name = fac_name;
	}
	public String getFac_address() {
		return Fac_address;
	}
	public void setFac_address(String fac_address) {
		Fac_address = fac_address;
	}
	
	public String getFac_status() {
		return Fac_status;
	}
	public void setFac_status(String fac_status) {
		Fac_status = fac_status;
	}
	public String getFac_category() {
		return Fac_category;
	}
	public void setFac_category(String fac_category) {
		Fac_category = fac_category;
	}
	@Override
	public String toString() {
		return "FacilitiesDTO [Fac_serialnum=" + Fac_serialnum + ", Fac_name=" + Fac_name + ", Fac_address="
				+ Fac_address + ", Fac_status=" + Fac_status + ", Fac_category=" + Fac_category + "]";
	}

	
	
}
