package lib.employee.login.controller;

import java.util.ArrayList;

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
	@RequestMapping("/main.do")
	public String loginAns() {
		return "employee/board/loginResult";
	}
	
	//로그인 처리
	@RequestMapping(value="/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute EmployeeDTO dto, HttpSession session) {
		boolean result = service.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("employee/board/loginResult");
			///emp 이름 가져오기
			String emp_no= (String) session.getAttribute("emp_no");
			mav.addObject("emp_name", service.selectSessionName(emp_no));
		}else {
			mav.setViewName("redirect:login.do");
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
