package lib.member.book.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.book.model.Hope_BookDTO;
import lib.member.book.model.MemBookDAO;
import lib.member.book.service.MemBookService;

@Controller
public class MemBookController {
	
	@Autowired
	MemBookService bookService;
	@Autowired
	MemBookDAO bookDAO;
	
	@RequestMapping(value = "/member/book/search.do", method = RequestMethod.GET)
	public String searchForm() {
		return "member/memSearch";
	}
	
	@RequestMapping(value = "/member/book/hope.do", method = RequestMethod.GET)
	public String hopeForm() {
		return "member/memHopeBook";
	}
	
	@RequestMapping(value = "/member/book/hope.do/readData", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String hopeForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", bookDAO.hopeSelectRowNum()); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.hopeSelect(perPage, page)); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO.toString();
	}
	
	@RequestMapping(value="/member/book/hope/input.do", method = RequestMethod.POST)	
	public @ResponseBody String hopeInsert(@RequestBody List<Hope_BookDTO> dto) {
		bookService.hopeInsert(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value = "/member/book/hope/memCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentMemCheck(@RequestParam("mem_id") String mem_id) {
		System.out.println(bookService.hopeMemCheck(mem_id).toString());
		return bookService.hopeMemCheck(mem_id).toString();
	}
	
	@RequestMapping(value = "/member/book/search.do/readData", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String searchForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", 20); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.newBook(perPage, page)); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO.toString();		
	}

	@RequestMapping(value = "/member/book/search.do/readData2", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String searchForm2(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", 20); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.mostRent(perPage, page)); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO.toString();		
	}
	
	
	@RequestMapping(value = "/member/book/search.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String search(@RequestBody
			@RequestParam("searchCtgr") String searchCtgr, @RequestParam("searchWord") String searchWord) {
		System.out.println(searchCtgr + " / " + searchWord);
		return bookService.search(searchCtgr, searchWord).toString();
	}
}
