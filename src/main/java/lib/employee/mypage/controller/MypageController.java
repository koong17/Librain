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

import lib.employee.management.service.MgmtServiceImpl;
import lib.employee.mypage.model.CommuteDTO;
import lib.employee.mypage.service.MypageService;

@Controller
@RequestMapping("/commute.do")
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping
	public String list(Model model, HttpSession session) {
		session.setAttribute("emp_num", "1");
		JSONArray ja = mypageService.cmtSelectAll(new CommuteDTO((String)session.getAttribute("emp_num")));
		model.addAttribute("gridData", ja);
		return "employee/mypage/commute";
	}
	
	@PostMapping
	public @ResponseBody String insert(Model model, HttpSession session, @RequestParam("cmt_status")String cmt_status) {
		CommuteDTO commuteDTO = new CommuteDTO((String)session.getAttribute("emp_num"), cmt_status);
		mypageService.cmtInsert(commuteDTO);
		return mypageService.cmtSelectAll(new CommuteDTO((String)session.getAttribute("emp_num"))).toString();
	}
}
