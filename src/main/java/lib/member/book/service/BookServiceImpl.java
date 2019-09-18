package lib.member.book.service;

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

	public JSONArray search(List list) {
		JSONArray jArray = new JSONArray();
		JSONObject jObject;
//		List<BookDTO> list = bookDAO.search();
		for (int i = 0; i < list.length; i++) {
//			jObject = new JSONObject();
//			jObject.put();
//			jArray.add(jObject);
//		}
		return jArray;
	}

}
