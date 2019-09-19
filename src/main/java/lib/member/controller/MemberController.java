package lib.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@GetMapping(value = "/aa.do")
	public String check(Model model) {
		System.out.println("aa");
		List<MemberDTO> list = memberDAO.getMemberList();
		model.addAttribute("list", list);
		return "member/example";
	}
	
	//전체출력
	@GetMapping(value="/list.do")
	public String list(Model model, @RequestParam(value="message", required = false) String message ) {
		System.out.println("list");
		List<MemberDTO> list = memberDAO.getMemberList();
		model.addAttribute("message", message);
		model.addAttribute("list", list);
		return "member/list";
	}
	
	//권한수정
	@GetMapping(value="/rankform.do")
	public ModelAndView rankMemberForm(HttpServletRequest request) throws Exception {
		System.out.println("요기까지");
		ModelAndView mav = new ModelAndView();
		System.out.println(request.getParameter("mem_rank"));
		int mem_rank = new Integer(request.getParameter("mem_rank"));
		System.out.println("여기22");
//		MemberDTO dto2 = new MemberDTO(); dto2.setMem_rank(mem_rank);
//		int dto = memberDAO.rankMember(dto2);
		int dto = memberDAO.rankMember(mem_rank);
		mav.addObject("dto",dto);
		mav.setViewName("member/rank_Update");
		System.out.println("요기까지 타야 마지막");
		return mav;
	}
	
	@RequestMapping("/rank.do")
	public ModelAndView rankMember(int mem_rank) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberDAO.rankMember(mem_rank);
		mav.setViewName("redirect:list.do");
		return mav;
	}
}
