package lib.member.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.member.book.model.BookDTO;
import lib.member.book.model.JsonResponse;

@RequestMapping(value = "searh.do")
@Controller
public class BookController {

	@RequestMapping(method = RequestMethod.GET)
	public String searchForm() {
		return "member/search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse search(@RequestParam("sendData") String searchCtgr, @RequestParam("sendData") String searchWord, BindingResult result) {
		System.out.println(searchCtgr + " / " + searchWord);
		if(searchCtgr.equals("전체")) {
			
		} else if(searchCtgr.equals("도서명")) {
			
		} else if(searchCtgr.equals("저자명")) {
			
		} else if(searchCtgr.equals("출판사명")) {
			
		}
		return null;
		
	}
}
