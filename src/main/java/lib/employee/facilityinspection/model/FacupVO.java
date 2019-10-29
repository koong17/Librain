package lib.employee.facilityinspection.model;

import java.util.List;

public class FacupVO {
	String facin_address;
	String FacIn_serialnum;
	public String getFacin_address() {
		return facin_address;
	}
	public void setFacin_address(String facin_address) {
		this.facin_address = facin_address;
	}
	public String getFacIn_serialnum() {
		return FacIn_serialnum;
	}
	public void setFacIn_serialnum(String facIn_serialnum) {
		FacIn_serialnum = facIn_serialnum;
	}
	@Override
	public String toString() {
		return "FacupVO [facin_address=" + facin_address + ", FacIn_serialnum=" + FacIn_serialnum + "]";
	}
	
	
}
