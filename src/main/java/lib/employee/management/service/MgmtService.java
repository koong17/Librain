package lib.employee.management.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;
import lib.employee.mypage.model.CommuteDTO;

public interface MgmtService {
	public JSONArray empSelectAll();
	public void empDelete(List<EmployeeDTO> employeeDTO);
	public void empInsert(EmployeeDTO employeeDTO);
	public void empUpdate(EmployeeDTO employeeDTO);
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO);
	public JSONArray empSelectDept(EmployeeDTO employeeDTO);
	public JSONArray cmtAdminSelectAll();
	public JSONArray cmtAdminSelectOne(CommuteDTO commuteDTO);
	public void cmtUpdate(CommuteDTO commuteDTO);
	public JSONArray cmtSearch(CommuteDTO commuteDTO);
	public JSONArray cmtSearchOne(CommuteDTO commuteDTO);
	public JSONObject empSelectPay(EmployeeDTO employeeDTO);
	public void salInsert(SalaryDTO salaryDTO);
	public JSONArray salSelect(SalaryDTO salaryDTO);
	public JSONArray empSearch(String searchType, String searchWord);
}
