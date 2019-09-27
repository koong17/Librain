package lib.member.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/memberSearchID.do")
	public @ResponseBody String memSearch(@RequestBody List<MemberDTO> dtos) {
		memberService.memberSearch(dtos);
		return "{\"result\":\"success\"}";
	}
	
	@PostMapping("/memberRankUpdate.do")
	public @ResponseBody String memRank(@RequestBody List<MemberDTO> dtos) {
		memberService.memberRankUpdate(dtos);
		return "{\"result\":\"success\"}";
	}

}
