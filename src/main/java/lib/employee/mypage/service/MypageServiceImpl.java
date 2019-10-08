package lib.employee.mypage.service;

import java.util.Calendar;
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
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		commuteDTO.setCmt_DAY(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		List<CommuteDTO> list = commuteDAO.cmtSelectAll(commuteDTO);
		JSONArray ja = new JSONArray();
		JSONObject jo;
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			jo.put("cmt_emp_no", dto.getCmt_emp_no());
			jo.put("cmt_status", dto.getCmt_status());
			jo.put("cmt_hour", dto.getCmt_hour());
			jo.put("cmt_minute", dto.getCmt_minute());
			System.out.println(dto.getCmt_emp_no());
			ja.add(jo);
		}
		return ja;
	}

	@Override
	public JSONArray cmtSelectOnOff(CommuteDTO commuteDTO) {
		commuteDTO.setCmt_DAY(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		List<CommuteDTO> list = commuteDAO.cmtSelectOnOff(commuteDTO);
		JSONArray ja = new JSONArray();
		JSONObject jo;
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			String cmt_status = dto.getCmt_status();
			int cmt_hour = dto.getCmt_hour();
			int cmt_minute = dto.getCmt_minute();
			jo.put("cmt_emp_no", dto.getCmt_emp_no());
			jo.put("cmt_status", cmt_status);
			jo.put("cmt_hour", cmt_hour);
			jo.put("cmt_minute", dto.getCmt_minute());
			if(cmt_status.equals("on")) {
				if(cmt_hour<9 || (cmt_hour==9&&cmt_minute==0))
					jo.put("cmt_status_kr", "정상출근");
				else jo.put("cmt_status_kr", "지각");
			} else {
				if(cmt_hour>=17 )
					jo.put("cmt_status_kr", "정상퇴근");
				else jo.put("cmt_status_kr", "조퇴");
			}
			ja.add(jo);
		}
		return ja;
	}
	
}