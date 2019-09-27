package lib.employee.management.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.employee.management.service.MgmtService;

@Controller
public class MgmtController {
	
	@Autowired
	MgmtService mgmtService;
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		JSONArray ja = mgmtService.empSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/empList";
	}
}
