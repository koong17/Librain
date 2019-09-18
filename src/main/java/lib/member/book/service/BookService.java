package lib.member.book.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.member.book.model.BookDTO;

public interface BookService {
	public List searchCtgr(String searchCtgr, String searchWord);
	public JSONArray search(List<BookDTO> list);
}
