package lib.employee.management.model;

import java.util.List;

public interface EmployeeDAO {
	public List<EmployeeDTO> empSelectAll();
	public void empDelete(EmployeeDTO ...dtos );
}
