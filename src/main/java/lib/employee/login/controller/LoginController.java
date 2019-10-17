package lib.employee.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "employee/board/login";
	}
	
	//로그인 처리
	@RequestMapping(value="/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute EmployeeDTO dto, HttpSession session) {
		boolean result = service.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/employee/board/loginResult");
		if(result) {
			mav.addObject("msg", "성공");
		}else {
			mav.addObject("msg", "실패");
		}
		
		return mav;
		
		
	}
	//로그아웃 처리
	@RequestMapping("logout.do")	
	public ModelAndView logout(HttpSession session) {
		service.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee/board/login");
		mav.addObject("msg", "로그아웃 성공");
		return mav;
	}
}
