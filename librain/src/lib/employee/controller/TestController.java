package lib.employee.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.employee.model.EmployeeDAO;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@RequestMapping("/index.do")
	public String insert() {
		EmployeeDAO empDAO = sqlsession.getMapper(EmployeeDAO.class);
		empDAO.insert();
		return "test";
	}
}
