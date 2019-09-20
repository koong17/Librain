package lib.employee.facility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;

@Controller
public class EmployeeController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
	
public String check(Model model) {
	System.out.println("확인");
	List<FacilitiesDTO> list=facilitiesDAO.facSelect(1,1);
	model.addAttribute("list",list);
	return "employee/erp/facility/example";
}

	
	
}
