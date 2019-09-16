package lib.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.employee.management.model.EmployeeDAO;
import lib.employee.management.model.EmployeeDTO;

@Controller
public class ManagementController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		List<EmployeeDTO> list = employeeDAO.select();
		model.addAttribute("list", list);
		return "employee/erp/management/ex";
	}
}
