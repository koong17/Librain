package lib.employee.management.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.service.MgmtService;
import lib.employee.mypage.model.CommuteDTO;

@Controller
@RequestMapping("/mgmt")
public class MgmtController {
	
	@Autowired
	MgmtService mgmtService;
	
	@RequestMapping(value = "/totalpay.do")
	public String totalPay(Model model) {
		//model.addAttribute("gridData", mgmtService.cmtAdminSelectOne());
		return "employee/erp/management/totalPay";
	}
	@RequestMapping(value = "/totalpay.do", method = RequestMethod.POST)
	public @ResponseBody String totalPayPro(@RequestBody EmployeeDTO employeeDTO) {
//		System.out.println((String)param.get("emp_name")+param.get("emp_dept_code"));
//		EmployeeDTO employeeDTO = new EmployeeDTO((String)param.get("emp_name"), (String)param.get("emp_dept_code"));
		
		JSONObject emp_basic_pay = mgmtService.empSelectPay(employeeDTO);
		return mgmtService.empSelectPay(employeeDTO).toString();
	}
	
	@RequestMapping("/emplist2.do")
	public String empList2(Model model) {
		JSONArray ja = mgmtService.empSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/empList2";
	}
	
	@RequestMapping(value = "/empDelete.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String empDelete(@RequestBody List<EmployeeDTO> dtos) {
		mgmtService.empDelete(dtos);
		return mgmtService.empSelectAll().toString();
	}
	
	@RequestMapping(value = "/empInsert.do")
	public String empInsert() {
		return "employee/erp/management/empInsertForm";
	}
	
	@RequestMapping(value = "/empInsert.do", method = RequestMethod.POST)
	public String empInsertPro(@ModelAttribute EmployeeDTO employeeDTO) {
		mgmtService.empInsert(employeeDTO);
		return "employee/erp/management/close";
	}
	
	@RequestMapping("/emplist.do")
	public String empList(Model model) {
		JSONArray ja = mgmtService.empSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/empList";
	}
	
	@RequestMapping(value = "/cmtlist.do", method = RequestMethod.GET)
	public String cmtList(Model model) {
		JSONArray ja = mgmtService.cmtAdminSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/cmtList";
	}
	
	@RequestMapping(value = "/cmtlist.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String cmtUpdate(@RequestBody List<CommuteDTO> dtos) {
		for (CommuteDTO commuteDTO : dtos) {
			mgmtService.cmtUpdate(commuteDTO);
		}
		return mgmtService.cmtAdminSelectAll().toString();
	}
}
