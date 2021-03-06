package lib.employee.book.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.book.model.BookRentDisDTO;
import lib.employee.book.model.EmpBookDAO;
import lib.employee.book.model.EmpBookDTO;
import lib.employee.book.model.Hope_BookDTO;
import lib.employee.book.model.New_BookDTO;
import lib.employee.book.model.RentalDTO;
import lib.member.model.MemberDTO;

@Service
public class EmpBookServiceImpl implements EmpBookService {
	
	@Autowired
	EmpBookDAO bookDAO;
	
	
	@Override
	public void returnBook(List<RentalDTO> dto) {
		for (RentalDTO rentalDTO : dto) {
			bookDAO.returnBook(rentalDTO);
		}
	}

	@Override
	public void rentBook(List<RentalDTO> dto) {
		for (RentalDTO rentalDTO : dto) {
			bookDAO.rentBook(rentalDTO);
			bookDAO.addRentCnt(rentalDTO.getBook_num());
		}
	}

	@Override
	public JSONArray rentMemBookCheck(String mem_id) {
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		
		List<EmpBookDTO> list = new ArrayList<EmpBookDTO>();
		list = bookDAO.rentMemBookCheck(mem_id);
		
		for (int i = 0; i < list.size(); i++) {
			EmpBookDTO dto = list.get(i);
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

	@Override
	public JSONArray rentMemCheck(String mem_id) {
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list = bookDAO.rentMemCheck(mem_id);
		
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("mem_id", dto.getMem_id());
			jObj.put("mem_name", dto.getMem_name());
			jObj.put("mem_phone", dto.getMem_phone());
			jObj.put("mem_address", dto.getMem_address());
			jObj.put("mem_email", dto.getMem_email());
			jObj.put("mem_rank", dto.getMem_rank());
			jArr.add(jObj);
		}
		return jArr;
	}

	@Override
	public JSONObject rentBookCheck(String book_num) {
		
		JSONObject jObj = null;
		
		EmpBookDTO dto = bookDAO.rentBookCheck(Integer.parseInt(book_num));
		
		jObj = new JSONObject();
		jObj.put("book_num", dto.getBook_num());
		jObj.put("book_name", dto.getBook_name());
		jObj.put("book_author", dto.getBook_author());
		jObj.put("book_pub_house", dto.getBook_pub_house());
		jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 4));
		jObj.put("book_ISBN", dto.getBook_ISBN());
		jObj.put("book_apdx_status", dto.getBook_apdx_status());
		jObj.put("book_ctgr_num", dto.getBook_ctgr_num());
		jObj.put("book_rsrv_status", dto.getBook_rsrv_status());
		jObj.put("rent", dto.getRent());
		jObj.put("book_input_date", dto.getBook_input_date().toString().substring(0, 10));

