package lib.employee.login.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.login.model.LoginDAO;
import lib.employee.management.model.EmployeeDTO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO dao;
	
	@Override
	public boolean loginCheck(EmployeeDTO dto, HttpSession session) {
		boolean result = dao.loginCheck(dto);
		if(result == true) {
			session.setAttribute("emp_no",  dto.getEmp_no());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}
	
	@Override
	public String selectSessionName(String emp_no) {
		String emp_name = dao.selectSessionName(emp_no);
		return emp_name;
	}
	
	@Override
	public String selectSessionAuth(String emp_no) {
		String emp_auth = dao.selectSessionAuth(emp_no);
		return emp_auth;
	}
}
