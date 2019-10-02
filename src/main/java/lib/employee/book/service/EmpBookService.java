package lib.employee.book.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lib.employee.book.model.EmpBookDTO;

public interface EmpBookService {
	public List select(int Perpage, int page); //전체 목록 보기
	public List searchCtgr(String searchCtgr, String searchWord); //직원용 도서검색
	public JSONArray search(List<EmpBookDTO> list); //직원용 도서검색 List -> JSONArray
	public void insert(List<EmpBookDTO> dto); //추가
	public void delete(List<EmpBookDTO> dto); //삭제
	public void update(List<EmpBookDTO> dto); //수정
	public JSONArray rentBookCheck(String book_num); //rent 책 검색
}
