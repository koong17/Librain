package lib.member.book.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.member.book.service.MemBookService;

@RequestMapping(value = "/memSearch.do")
@Controller
public class MemBookController {
	
	@Autowired
	MemBookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "member/memSearch";
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String search(@RequestBody
			@RequestParam("searchCtgr") String searchCtgr, @RequestParam("searchWord") String searchWord) {
		System.out.println(searchCtgr + " / " + searchWord);
		return bookService.search(bookService.searchCtgr(searchCtgr, searchWord)).toString();
	}
}
