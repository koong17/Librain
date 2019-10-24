package lib.employee.facilityinspection.model;

import java.util.List;
import java.util.Map;

public interface FacilitiesInspectionDAO {
	public List<FacilitiesInspectionDTO> facinselect();
	public int facintotalcount();
	public void facininsertprocedure(FacinVO vo);
	public void facinupdateprocedure(FacilitiesInspectionDTO dto);
	public void facindelete(FacilitiesInspectionDTO dto);
}