		return jObj;
	}

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
		System.out.println(startRowNum);
		int endRowNum = Perpage * page;
		System.out.println(endRowNum);
		List<EmpBookDTO> list = new ArrayList<EmpBookDTO>();
		list = bookDAO.select(startRowNum, endRowNum);
		return list;
	}

	@Override
	public List searchCtgr(String searchCtgr, String searchWord) {
		List<EmpBookDTO> list = new ArrayList<EmpBookDTO>();
		
		if(searchCtgr.equals("전체")) {
			System.out.println("전체들어옴 "+searchWord);
			list = bookDAO.searchAll("%" + searchWord + "%");
		} else {
			Map<String, String> parameters = new HashMap<>();
			parameters.put("searchCtgr", searchCtgr);
			parameters.put("searchWord", "%"+searchWord+"%");
			list = bookDAO.searchCtgr(parameters);
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
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 4));
			jObj.put("book_ISBN", dto.getBook_ISBN());
			jObj.put("book_apdx_status", dto.getBook_apdx_status());
			jObj.put("book_ctgr_num", dto.getBook_ctgr_num());
			jObj.put("book_rsrv_status", dto.getBook_rsrv_status());
			jObj.put("rent", dto.getRent());
			jObj.put("book_input_date", dto.getBook_input_date().toString().substring(0, 10));
			jArr.add(jObj);
		}
		return jArr;
	}
	
	

	@Override
	public void insert(List<EmpBookDTO> dto) {
		for (EmpBookDTO empBookDTO : dto) {
			empBookDTO.setBook_ctgr_num_db((Integer.parseInt(empBookDTO.getBook_ctgr_num())/100)+"00");
			System.out.println("empBookDTO.getBook_ctgr_num()" + empBookDTO.getBook_ctgr_num());
			System.out.println("empBookDTO.getBook_ctgr_num_db()" + empBookDTO.getBook_ctgr_num_db());
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
	
	@Override
	public void hopeApprove(List<Hope_BookDTO> dto) {
		for (Hope_BookDTO hopeBookDTO : dto) {
			bookDAO.hopeApprove(hopeBookDTO);
		}
	}
	
	@Override
	public void hopeReturn(List<Hope_BookDTO> dto) {
		for (Hope_BookDTO hopeBookDTO : dto) {
			bookDAO.hopeReturn(hopeBookDTO);
		}
	}
	
	@Override
	public void hopeDelete(List<Hope_BookDTO> dto) {
		for (Hope_BookDTO hopeBookDTO : dto) {
			bookDAO.hopeDelete(hopeBookDTO);
		}
	}
	
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
	public JSONArray newSelect() {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy");
		Date date = new Date();
		String today = format.format(date);
		String pubDate = format2.format(date);
		System.out.println("pubDate = " + pubDate);
		
		List<New_BookDTO> list = new ArrayList<New_BookDTO>();
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		list = bookDAO.newSelect();
		
		for (int i = 0; i < list.size(); i++) {
			New_BookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("new_book_num", dto.getNew_book_num());
			jObj.put("new_book_num_sub", dto.getNew_book_num_sub());
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_price", dto.getBook_price());
			jObj.put("new_status", dto.getNew_status());
			jObj.put("new_input_date", dto.getNew_input_date().toString().substring(0, 10));
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 10));
			jObj.put("book_ISBN", dto.getBook_ISBN());
			jObj.put("book_apdx_status", "입력");
			jObj.put("book_ctgr_num", "입력");
			jObj.put("book_rsrv_status", "예약가능");
			jObj.put("rent", "대여가능");
			jObj.put("book_input_date", today);
			jArr.add(jObj);
		}
		return jArr;
	}
	
	@Override
	public JSONArray newSelectBook() {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy");
		Date date = new Date();
		String today = format.format(date);
		String pubDate = format2.format(date);
		
		List<New_BookDTO> list = new ArrayList<New_BookDTO>();
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		list = bookDAO.newSelectBook();
		
		for (int i = 0; i < list.size(); i++) {
			New_BookDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj.put("new_book_num", dto.getNew_book_num());
			jObj.put("new_book_num_sub", dto.getNew_book_num_sub());
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_price", dto.getBook_price());
			jObj.put("new_status", dto.getNew_status());
			jObj.put("new_input_date", dto.getNew_input_date().toString().substring(0, 10));
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 10));
			jObj.put("book_ISBN", dto.getBook_ISBN());
			jObj.put("book_apdx_status", "입력");
			jObj.put("book_ctgr_num", "입력");
			jObj.put("book_rsrv_status", "예약가능");
			jObj.put("rent", "대여가능");
			jObj.put("book_input_date", today);
			jArr.add(jObj);
		}
		return jArr;
	}
	
	@Override
	public void newInsert(List<New_BookDTO> dto) {
		int new_book_num =  bookDAO.newMaxBookNum();
		for (New_BookDTO newBookDTO : dto) {
			newBookDTO.setNew_book_num(new_book_num);
			bookDAO.newInsertBook(newBookDTO);
		}
	}
	
	@Override
	public void newDelete(List<New_BookDTO> dto) {
		for (New_BookDTO newBookDTO : dto) {
			System.out.println("Service) newBookDTO.getNew_book_num_sub() >> " + newBookDTO.getNew_book_num_sub());
			bookDAO.newDeleteBook(newBookDTO);
		}
	}
	
	@Override
	public void newUpdate(List<New_BookDTO> dto) {
		for (New_BookDTO newBookDTO : dto) {
			bookDAO.newUpdateBook(newBookDTO);
		}
	}

	@Override
	public JSONObject disSearch(String book_num) {

		JSONObject jObj = null;
		
		BookRentDisDTO dto = bookDAO.disSearch(Integer.parseInt(book_num));
		
		jObj = new JSONObject();
		jObj.put("book_num", dto.getBook_num());
		jObj.put("book_name", dto.getBook_name());
		jObj.put("book_author", dto.getBook_author());
		jObj.put("book_pub_house", dto.getBook_pub_house());
		jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 4));
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

		return jObj;
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
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 4));
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
	public JSONArray disSelectBook() {
		List<BookRentDisDTO> list = new ArrayList<BookRentDisDTO>();
		JSONArray jArr = new JSONArray();
		JSONObject jObj = null;
		list = bookDAO.disSelectBook();
		
		for (int i = 0; i < list.size(); i++) {
			BookRentDisDTO dto = list.get(i);
			jObj = new JSONObject();
			
			jObj = new JSONObject();
			jObj.put("book_num", dto.getBook_num());
			jObj.put("book_name", dto.getBook_name());
			jObj.put("book_author", dto.getBook_author());
			jObj.put("book_pub_house", dto.getBook_pub_house());
			jObj.put("book_pub_date", dto.getBook_pub_date().toString().substring(0, 4));
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
	public void disInsert(List<BookRentDisDTO> dto) {
		for (BookRentDisDTO bookRentDisDTO : dto) {
			bookDAO.disInsertBook(bookRentDisDTO);
		}
	}
	
	@Override
	public void disDelete(List<BookRentDisDTO> dto) {
		for (BookRentDisDTO bookRentDisDTO : dto) {
			bookDAO.disDeleteBook(bookRentDisDTO);
		}
	}
	
}
