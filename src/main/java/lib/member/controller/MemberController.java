package lib.member.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.member.model.MemberDTO;
import lib.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/memberList.do")
	public String memList(Model model) {
		JSONArray ja = memberService.memberSelectAll();
		model.addAttribute("gridData",ja);
		return "member/memberList";
	}
	
	@PostMapping("/memberSearch.do")
	public @ResponseBody String memberSearch(@RequestBody
			@RequestParam("searchCtgr") String searchCtgr, @RequestParam("searchWord") String searchWord) {
		System.out.println("컨트롤러 탐");
		System.out.println(searchCtgr + " / " + searchWord);
		return memberService.memberSearch(memberService.memberSearchCtgr(searchCtgr, searchWord)).toString();
	}
	
	@PostMapping("/memberRankUpdate.do")
	public @ResponseBody String memRank(@RequestBody List<MemberDTO> dtos) {
		memberService.memberRankUpdate(dtos);
		return "{\"result\":\"success\"}";
	}

}
