package lib.employee.management.model;

import java.util.List;

import lib.employee.mypage.model.CommuteDTO;

public interface EmployeeDAO {
	public List<EmployeeDTO> empSelectAll();
	public void empDelete(EmployeeDTO dto);
	public void empInsert(EmployeeDTO dto);
	public EmployeeDTO empSelectPay(EmployeeDTO dto);
	public List<CommuteDTO> cmtAdminSelectAll();
	public List<CommuteDTO> cmtAdminSelectOne(CommuteDTO commuteDTO);
	public void cmtUpdate(CommuteDTO commuteDTO);
	public void salInsert(SalaryDTO salaryDTO);
}
