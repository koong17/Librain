package lib.employee.facilityinspection.model;

import java.sql.Date;

public class FacilitiesInspectionDTO{
	public int FacIn_serialnum;
	public String FacIn_name;
	public String FacIn_address;
	public Date FacIn_Inspection_Date;
	public Date FacIn_Inspection_Due_Date;
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
	public String getFacIn_address() {
		return FacIn_address;
	}
	public void setFacIn_address(String facIn_address) {
		FacIn_address = facIn_address;
	}
	public Date getFacIn_Inspection_Date() {
		return FacIn_Inspection_Date;
	}
	public void setFacIn_Inspection_Date(Date facIn_Inspection_Date) {
		FacIn_Inspection_Date = facIn_Inspection_Date;
	}
	public Date getFacIn_Inspection_Due_Date() {
		return FacIn_Inspection_Due_Date;
	}
	public void setFacIn_Inspection_Due_Date(Date facIn_Inspection_Due_Date) {
		FacIn_Inspection_Due_Date = facIn_Inspection_Due_Date;
	}
	public int getRemainingTime() {
		return RemainingTime;
	}
	public void setRemainingTime(int remainingTime) {
		RemainingTime = remainingTime;
	}
	@Override
	public String toString() {
		return "FacilitiesInspectionDTO [FacIn_serialnum=" + FacIn_serialnum + ", FacIn_name=" + FacIn_name
				+ ", FacIn_address=" + FacIn_address + ", FacIn_Inspection_Date=" + FacIn_Inspection_Date
				+ ", FacIn_Inspection_Due_Date=" + FacIn_Inspection_Due_Date + ", RemainingTime=" + RemainingTime + "]";
	}
	
	
	
	
	
}