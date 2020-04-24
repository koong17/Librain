package lib.employee.management.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import lib.employee.mypage.model.CommuteDTO;

public interface EmployeeDAO {
	public List<EmployeeDTO> empSelectAll();
	public void empDelete(EmployeeDTO dto);
	public void empInsert(EmployeeDTO dto);
	public void empUpdate(EmployeeDTO dto);
	public EmployeeDTO empSelectOne(EmployeeDTO dto);
	public EmployeeDTO empSelectPay(EmployeeDTO dto);
	public List<EmployeeDTO> empSelectDept(EmployeeDTO dto);
	public List<CommuteDTO> cmtAdminSelectAll();
	public List<CommuteDTO> cmtAdminSelectOne(CommuteDTO commuteDTO);
	public void cmtUpdate(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSearch(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSearchOne(CommuteDTO commuteDTO);
	public void salInsert(SalaryDTO salaryDTO);
	public List<SalaryDTO> salSelect(SalaryDTO salaryDTO);
	public List<EmployeeDTO> empSearch(Map<String, String> parameters);
	
}
