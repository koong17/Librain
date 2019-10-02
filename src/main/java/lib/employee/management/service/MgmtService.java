package lib.employee.management.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.mypage.model.CommuteDTO;

public interface MgmtService {
	public JSONArray empSelectAll();
	public void empDelete(List<EmployeeDTO> employeeDTO);
	public void empInsert(EmployeeDTO employeeDTO);
	public JSONArray cmtAdminSelectAll();
	public void cmtUpdate(CommuteDTO commuteDTO);
	public JSONObject empSelectPay(EmployeeDTO employeeDTO);
}
