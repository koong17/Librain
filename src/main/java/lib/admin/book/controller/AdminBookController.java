package lib.admin.book.controller;

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

import lib.admin.book.model.BookRentDisDTO;
import lib.admin.book.model.New_BookDTO;
import lib.admin.book.service.AdminBookService;


@Controller
public class AdminBookController {
	
	@Autowired
	AdminBookService bookService;
	
	
	@RequestMapping(value="/admin/book/approve/newBook.do", method = RequestMethod.GET) 
	public String newBookForm(Model model) {
		return "admin/book/newBookList";
	}
	
	@RequestMapping(value = "/admin/book/approve/newBook.do/readData", method = RequestMethod.GET, produces = "application/text; charset=utf8")
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
	
	@RequestMapping(value="/admin/book/approve/newBook/approve.do", method = RequestMethod.POST)
	public @ResponseBody String newApprove(@RequestBody List<New_BookDTO> dto) {
		bookService.newApprove(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/admin/book/approve/newBook/return.do", method = RequestMethod.POST)
	public @ResponseBody String newReturn(@RequestBody List<New_BookDTO> dto) {
		bookService.newReturn(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/admin/book/approve/disBook.do", method = RequestMethod.GET) 
	public String disBookForm(Model model) {
		return "admin/book/disBookList";
	}
	
	@RequestMapping(value = "/admin/book/approve/disBook.do/readData", method = RequestMethod.GET, produces = "application/text; charset=utf8")
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
	
	@RequestMapping(value="/admin/book/approve/disBook/approve.do", method = RequestMethod.POST)
	public @ResponseBody String disApprove(@RequestBody List<BookRentDisDTO> dto) {
		bookService.disApprove(dto);
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value="/admin/book/approve/disBook/return.do", method = RequestMethod.POST)
	public @ResponseBody String disReturn(@RequestBody List<BookRentDisDTO> dto) {
		bookService.disReturn(dto);
		return "{\"result\":\"success\"}";
	}
	
}
