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
public class EmpBookController {
	
	@Autowired
	EmpBookService bookService;
	@Autowired
	EmpBookDAO bookDAO;
	
	@RequestMapping(value="empDiscardBook.do", method = RequestMethod.GET) 
	public String discardBookForm(Model model) {
		return "employee/book/empDiscardBook";
	}
	@RequestMapping(value="empNewBook.do", method = RequestMethod.GET) 
	public String newBookForm(Model model) {
		return "employee/book/empNewBook";
	}
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
		
		System.out.println("page");
		pageJO.put("page", page);  // 현재 페이지 
		pageJO.put("totalCount", bookDAO.selectRowNum());
		
		System.out.println("content");
		contentJO.put("pagination", pageJO);
		contentJO.put("contents", bookService.search(bookService.select(perPage, page))); //내용물 
		
		System.out.println("result");
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

	@RequestMapping(value="/empBookUpdate.do", method = RequestMethod.POST)
	public @ResponseBody String update(@RequestBody List<EmpBookDTO> dto) {
		bookService.update(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value = "/empNewBook.do/readData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject NewForm(@RequestParam int perPage, @RequestParam int page) {
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
		
		return  resultJO;
	}
	
	@RequestMapping(value="/empNewBook/input.do", method = RequestMethod.POST)
	public @ResponseBody String newInsert(@RequestBody List<New_BookDTO> dto) {
		bookService.newInsert(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/empNewBook/delete.do", method = RequestMethod.POST)
	public @ResponseBody String newDelete(@RequestBody List<New_BookDTO> dto) {
		bookService.newDelete(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/empNewBook/update.do", method = RequestMethod.POST)
	public @ResponseBody String newUpdate(@RequestBody List<New_BookDTO> dto) {
		bookService.newUpdate(dto);
		return "{\"result\":\"success\"}";
	}
		
	@RequestMapping(value = "/empRentBook.do", method = RequestMethod.GET)
	public String rentBookForm(Model model) {
		return "employee/book/empRentBook";
	}
	
	@RequestMapping(value = "/empReturnBook.do", method = RequestMethod.POST)
	public @ResponseBody String returnBook(@RequestBody List<RentalDTO> dto) {
		bookService.returnBook(dto); 
		return  "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value = "/empRentBook.do", method = RequestMethod.POST)
	public @ResponseBody String rentBook(@RequestBody List<RentalDTO> dto) {
		bookService.rentBook(dto); 
		return  "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value = "/empRent/bookCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentBookCheck(@RequestParam("book_num") String book_num) {
		System.out.println(bookService.rentBookCheck(book_num).toString());
		return bookService.rentBookCheck(book_num).toString();
	}
	
	@RequestMapping(value = "/empRent/memCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentMemCheck(@RequestParam("mem_id") String mem_id) {
		System.out.println(bookService.rentMemCheck(mem_id).toString());
		return bookService.rentMemCheck(mem_id).toString();
	}
	
	@RequestMapping(value = "/empRent/memBookCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentMemBookCheck(@RequestParam("mem_id") String mem_id) {
		System.out.println(bookService.rentMemBookCheck(mem_id).toString());
		return bookService.rentMemBookCheck(mem_id).toString();
	}
	
}
