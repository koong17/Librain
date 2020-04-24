package lib.employee.facility.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FacilitiesDAO {
	public List<FacilitiesDTO> facSelect(@Param(value = "startrownum") int startrownum,@Param(value = "endrownum") int endrownum);
	public List<FacilitiesDTO> facRepareSelect(@Param(value = "startrownum") int startrownum,@Param(value = "endrownum") int endrownum);
	
	public int factotalcount();
	public void facupdate(FacilitiesDTO dto);
	public void facupdaterepair(FacilitiesDTO dto);
	public void facupdaterepaircomplete(FacilitiesDTO dto);

	public void facinsert(FacilitiesDTO dto);
	public void facdelete(FacilitiesDTO dto);
}
