package lib.member.book.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.member.book.model.MemBookDAO;
import lib.member.book.model.MemBookDTO;

@Service
public class MemBookServiceImpl implements MemBookService {
	
	@Autowired
	MemBookDAO bookDAO;
	
	@Override
	public List searchCtgr(String searchCtgr, String searchWord) {
		List<MemBookDTO> list = new ArrayList<MemBookDTO>();
		
		if(searchCtgr.equals("전체")) {
			System.out.println("전체들어옴 "+searchWord);
			list = bookDAO.searchAll(searchWord);
			for (MemBookDTO bookDTO : list) {
				System.out.println(bookDTO.getBook_name()+" / ");
			}
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
	public JSONArray search(List<MemBookDTO> list) {
		JSONArray jArr = new JSONArray();
		JSONObject jObj;
		
		for (int i = 0; i < list.size(); i++) {
			MemBookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_num", dto.getBook_num());
			jObj.put("rent", dto.getRent());
			jArr.add(jObj);
		}
		return jArr;
	}

}
