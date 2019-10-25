package lib.member.book.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.book.model.Hope_BookDTO;
import lib.member.book.model.MemBookDAO;
import lib.member.book.model.MemBookDTO;
import lib.member.model.MemberDTO;

@Service
public class MemBookServiceImpl implements MemBookService {
	
	@Autowired
	MemBookDAO bookDAO;
	
	@Override
	public JSONArray hopeSelect(int Perpage, int page) {
		int startRowNum = Perpage * page - Perpage;
		int endRowNum = Perpage * page;
		List<Hope_BookDTO> list = new ArrayList<Hope_BookDTO>();
		list = bookDAO.hopeSelect(startRowNum, endRowNum);

		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		
		for (int i = 0; i < list.size(); i++) {
			Hope_BookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("hope_book_num", dto.getHope_book_num());
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_price", dto.getBook_price());
			jObj.put("hope_status", dto.getHope_status());
			jObj.put("hope_input_date", dto.getHope_input_date().toString().substring(0, 10));
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 10));
			jObj.put("book_ISBN", dto.getBook_ISBN());
			jArr.add(jObj);
		}
		return jArr;
	}
	
	@Override
	public void hopeInsert(List<Hope_BookDTO> dto) {
		for (Hope_BookDTO hopeBookDTO : dto) {
			bookDAO.hopeInsertBook(hopeBookDTO);
		}
	}
	
	@Override
	public JSONObject hopeMemCheck(String mem_id) {
		String result = "";
		JSONObject jObj = new JSONObject();
		
		if(bookDAO.hopeMemCheck(mem_id) == 1) result = "success";
		else result = "fail";
		
		jObj.put("result", result);
		
		return jObj;
	}

	@Override
	public JSONArray search(String searchCtgr, String searchWord) {
		List<MemBookDTO> list = new ArrayList<MemBookDTO>();
		
		if(searchCtgr.equals("전체")) {
			System.out.println("전체들어옴 "+searchWord);
			list = bookDAO.searchAll("%" + searchWord + "%");
		} else {
			Map<String, String> parameters = new HashMap<>();
			parameters.put("searchCtgr", searchCtgr);
			parameters.put("searchWord", "%"+searchWord+"%");
			list = bookDAO.searchCtgr(parameters);
		} 
		
		JSONArray jArr = new JSONArray();
		JSONObject jObj;
		
		for (int i = 0; i < list.size(); i++) {
			MemBookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_num", dto.getBook_num());
			jObj.put("book_ctgr_num", dto.getBook_ctgr_num());
			jObj.put("rent", dto.getRent());
			jArr.add(jObj);
		}
		return jArr;
	}
	

	@Override
	public JSONArray newBook(int Perpage, int page) {
		int startRowNum = Perpage * page - Perpage;
		System.out.println(startRowNum);
		int endRowNum = Perpage * page;
		System.out.println(endRowNum);
		
		List<MemBookDTO> list = new ArrayList<MemBookDTO>();
		list = bookDAO.newBook(startRowNum, endRowNum);
		
		JSONArray jArr = new JSONArray();
		JSONObject jObj;
		
		for (int i = 0; i < list.size(); i++) {
			MemBookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_num", dto.getBook_num());
			jArr.add(jObj);
		}
		return jArr;
	}
	
	@Override
	public JSONArray mostRent(int Perpage, int page) {
		int startRowNum = Perpage * page - Perpage;
		System.out.println(startRowNum);
		int endRowNum = Perpage * page;
		System.out.println(endRowNum);
		
		List<MemBookDTO> list = new ArrayList<MemBookDTO>();
		list = bookDAO.mostRent(startRowNum, endRowNum);
		
		JSONArray jArr = new JSONArray();
		JSONObject jObj;
		
		for (int i = 0; i < list.size(); i++) {
			MemBookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_num", dto.getBook_num());
			jArr.add(jObj);
		}
		return jArr;
	}

}
