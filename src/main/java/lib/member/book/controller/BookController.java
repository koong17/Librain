package lib.member.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "searh.do")
@Controller
public class BookController {

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "member/search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String search() {
		
	}
}
