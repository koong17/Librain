package lib.employee.mypage.model;

import java.util.List;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;

public interface MypageDAO {
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO);
	public void empUpdate(EmployeeDTO employeeDTO);
	public void cmtInsert(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSelectAll(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSelectOnOff(CommuteDTO commuteDTO);
	public SalaryDTO salSelectOne(SalaryDTO salaryDTO);
	public int empCheckPwd(EmployeeDTO employeeDTO);
	public void empUpdatePwd(EmployeeDTO employeeDTO);
}
