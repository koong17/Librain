package lib.employee.facilityinspection.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FacilitiesInspectionDAO {
	public List<FacilitiesDTO> facSelect(@Param(value = "startrownum") int startrownum,@Param(value = "endrownum") int endrownum);
	
}
