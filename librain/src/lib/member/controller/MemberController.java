package lib.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;

@Controller
public class MemberController {

	@Resource
	private MemberDAO memberDAO;
	
	@RequestMapping("/joinForm.jsp")
	public String joinForm(MemberDTO dto) {
		memberDAO.insertMember(dto);
		return "join";
	}
	
	@RequestMapping("/join.jsp")
	public String join() {
		return "join";
	}
}
