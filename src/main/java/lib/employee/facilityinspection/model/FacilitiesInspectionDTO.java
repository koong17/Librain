package lib.employee.facilityinspection.model;

import java.sql.Date;

public class FacilitiesInspectionDTO{
	public int FacIn_serialnum;
	public String FacIn_name;
	public String facin_address;
	public String FacIn_Inspection_Date;
	public String FacIn_Inspection_Due_Date;
	public int RemainingTime;
	public int getFacIn_serialnum() {
		return FacIn_serialnum;
	}
	public void setFacIn_serialnum(int facIn_serialnum) {
		FacIn_serialnum = facIn_serialnum;
	}
	public String getFacIn_name() {
		return FacIn_name;
	}
	public void setFacIn_name(String facIn_name) {
		FacIn_name = facIn_name;
	}
	
	
	public String getFacin_address() {
		return facin_address;
	}
	public void setFacin_address(String facin_address) {
		this.facin_address = facin_address;
	}
	public String getFacIn_Inspection_Date() {
		return FacIn_Inspection_Date;
	}
	public void setFacIn_Inspection_Date(String facIn_Inspection_Date) {
		FacIn_Inspection_Date = facIn_Inspection_Date;
	}
	public String getFacIn_Inspection_Due_Date() {
		return FacIn_Inspection_Due_Date;
	}
	public void setFacIn_Inspection_Due_Date(String facIn_Inspection_Due_Date) {
		FacIn_Inspection_Due_Date = facIn_Inspection_Due_Date;
	}
	public int getRemainingTime() {
		return RemainingTime;
	}
	public void setRemainingTime(int remainingTime) {
		RemainingTime = remainingTime;
	}
	
	
	
	
}