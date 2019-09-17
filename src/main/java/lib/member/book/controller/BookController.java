package lib.member.book.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookController {

	@RequestMapping("search.do")
	public String Search() {
		return "member/search";
	}
}
