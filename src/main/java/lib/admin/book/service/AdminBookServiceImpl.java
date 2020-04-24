package lib.admin.book.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.admin.book.model.AdminBookDAO;
import lib.admin.book.model.BookRentDisDTO;
import lib.admin.book.model.New_BookDTO;

@Service
public class AdminBookServiceImpl implements AdminBookService {
	@Autowired
	AdminBookDAO bookDAO;
	
	@Override
	public JSONArray newSelect() {
		
		List<New_BookDTO> list = new ArrayList<New_BookDTO>();
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		list = bookDAO.newSelect();
		
		for (int i = 0; i < list.size(); i++) {
			New_BookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("new_book_num", dto.getNew_book_num());
			jObj.put("book_price", dto.getBook_price());
			jObj.put("new_status", dto.getNew_status());
			jObj.put("bookCnt", dto.getBookCnt());
			jObj.put("new_input_date", dto.getNew_input_date().toString().substring(0, 10));
			jArr.add(jObj);
		}
		return jArr;
	}

	@Override
	public void newApprove(List<New_BookDTO> dto) {
		for (New_BookDTO newBookDTO : dto) {
			bookDAO.newApprove(newBookDTO);
		}
	}

	@Override
	public void newReturn(List<New_BookDTO> dto) {
		for (New_BookDTO newBookDTO : dto) {
			bookDAO.newReturn(newBookDTO);
		}
	}
	
	@Override
	public JSONArray disSelect() {
		
		List<BookRentDisDTO> list = new ArrayList<BookRentDisDTO>();
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		list = bookDAO.disSelect();
		
		for (int i = 0; i < list.size(); i++) {
			BookRentDisDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj = new JSONObject();
			jObj.put("book_num", dto.getBook_num());
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 10));
			jObj.put("book_ISBN", dto.getBook_ISBN());
			jObj.put("book_apdx_status", dto.getBook_apdx_status());
			jObj.put("book_ctgr_num", dto.getBook_ctgr_num());
			jObj.put("book_rsrv_status", dto.getBook_rsrv_status());
			jObj.put("rent", dto.getRent());
			jObj.put("book_input_date", dto.getBook_input_date().toString().substring(0, 10));
			if(dto.getDis_book_num() != 0)
				jObj.put("dis_book_num", dto.getDis_book_num());
			if(dto.getDis_input_date() != null)
				jObj.put("dis_input_date", dto.getDis_input_date().toString().substring(0, 10));
			jObj.put("dis_status", dto.getDis_status());
			
			jArr.add(jObj);
		}
		return jArr;
	}
	
	@Override
	public void disApprove(List<BookRentDisDTO> dto) {
		for (BookRentDisDTO bookRentDisDTO : dto) {
			bookDAO.disApprove(bookRentDisDTO);
		}
	}
	
	@Override
	public void disReturn(List<BookRentDisDTO> dto) {
		for (BookRentDisDTO bookRentDisDTO : dto) {
			bookDAO.disReturn(bookRentDisDTO);
		}
	}
	
	
}
