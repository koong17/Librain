package lib.employee.facilityinspection.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FacilitiesInspectionDAO {
	public List<FacilitiesInspectionDTO> facinselect(@Param(value = "startrownum") int startrownum,@Param(value = "endrownum") int endrownum);
	public int facintotalcount();
}
