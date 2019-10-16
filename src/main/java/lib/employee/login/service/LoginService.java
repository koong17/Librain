package lib.employee.login.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import lib.employee.management.model.EmployeeDTO;

public interface LoginService {
	//로그인 체크
	public boolean loginCheck(EmployeeDTO dto, HttpSession session);
	//로그아웃
	public void logout(HttpSession session);
	
	public ArrayList<EmployeeDTO> selectSessionInfo(EmployeeDTO dto);
}
