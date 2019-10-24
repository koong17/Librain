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

import lib.employee.book.model.BookRentDisDTO;
import lib.employee.book.model.EmpBookDTO;
import lib.employee.book.model.New_BookDTO;
import lib.employee.book.service.EmpBookService;

@Controller
public class DiscardController {
	
	@Autowired
	EmpBookService bookService;
	
	@RequestMapping(value="/book/discardApply.do", method = RequestMethod.GET) 
	public String discardBookForm(Model model) {
		return "employee/erp/book/empDiscardBook";
	}

	@RequestMapping(value = "/book/discardApply.do/readData", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String disForm(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", perPage); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.disSelect()); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO.toString();
	}
	@RequestMapping(value = "/book/discardApply.do/readData2", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String disForm2(@RequestParam int perPage, @RequestParam int page) {
		System.out.println(perPage+"rnqns"+page);
		
		JSONObject resultJO = new JSONObject();
		JSONObject contentJO = new JSONObject();
		JSONObject pageJO = new JSONObject();
		
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", perPage); 
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.disSelectBook()); //내용물 
		resultJO.put("result", true);
		resultJO.put("data",  contentJO);
		
		System.out.println("찍히나 확인");
		
		return  resultJO.toString();
	}
	
	@RequestMapping(value = "/book/discardApply/search.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String search(@RequestParam("book_num") String book_num) {
		return bookService.disSearch(book_num).toString();
	}

	@RequestMapping(value="/book/discardApply/input.do", method = RequestMethod.POST)
	public @ResponseBody String disInsert(@RequestBody List<BookRentDisDTO> dto) {
		bookService.disInsert(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/book/discardApply/delete.do", method = RequestMethod.POST)
	public @ResponseBody String disDelete(@RequestBody List<BookRentDisDTO> dto) {
		bookService.disDelete(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/book/discardApply/deleteBook.do", method = RequestMethod.POST)
	public @ResponseBody String deleteBook(@RequestBody List<EmpBookDTO> dto) {
		System.out.println("deleteBook()");
		bookService.delete(dto);
		return "{\"result\":\"success\"}";
	}
}
