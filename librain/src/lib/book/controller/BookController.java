package lib.book.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.book.service.BookService;

@Controller
@Component
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/search.do")
	public String Search() {
		return "search";
	}
}
