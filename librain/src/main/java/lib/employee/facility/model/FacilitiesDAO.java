package lib.employee.facility.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FacilitiesDAO {
	public List<FacilitiesDTO> facSelect(@Param(value = "startrownum") int startrownum,@Param(value = "endrownum") int endrownum);
	public void facinsert(FacilitiesDTO dto);

}
