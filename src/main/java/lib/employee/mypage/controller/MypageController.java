package lib.employee.mypage.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.service.MgmtServiceImpl;
import lib.employee.mypage.model.CommuteDTO;
import lib.employee.mypage.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping("/info.do")
	public String info(Model model, HttpSession session) {
		session.setAttribute("emp_no", "1000001");
		EmployeeDTO employeeDTO = new EmployeeDTO((String)session.getAttribute("emp_no"));
		model.addAttribute("employeeDTO", mypageService.empSelectOne(employeeDTO));
		return "employee/mypage/info";
	}
	
	@PostMapping("/info.do")
	public String infoUpdate(HttpSession session, EmployeeDTO employeeDTO) {
		mypageService.empUpdate(employeeDTO);
		return "employee/mypage/info";
	}
	
	@GetMapping("/commute.do")
	public String cmtList(Model model, HttpSession session) {
		session.setAttribute("emp_no", "1000001");
		CommuteDTO commuteDTO = new CommuteDTO((String)session.getAttribute("emp_no"));
		JSONArray ja = mypageService.cmtSelectAll(commuteDTO);
		model.addAttribute("gridData", ja);
		ja = mypageService.cmtSelectOnOff(commuteDTO);
		model.addAttribute("gridTopData", ja);
		return "employee/mypage/commute";
	}
	
	@PostMapping(value = "/commute.do",produces = "application/text; charset=utf-8")
	public @ResponseBody String cmtInsert(Model model, HttpSession session, @RequestParam("cmt_status")String cmt_status) {
		String emp_num = (String)session.getAttribute("emp_num");
		CommuteDTO commuteDTO = new CommuteDTO(emp_num, cmt_status);
		mypageService.cmtInsert(commuteDTO);
		JSONArray ja = new JSONArray();
		ja.add(mypageService.cmtSelectAll(commuteDTO));
		ja.add(mypageService.cmtSelectOnOff(commuteDTO));
		return ja.toString();
	}
}
