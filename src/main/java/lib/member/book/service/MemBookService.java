package lib.member.book.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.book.model.Hope_BookDTO;
import lib.member.book.model.MemBookDTO;

public interface MemBookService {
	public void hopeInsert(List<Hope_BookDTO> dto); //희망도서 추가
	public JSONObject hopeMemCheck(String mem_id); //hope 회원 검색
	public List searchCtgr(String searchCtgr, String searchWord);
	public JSONArray search(List<MemBookDTO> list);
	public JSONArray newBook(int Perpage, int page);
	public JSONArray mostRent(int Perpage, int page);
}
