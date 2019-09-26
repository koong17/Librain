package lib.employee.mypage.model;

import java.util.List;

import lib.employee.management.model.EmployeeDTO;

public interface MypageDAO {
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO);
	public void empUpdate(EmployeeDTO employeeDTO);
	public void cmtInsert(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSelectAll(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSelectOnOff(CommuteDTO commuteDTO);
}
