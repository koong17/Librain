package lib.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;
import lib.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;
	
	//회원가입
	@GetMapping("/member/join.do")
	public String memberjoin() {
		return "member/memberjoin";
	}

	@PostMapping("/member/join.do")
	public String memberjoin(@ModelAttribute MemberDTO memberDTO) {
		System.out.println("join컨트롤탐");
		memberService.memberjoin(memberDTO);
		return "redirect:../memberMain.jsp";
	}
	
	@RequestMapping(value="/member/memberIDCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String mem_id){
		int count=0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		count = memberService.memberSearchIDCount(mem_id);
		map.put("cnt", count);
		System.out.println("ID체크합니다");
		return map;
	}
	
	//회원로그인
	@GetMapping("/member/login.do")
	public String memberLogin() {
		return "member/memberLogin";
	}
	
	@PostMapping("/member/mypage.do")
	public ModelAndView memberLogin(String mem_id, String mem_pw) {
		ModelAndView mav = new ModelAndView();
		if(memberService.memberCount(mem_id, mem_pw) != 0) {
			mav.addObject("memberDTO", memberService.memberLogin(mem_id, mem_pw));
			//mav.setViewName("redirect:mypage.do?mem_id="+mem_id);
			mav.setViewName("member/memberMyPage");
		} else {
			mav.setViewName("redirect:login.do?check=f");
		}
		return mav;
	}
	
	@PostMapping("/member/update.do")
	public String memberMyPagePro(@ModelAttribute MemberDTO dto) {
		memberService.memberUpdate(dto);
		// return "/mvc/memberMain.jsp"; 나중에 이걸로 바꿀 것
		return "member/memberMyPage";
	}
//	
//	@GetMapping(value="/member/mypage.do")
//	public @ResponseBody String memberMyPage(String mem_id) {
//		
//		//memberService.memberMyPage(dtos);
//		return "{\"result\":\"success\"}";
//	}
	
	@GetMapping("/memberList.do")
	public String memList(Model model) {
		JSONArray ja = memberService.memberSelectAll();
		model.addAttribute("gridData", ja);
		System.out.println("list.do탐");
		return "employee/member/memberList";
	}

	@PostMapping(value="/memberSearch.do", produces = "application/text; charset=utf8")
	public @ResponseBody String memberSearch(@RequestBody @RequestParam("searchCtgr") String searchCtgr,
			@RequestParam("searchWord") String searchWord) {
		if (searchCtgr.equals("전체")) {
			return memberService.memberSearch(memberService.memberSearchCtgr(searchCtgr, searchWord)).toString();
		} else if (searchCtgr.equals("회원 ID")) {
			return memberService.memberSearch(memberService.memberSearchID(searchWord)).toString();
		} else if (searchCtgr.equals("회원명")) {
			return memberService.memberSearch(memberService.memberSearchName(searchWord)).toString();
		} else
			return null;
	}

	@PostMapping(value="/memberRankUpdate.do", produces = "application/text; charset=utf8")
	public @ResponseBody String memRank(@RequestBody List<MemberDTO> dtos) {
		memberService.memberRankUpdate(dtos);
		return "{\"result\":\"success\"}";
	}
	
	@GetMapping(value="/memberList.do/readData", produces = "application/text; charset=utf8")
	@ResponseBody
	public String memberListForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page); //현재페이지
		pageJO.put("totalCount", memberDAO.selectRowNum());
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", memberService.memberSearch(memberService.select(perPage, page)));
		resultJO.put("result", true);
		resultJO.put("data", contentJO);
		
		System.out.println("list/readdata탐");
		
		return resultJO.toString();
	}
}
