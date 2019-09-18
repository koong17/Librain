package lib.member.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.member.book.model.JsonResponse;
import lib.member.book.service.BookServiceImpl;

@RequestMapping(value = "searh.do")
@Controller
public class BookController {
	
	@Autowired
	BookServiceImpl bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "member/search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse search(@RequestParam("sendData") String searchCtgr, @RequestParam("sendData") String searchWord, BindingResult result) {
		System.out.println(searchCtgr + " / " + searchWord);
		JsonResponse res = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "searchWord", "검색어를 입력해주세요.");
		if(!result.hasErrors()) {
			res.setStatus("SUCCESS");
			res.setResult(bookService.search(bookService.searchCtgr(searchCtgr, searchWord)));
		} else {
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}
		return res;
		
	}
}
