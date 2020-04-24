package lib.employee.facilityinspection.model;

public class FacinVO {
	String facfacin_name;
	String facin_address;
	String f_cycle;
	
	public String getFacin_address() {
		return facin_address;
	}
	public void setFacin_address(String facin_address) {
		this.facin_address = facin_address;
	}
	public String getF_cycle() {
		return f_cycle;
	}
	public void setF_cycle(String f_cycle) {
		this.f_cycle = f_cycle;
	}
	public String getFacfacin_name() {
		return facfacin_name;
	}
	public void setFacfacin_name(String facfacin_name) {
		this.facfacin_name = facfacin_name;
	}
	@Override
	public String toString() {
		return "FacinVO [facfacin_name=" + facfacin_name + ", facin_address=" + facin_address + ", f_cycle=" + f_cycle
				+ "]";
	}
	
	


}
