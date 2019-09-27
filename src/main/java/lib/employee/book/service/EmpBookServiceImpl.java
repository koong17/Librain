package lib.employee.book.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lib.employee.book.model.EmpBookDAO;
import lib.employee.book.model.EmpBookDTO;

@Service
public class EmpBookServiceImpl implements EmpBookService {
	
	@Autowired
	EmpBookDAO bookDAO;
	
	@Override
	public List select(int Perpage, int page) {

		 //
		//Perpage 한번에 보여줄 게시물
		//int page  현재페이지 초기로딩시 page=1
		
//		wherew rownum r>startnu and endnom>rownum;
//		Perpage*page-Perpage 
//		   5    1   - 5   0
//		   5     2   -5   5   
//		   
//		   
//		   Perpage*page
		int startRowNum = Perpage * page - Perpage;
		int endRowNum = Perpage * page;
		List<EmpBookDTO> list = new ArrayList<EmpBookDTO>();
		list = bookDAO.select(startRowNum, endRowNum);
		return list;
	}

	@Override
	public List searchCtgr(String searchCtgr, String searchWord) {
		List<EmpBookDTO> list = new ArrayList<EmpBookDTO>();
		
		if(searchCtgr.equals("전체")) {
			list = bookDAO.searchAll(searchWord);
//			System.out.println("전체들어옴 "+searchWord);
//			for (EmpBookDTO bookDTO : list) {
//				System.out.println(bookDTO.getBook_name()+" / ");
//			}
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
	public JSONArray search(List<EmpBookDTO> list) {
		System.out.println("ListToJArr");
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		
		for (int i = 0; i < list.size(); i++) {
			EmpBookDTO dto = list.get(i);
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
			jArr.add(jObj);
		}
		return jArr;
	}

	@Override
	public void insert(List<EmpBookDTO> dto) {
		for (EmpBookDTO empBookDTO : dto) {
			bookDAO.insertBook(empBookDTO);
		}
	}

	@Override
	public void delete(List<EmpBookDTO> dto) {
		for (EmpBookDTO empBookDTO : dto) {
			bookDAO.deleteBook(empBookDTO);
		}
	}

	@Override
	public void update(List<EmpBookDTO> dto) {
		for (EmpBookDTO empBookDTO : dto) {
			bookDAO.updateBook(empBookDTO);
		}
	}
	
	
	
	
}
