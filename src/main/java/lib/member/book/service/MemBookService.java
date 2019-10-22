package lib.member.book.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.employee.book.model.New_BookDTO;
import lib.member.book.model.MemBookDTO;

public interface MemBookService {
	public void newInsert(List<New_BookDTO> dto); //신간 추가
	public List searchCtgr(String searchCtgr, String searchWord);
	public JSONArray search(List<MemBookDTO> list);
	public JSONArray newBook(int Perpage, int page);
	public JSONArray mostRent(int Perpage, int page);
}
