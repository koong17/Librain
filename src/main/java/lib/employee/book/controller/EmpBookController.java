package lib.employee.book.controller;

import org.json.simple.JSONArray;
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
		model.addAttribute("gridData", bookService.search(bookService.select()));
		return "employee/book/empSearch";
	}
	
	@RequestMapping(value = "/empSearch.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String search(@RequestBody
			@RequestParam("searchCtgr") String searchCtgr, @RequestParam("searchWord") String searchWord) {
		System.out.println(searchCtgr + " / " + searchWord);
		System.out.println(bookService.search(bookService.searchCtgr(searchCtgr, searchWord)).toString());
		return bookService.search(bookService.searchCtgr(searchCtgr, searchWord)).toString();
	}
	
	@RequestMapping(value = "/empBookInput.do", method = RequestMethod.GET)
	public @ResponseBody String search(Model model) {
		return "employee/book/empSearch";
	}
}
