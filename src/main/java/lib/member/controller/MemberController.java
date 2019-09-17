package lib.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
