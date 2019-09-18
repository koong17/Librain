package lib.member.book.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import lib.member.book.model.BookDAO;
import lib.member.book.model.BookDTO;

public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;
	
	@Override
	public List searchCtgr(String searchCtgr, String searchWord) {
		List<BookDTO> list = null;
		
		if(searchCtgr.equals("전체")) {
			list = bookDAO.searchAll(searchWord);
		} else if(searchCtgr.equals("도서명")) {
			list = bookDAO.searchBookName(searchWord);
		} else if(searchCtgr.equals("저자명")) {
			list = bookDAO.searchAuthor(searchWord);
		} else if(searchCtgr.equals("출판사명")) {
			list = bookDAO.searchPub(searchWord);
		}
		return list;
	}
	
	@Override
	public JSONArray search(List<BookDTO> list) {
		JSONArray jArr = new JSONArray();
		JSONObject jObj;
		
		for (int i = 0; i < list.size(); i++) {
			BookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_num", dto.getBook_num());
			jArr.add(jObj);
		}
		return jArr;
	}

}
