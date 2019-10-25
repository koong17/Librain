package lib.employee.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import lib.employee.login.service.LoginService;
import lib.employee.management.model.EmployeeDTO;

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/login.do")
	public String login() {
		return "employee/login/login";
	}
	
	@RequestMapping("/main.do")
	public String loginAns(Model model) {
		model.addAttribute("gridData", service.bookCount());
		return "employee/login/loginResult";
	}
	
	@GetMapping("/changepwd.do")
	public String changePwd(@ModelAttribute EmployeeDTO dto, HttpSession session) {
		return "employee/login/changePwd";
	}
	
	@PostMapping("/changepwd.do")
	public String changePwdPro(@ModelAttribute EmployeeDTO dto, HttpSession session) {
		dto.setEmp_no((String)session.getAttribute("emp_no"));
		service.changePwd(dto);
		return "redirect:main.do";
	}
	
	//로그인 처리
	@RequestMapping(value="/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute EmployeeDTO dto, HttpSession session) {
		int result = service.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		
		if(result == 1) {
			mav.setViewName("redirect:main.do");
		}else if(result == 2) {
			mav.setViewName("redirect:changepwd.do");
		}else {
			mav.setViewName("redirect:login.do?check=f");
		}
		return mav;
	}
	
	//로그아웃 처리
	@RequestMapping("logout.do")	
	public ModelAndView logout(HttpSession session) {
		service.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.do");
		return mav;
	}
}
