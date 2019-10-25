package lib.employee.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;
import lib.employee.management.service.MgmtServiceImpl;
import lib.employee.mypage.model.CommuteDTO;
import lib.employee.mypage.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping("/test.do")
	public String test() {
		return "employee/mypage/searchTest";
	}
	@GetMapping("/pay.do")
	public String pay() {
		return "employee/mypage/pay";
	}
	
	@PostMapping("/pay.do")
	public @ResponseBody String payPro(HttpSession session, @RequestBody SalaryDTO salaryDTO) {
		salaryDTO.setEmp_no(Integer.parseInt((String)session.getAttribute("emp_no")));
		JSONObject jo = mypageService.salSelectOne(salaryDTO);
		return jo.toString();
	}
	
	@GetMapping("/info.do")
	public String info(Model model, HttpSession session) {
		EmployeeDTO employeeDTO = new EmployeeDTO((String)session.getAttribute("emp_no"));
		model.addAttribute("employeeDTO", mypageService.empSelectOne(employeeDTO));
		return "employee/mypage/info";
	}
	
	@PostMapping("/info.do")
	public String infoUpdate(Model model, HttpSession session, EmployeeDTO employeeDTO) {
		mypageService.empUpdate(employeeDTO);
		model.addAttribute("employeeDTO", mypageService.empSelectOne(employeeDTO));
		return "employee/mypage/info";
	}
	
	@PostMapping("/updatePwd.do")
	public @ResponseBody String updatePwd(HttpSession session, HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmp_password(req.getParameter("oldPwd"));
		employeeDTO.setEmp_no((String)session.getAttribute("emp_no"));
		
		return String.valueOf(mypageService.empUpdatePwd(employeeDTO, req.getParameter("pwd")));
	}
	
	@GetMapping("/commute.do")
	public String cmtList(Model model, HttpSession session) {
		System.out.println(session.getAttribute("emp_no"));
		CommuteDTO commuteDTO = new CommuteDTO(Integer.parseInt((String)session.getAttribute("emp_no")));
		JSONArray ja = mypageService.cmtSelectAll(commuteDTO);
		model.addAttribute("gridData", ja);
		ja = mypageService.cmtSelectOnOff(commuteDTO);
		model.addAttribute("gridTopData", ja);
		return "employee/mypage/commute";
	}
	
	@PostMapping(value = "/commute.do",produces = "application/text; charset=utf-8")
	public @ResponseBody String cmtInsert(Model model, HttpSession session, @RequestParam("cmt_status")String cmt_status) {
		CommuteDTO commuteDTO = new CommuteDTO(Integer.parseInt((String)session.getAttribute("emp_no")), cmt_status);
		mypageService.cmtInsert(commuteDTO);
		JSONArray ja = new JSONArray();
		ja.add(mypageService.cmtSelectAll(commuteDTO));
		ja.add(mypageService.cmtSelectOnOff(commuteDTO));
		return ja.toString();
	}
}
