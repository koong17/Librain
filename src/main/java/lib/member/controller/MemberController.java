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
	
	@GetMapping("/memberSearch.do")
	public String memSearch(Model model) {
		return "member/memberSearch";
	}
	
	@PostMapping("/memberRankUpdate.do")
	public @ResponseBody String memRank(@RequestBody List<MemberDTO> dtos) {
		memberService.memberRankUpdate(dtos);
		return "{\"result\":\"success\"}";
	}

	@GetMapping("/memberRankUpdateForm.do")
	@ResponseBody
	public String memRankForm(MemberDTO dto) {
		System.out.println(dto.getMem_rank());
		return "member/memberRankUpdateForm";
	}

}
