package lib.admin.book.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.admin.book.model.New_BookDTO;
import lib.admin.book.model.AdminBookDAO;

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
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_price", dto.getBook_price());
			jObj.put("new_status", dto.getNew_status());
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
	
	
}
