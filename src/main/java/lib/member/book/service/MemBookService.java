package lib.member.book.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.member.book.model.MemBookDTO;

public interface MemBookService {
	public List searchCtgr(String searchCtgr, String searchWord);
	public JSONArray search(List<MemBookDTO> list);
	public JSONArray newBook(int Perpage, int page);
	public JSONArray mostRent(int Perpage, int page);
}