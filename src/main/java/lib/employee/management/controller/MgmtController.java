package lib.employee.management.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;
import lib.employee.management.service.MgmtService;
import lib.employee.mypage.model.CommuteDTO;

@Controller
@RequestMapping("/mgmt")
public class MgmtController {
	
	@Autowired
	MgmtService mgmtService;
	
	@GetMapping("/totalpaylist.do")
	public String totalPayList() {
		return "employee/erp/management/totalPayList";
	}
	
	@PostMapping("/totalpaylist.do")
	public @ResponseBody String totalPayListPro(@RequestBody SalaryDTO salaryDTO) {
		JSONArray ja = mgmtService.salSelect(salaryDTO);
		return ja.toString();
	}
	
	@GetMapping("/totalpay.do")
	public String totalPay() {
		return "employee/erp/management/totalPay";
	}
	
	@PostMapping("/totalpay.do")
	public String totalPayPro(SalaryDTO salaryDTO) {
		mgmtService.salInsert(salaryDTO);
		return "redirect:./totalpay.do";
	}
	
	@PostMapping(value = "/empDept.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String empDept(@RequestBody EmployeeDTO employeeDTO) {
		JSONArray ja = mgmtService.empSelectDept(employeeDTO);
		return ja.toString();
	}
	
	@PostMapping("/totalpay1.do")
	public @ResponseBody String totalPay1(@RequestBody EmployeeDTO employeeDTO) {
		JSONObject jo = mgmtService.empSelectPay(employeeDTO);
		return jo.toString();
	}
	
	@PostMapping(value = "/totalpay2.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String totalPay2(@RequestBody CommuteDTO commuteDTO) {
		JSONArray ja = mgmtService.cmtAdminSelectOne(commuteDTO);
		return ja.toString();
	}
	
	@GetMapping("/emplist2.do")
	public String empList2(Model model) {
		JSONArray ja = mgmtService.empSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/empList2";
	}
	
	@PostMapping(value = "/empDelete.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String empDelete(@RequestBody List<EmployeeDTO> dtos) {
		mgmtService.empDelete(dtos);
		return mgmtService.empSelectAll().toString();
	}
	
	@GetMapping(value = "/empInsert.do")
	public String empInsert() {
		return "employee/erp/management/empInsertForm";
	}
	
	@PostMapping(value = "/empInsert.do")
	public String empInsertPro(@ModelAttribute EmployeeDTO employeeDTO) {
		mgmtService.empInsert(employeeDTO);
		return "employee/erp/management/close";
	}
	
	@GetMapping(value = "/empUpdate.do")
	public String empUpdate(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, Model model) {
		model.addAttribute("employeeDTO", mgmtService.empSelectOne(employeeDTO));
		return "employee/erp/management/empUpdateForm";
	}
	
	@PostMapping(value = "/empUpdate.do")
	public String empUpdatePro(@ModelAttribute EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO);
		mgmtService.empUpdate(employeeDTO);
		return "employee/erp/management/close";
	}
	
	@GetMapping("/emplist.do")
	public String empList(Model model) {
		JSONArray ja = mgmtService.empSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/empList";
	}
	
	@PostMapping(value = "/empSearch.do", produces = "application/text; charset=utf8")
	public @ResponseBody String empSearch(@RequestParam("searchType") String searchType, @RequestParam("searchWord") String searchWord) {
		JSONArray ja = mgmtService.empSearch(searchType, searchWord);
		return ja.toString();
	}
	
	@GetMapping("/cmtlist.do")
	public String cmtList(Model model) {
		JSONArray ja = mgmtService.cmtAdminSelectAll();
		model.addAttribute("gridData", ja);
		return "employee/erp/management/cmtList";
	}
	
	@PostMapping(value = "/cmtlist.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String cmtUpdate(@RequestBody List<CommuteDTO> dtos) {
		for (CommuteDTO commuteDTO : dtos) {
			mgmtService.cmtUpdate(commuteDTO);
		}
		return mgmtService.cmtAdminSelectAll().toString();
	}
	
	@PostMapping(value = "/cmtSearch.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String cmtSearch(@RequestBody CommuteDTO commuteDTO) {
		return mgmtService.cmtSearch(commuteDTO).toString();
	}
	
	@PostMapping(value = "/cmtSearchOne.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody String cmtSearchOne(@RequestBody CommuteDTO commuteDTO) {
		return mgmtService.cmtSearchOne(commuteDTO).toString();
	}
}
