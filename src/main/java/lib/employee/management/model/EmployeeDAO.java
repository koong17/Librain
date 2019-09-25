package lib.employee.management.model;

import java.util.List;

import lib.employee.mypage.model.CommuteDTO;

public interface EmployeeDAO {
	public List<EmployeeDTO> empSelectAll();
	public void empDelete(EmployeeDTO dto);
	public void empInsert(EmployeeDTO dto);
	public List<CommuteDTO> cmtAdminSelectAll();
	public void cmtUpdate(CommuteDTO commuteDTO);
}
