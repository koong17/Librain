package lib.employee.book.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.employee.book.model.EmpBookDTO;

public interface EmpBookService {
	public List select();
	public List searchCtgr(String searchCtgr, String searchWord);
	public JSONArray search(List<EmpBookDTO> list);
}
