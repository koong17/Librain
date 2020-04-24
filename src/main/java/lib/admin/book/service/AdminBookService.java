package lib.admin.book.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.admin.book.model.BookRentDisDTO;
import lib.admin.book.model.New_BookDTO;

public interface AdminBookService {

	public JSONArray newSelect(); //신간 승인 요청 목록 보기
	public void newApprove(List<New_BookDTO> dto); //신간 승인 요청 목록 보기
	public void newReturn(List<New_BookDTO> dto); //신간 승인 요청 목록 보기
	public JSONArray disSelect(); //폐기 승인 요청 목록 보기
	public void disApprove(List<BookRentDisDTO> dto); //폐기 승인 요청 목록 보기
	public void disReturn(List<BookRentDisDTO> dto); //폐기 승인 요청 목록 보기
}
