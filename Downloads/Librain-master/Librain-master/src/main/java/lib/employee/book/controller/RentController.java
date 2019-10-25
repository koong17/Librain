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
public class RentController {
	
	@Autowired
	EmpBookService bookService;
	@Autowired
	EmpBookDAO bookDAO;
	
		
	@RequestMapping(value = "/book/rent.do", method = RequestMethod.GET)
	public String rentBookForm(Model model) {
		return "employee/erp/book/empRentBook";
	}
	
	@RequestMapping(value = "/book/rent/return.do", method = RequestMethod.POST)
	public @ResponseBody String returnBook(@RequestBody List<RentalDTO> dto) {
		bookService.returnBook(dto); 
		return  "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value = "/book/rent/rent.do", method = RequestMethod.POST)
	public @ResponseBody String rentBook(@RequestBody List<RentalDTO> dto) {
		bookService.rentBook(dto); 
		return  "{\"result\":\"success\"}";
	}
	
	@RequestMapping(value = "/book/rent/bookCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentBookCheck(@RequestParam("book_num") String book_num) {
		System.out.println(bookService.rentBookCheck(book_num).toString());
		return bookService.rentBookCheck(book_num).toString();
	}
	
	@RequestMapping(value = "/book/rent/memCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentMemCheck(@RequestParam("mem_id") String mem_id) {
		System.out.println(bookService.rentMemCheck(mem_id).toString());
		return bookService.rentMemCheck(mem_id).toString();
	}
	
	@RequestMapping(value = "/book/rent/memBookCheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String rentMemBookCheck(@RequestParam("mem_id") String mem_id) {
		System.out.println(bookService.rentMemBookCheck(mem_id).toString());
		return bookService.rentMemBookCheck(mem_id).toString();
	}
	
}
