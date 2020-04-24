package lib.employee.book.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lib.employee.book.model.BookRentDisDTO;
import lib.employee.book.model.EmpBookDTO;
import lib.employee.book.model.Hope_BookDTO;
import lib.employee.book.model.New_BookDTO;
import lib.employee.book.model.RentalDTO;

public interface EmpBookService {
	public List select(int Perpage, int page); //전체 목록 보기
	public List searchCtgr(String searchCtgr, String searchWord); //직원용 도서검색
	public JSONArray search(List<EmpBookDTO> list); //직원용 도서검색 List -> JSONArray
	
	public void insert(List<EmpBookDTO> dto); //추가
	public void delete(List<EmpBookDTO> dto); //삭제
	public void update(List<EmpBookDTO> dto); //수정

	public void hopeApprove(List<Hope_BookDTO> dto); //희망 도서 승인 
	public void hopeReturn(List<Hope_BookDTO> dto); //희망 도서 반려
	public void hopeDelete(List<Hope_BookDTO> dto); //일주일 이전 항목 삭제
	public JSONArray hopeSelect(int Perpage, int page); //희망 도서 목록 보기

	public JSONArray newSelect(); //신간 승인 요청 목록 보기
	public JSONArray newSelectBook(); //신간 승인 완료 목록 보기
	public void newInsert(List<New_BookDTO> dto); //신간 추가
	public void newDelete(List<New_BookDTO> dto); //신간 삭제
	public void newUpdate(List<New_BookDTO> dto); //신간 수정

	public JSONObject rentBookCheck(String book_num); //rent 책 검색
	public JSONArray rentMemCheck(String mem_id); //rent 회원 검색
	public JSONArray rentMemBookCheck(String mem_id); //rent 회원에 해당하는 책 검색
	public void rentBook(List<RentalDTO> dto); //책 대여
	public void returnBook(List<RentalDTO> dto); //책 반납

	public JSONObject disSearch(String book_num); //폐기 책 검색
	public JSONArray disSelect(); //폐기 승인 요청 목록 보기
	public JSONArray disSelectBook(); //폐기 승인 요청 목록 보기
	public void disInsert(List<BookRentDisDTO> dto); //폐기 요청 추가
	public void disDelete(List<BookRentDisDTO> dto); //폐기 요청 삭제
}
