package lib.employee.book.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lib.employee.book.model.Discard_BookDTO;
import lib.employee.book.model.EmpBookDAO;
import lib.employee.book.model.EmpBookDTO;
import lib.employee.book.model.New_BookDTO;
import lib.employee.book.model.RentalDTO;
import lib.employee.book.service.EmpBookService;

@Controller
public class NewController {
	
	@Autowired
	EmpBookService bookService;
	@Autowired
	EmpBookDAO bookDAO;
	
	@RequestMapping(value="book/newApply.do", method = RequestMethod.GET) 
	public String newBookForm(Model model) {
		return "employee/book/empNewBook";
	}
	
	@RequestMapping(value = "/book/newApply.do/readData", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String NewForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", perPage); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.newSelect()); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO.toString();
	}
	
	@RequestMapping(value="/book/newApply/input.do", method = RequestMethod.POST)
	public @ResponseBody String newInsert(@RequestBody List<New_BookDTO> dto) {
		bookService.newInsert(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/book/newApply/delete.do", method = RequestMethod.POST)
	public @ResponseBody String newDelete(@RequestBody List<New_BookDTO> dto) {
		bookService.newDelete(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/book/newApply/update.do", method = RequestMethod.POST)
	public @ResponseBody String newUpdate(@RequestBody List<New_BookDTO> dto) {
		bookService.newUpdate(dto);
		return "{\"result\":\"success\"}";
	}
	@RequestMapping(value="/book/newApply/inputBook.do", method = RequestMethod.POST)
	public @ResponseBody String inputBook(@RequestBody List<EmpBookDTO> dto) {
		System.out.println("inputBook()");
		bookService.insert(dto);
		return "{\"result\":\"success\"}";
	}
}
