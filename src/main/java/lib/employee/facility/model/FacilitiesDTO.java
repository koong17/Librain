package lib.employee.facility.model;

import java.security.Timestamp;

public class FacilitiesDTO {
	private int facSerialnum;
	private String facName;
	private String facAddress;
	private Timestamp facInInspectionDate;
	private int facInSerialnum;
	
	
	public int getFacSerialnum() {
		return facSerialnum;
	}
	public void setFacSerialnum(int facSerialnum) {
		this.facSerialnum = facSerialnum;
	}
	public String getFacName() {
		return facName;
	}
	public void setFacName(String facName) {
		this.facName = facName;
	}
	public String getFacAddress() {
		return facAddress;
	}
	public void setFacAddress(String facAddress) {
		this.facAddress = facAddress;
	}
	public Timestamp getFacInInspectionDate() {
		return facInInspectionDate;
	}
	public void setFacInInspectionDate(Timestamp facInInspectionDate) {
		this.facInInspectionDate = facInInspectionDate;
	}
	public int getFacInSerialnum() {
		return facInSerialnum;
	}
	public void setFacInSerialnum(int facInSerialnum) {
		this.facInSerialnum = facInSerialnum;
	} 
	
	
}
