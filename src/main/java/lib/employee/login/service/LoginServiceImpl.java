package lib.employee.login.service;

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
			dto = dao.loginInfo(dto);
			session.setAttribute("emp_no",  dto.getEmp_no());
			session.setAttribute("emp_name",  dto.getEmp_name());
			session.setAttribute("emp_position",  dto.getEmp_position());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}
	
}
