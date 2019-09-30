package lib.employee.book.controller;

import java.util.List;

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

import lib.employee.book.model.EmpBookDAO;
import lib.employee.book.model.EmpBookDTO;
import lib.employee.book.service.EmpBookService;

@Controller
public class EmpBookController {
	
	@Autowired
	EmpBookService bookService;
	@Autowired
	EmpBookDAO bookDAO;
	
	@RequestMapping(value = "/empSearch.do", method = RequestMethod.GET)
	public String searchForm(Model model) {
		return "employee/book/empSearch";
	}
	
	@RequestMapping(value = "/empSearch.do/readData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject searchForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", bookDAO.selectRowNum()); 
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
	
	@RequestMapping(value="/empBookInput.do", method = RequestMethod.POST)
	public @ResponseBody String insert(@RequestBody List<EmpBookDTO> dto) {
		bookService.insert(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/empBookDelete.do", method = RequestMethod.POST)
	public @ResponseBody String delete(@RequestBody List<EmpBookDTO> dto) {
		bookService.delete(dto);
		return "{\"result\":\"success\"}";
	}

	@RequestMapping(value="/empBookUpdate1.do", method = RequestMethod.POST)
	public @ResponseBody String update(@RequestBody List<EmpBookDTO> dto) {
		bookService.update(dto);
		return "{\"result\":\"success\"}";
	}
}
