package lib.employee.mypage.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.mypage.model.CommuteDTO;

public interface MypageService {
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO);
	public void empUpdate(EmployeeDTO employeeDTO);
	public void cmtInsert(CommuteDTO commuteDTO);
	public JSONArray cmtSelectAll(CommuteDTO commuteDTO);
	public JSONArray cmtSelectOnOff(CommuteDTO commuteDTO);
}
