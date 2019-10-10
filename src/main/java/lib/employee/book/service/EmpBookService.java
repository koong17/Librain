package lib.employee.book.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.book.model.EmpBookDTO;
import lib.employee.book.model.RentalDTO;

public interface EmpBookService {
	public List select(int Perpage, int page); //전체 목록 보기
	public List searchCtgr(String searchCtgr, String searchWord); //직원용 도서검색
	public JSONArray search(List<EmpBookDTO> list); //직원용 도서검색 List -> JSONArray
	public void insert(List<EmpBookDTO> dto); //추가
	public void delete(List<EmpBookDTO> dto); //삭제
	public void update(List<EmpBookDTO> dto); //수정
	public JSONObject rentBookCheck(String book_num); //rent 책 검색
	public JSONArray rentMemCheck(String mem_id); //rent 회원 검색
	public JSONArray rentMemBookCheck(String mem_id); //rent 회원에 해당하는 책 검색
	public void rentBook(List<RentalDTO> dto); //책 대여
	public void returnBook(List<RentalDTO> dto); //책 반납
}
