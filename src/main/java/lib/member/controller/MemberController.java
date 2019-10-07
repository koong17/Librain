package lib.member.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;
import lib.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;

	@GetMapping("/memberList.do")
	public String memList(Model model) {
		JSONArray ja = memberService.memberSelectAll();
		model.addAttribute("gridData", ja);
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
	
	@GetMapping(value="/memberList.do/readData")
	@ResponseBody
	public JSONObject memberListForm(@RequestParam int perPage, @RequestParam int page) {
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
		
		System.out.println("^ㅁ^");
		
		return resultJO;
	}
}
