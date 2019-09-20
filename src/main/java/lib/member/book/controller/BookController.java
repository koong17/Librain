package lib.member.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.member.book.model.JsonResponse;
import lib.member.book.service.BookService;

@RequestMapping(value = "/search.do")
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "member/search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse search(@RequestBody
			@RequestParam("searchCtgr") String searchCtgr, @RequestParam("searchWord") String searchWord) {
		System.out.println(searchCtgr + " / " + searchWord);
		JsonResponse res = new JsonResponse();
		System.out.println(bookService.search(bookService.searchCtgr(searchCtgr, searchWord)).toString());
		res.setResult(bookService.search(bookService.searchCtgr(searchCtgr, searchWord)));
		return res;
	}
}
