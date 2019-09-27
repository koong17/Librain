package lib.employee.book.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.book.service.EmpBookService;

@Controller
public class EmpBookController {
	
	@Autowired
	EmpBookService bookService;
	
	@RequestMapping(value = "/empSearch.do", method = RequestMethod.GET)
	public String searchForm(Model model) {
		return "employee/book/empSearch";
	}
	
	@RequestMapping(value = "/empSearch.do/readData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject searchForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
	//	model.addAttribute("gridData", bookService.search(bookService.select()));
	//	JSONObject ja=bookService.search(bookService.select());
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		//select count(*) from 테이블;
		pageJO.put("page",page);  // 현재 페이지 
		pageJO.put("totalCount",100); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.search(bookService.select(perPage, page))); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO;
	}

	@RequestMapping(value = "/empSearch.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String search(@RequestBody
			@RequestParam("searchCtgr") String searchCtgr, @RequestParam("searchWord") String searchWord) {
		System.out.println(searchCtgr + " / " + searchWord);
		System.out.println(bookService.search(bookService.searchCtgr(searchCtgr, searchWord)).toString());
		return bookService.search(bookService.searchCtgr(searchCtgr, searchWord)).toString();
	}
	
	@RequestMapping(value="/empBookInput.do", method = RequestMethod.GET)
	public @ResponseBody String insert(Model model) {
		bookService.insert();
		return "{\"flag\":\"success\"}";
	}
}