package lib.employee.login.service;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import lib.employee.management.model.EmployeeDTO;

public interface LoginService {
	//로그인 체크
	public int loginCheck(EmployeeDTO dto, HttpSession session);
	public int changePwd(EmployeeDTO dto);
	//로그아웃
	public void logout(HttpSession session);
	public JSONArray bookCount();
}
