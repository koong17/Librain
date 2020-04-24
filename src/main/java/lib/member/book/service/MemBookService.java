package lib.member.book.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.book.model.Hope_BookDTO;
import lib.member.book.model.MemBookDTO;

public interface MemBookService {
	public JSONArray hopeSelect(int Perpage, int page); //희망 도서 목록 보기
	public void hopeInsert(List<Hope_BookDTO> dto); //희망도서 추가
	public JSONObject hopeMemCheck(String mem_id); //hope 회원 검색
	
	public JSONArray search(String searchCtgr, String searchWord); //검색
	
	public JSONArray newBook(int Perpage, int page); //신간 목록
	public JSONArray mostRent(int Perpage, int page); //최다 대여 목록
}
