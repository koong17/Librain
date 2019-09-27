package lib.employee.book.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

import lib.employee.book.model.EmpBookDTO;

public interface EmpBookService {
	public List select(int Perpage, int page);
	public List searchCtgr(String searchCtgr, String searchWord);
	public JSONArray search(List<EmpBookDTO> list);
	public void insert();
}
