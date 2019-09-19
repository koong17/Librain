package lib.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@GetMapping(value = "/aa.do")
	public String check(Model model) {
		List<MemberDTO> list = memberDAO.getMemberList();
		model.addAttribute("list", list);
		return "member/example";
	}
	
	//전체출력
	
	//권한수정
	@GetMapping(value="member/rankform.do")
	public ModelAndView rankMemberForm(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		int mem_rank = new Integer(request.getParameter("mem_rank"));
		MemberDTO dto = memberDAO.getMember(mem_rank);
		mav.addObject("dto",dto);
		mav.setViewName("rankUpdate");
		return mav;
	}
	
	@RequestMapping("member/rank.do")
	public ModelAndView rankMember(MemberDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberDAO.rankMember(dto);
		mav.setViewName("redirect:list.do");
		return mav;
	}
}
