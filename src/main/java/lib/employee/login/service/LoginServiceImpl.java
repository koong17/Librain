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
	public String selectSessionInfo(EmployeeDTO dto){
		String emp_name = dao.selectSessionInfo(dto);
		System.out.println("loginServiceImpl"  + emp_name);
		return emp_name;
	}
	
	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}
}
