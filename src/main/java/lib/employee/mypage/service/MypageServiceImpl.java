package lib.employee.mypage.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.mypage.model.CommuteDAO;
import lib.employee.mypage.model.CommuteDTO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	CommuteDAO commuteDAO;

	@Override
	public void cmtInsert(CommuteDTO commuteDTO) {
		commuteDAO.cmtInsert(commuteDTO);
	}

	@Override
	public JSONArray cmtSelectAll(CommuteDTO commuteDTO) {
		List<CommuteDTO> list = commuteDAO.cmtSelectAll(commuteDTO);
		JSONArray ja = new JSONArray();
		JSONObject jo;
		for (int i = 0; i < list.size(); i++) {
			// emp_no, emp_name, emp_telephone, emp_email, 
			//  emp_dept_code, emp_rank_position, emp_join_date
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			jo.put("cmt_emp_no", dto.getCmt_emp_no());
			jo.put("cmt_status", dto.getCmt_status());
			jo.put("cmt_hour", dto.getCmt_hour());
			jo.put("cmt_second", dto.getCmt_second());
			ja.add(jo);
		}
		return ja;
	}
	
}
