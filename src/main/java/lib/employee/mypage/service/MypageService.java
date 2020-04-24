package lib.employee.mypage.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;
import lib.employee.mypage.model.CommuteDTO;

public interface MypageService {
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO);
	public void empUpdate(EmployeeDTO employeeDTO);
	public int empUpdatePwd(EmployeeDTO employeeDTO, String pwd);
	public void cmtInsert(CommuteDTO commuteDTO);
	public JSONArray cmtSelectAll(CommuteDTO commuteDTO);
	public JSONArray cmtSelectOnOff(CommuteDTO commuteDTO);
	public JSONObject salSelectOne(SalaryDTO salaryDTO);
}
