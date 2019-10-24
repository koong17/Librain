package lib.employee.mypage.service;

import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;
import lib.employee.mypage.model.MypageDAO;
import lib.employee.mypage.model.CommuteDTO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	MypageDAO mypageDAO;

	@Override
	public void cmtInsert(CommuteDTO commuteDTO) {
		mypageDAO.cmtInsert(commuteDTO);
	}

	@Override
	public JSONArray cmtSelectAll(CommuteDTO commuteDTO) {
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		commuteDTO.setCmt_DAY(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		List<CommuteDTO> list = mypageDAO.cmtSelectAll(commuteDTO);
		JSONArray ja = new JSONArray();
		JSONObject jo;
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			jo.put("emp_no", dto.getEmp_no());
			jo.put("cmt_status", dto.getCmt_status());
			jo.put("cmt_hour", dto.getCmt_hour());
			jo.put("cmt_minute", dto.getCmt_minute());
			System.out.println(dto.getEmp_no());
			ja.add(jo);
		}
		return ja;
	}

	@Override
	public JSONArray cmtSelectOnOff(CommuteDTO commuteDTO) {
		commuteDTO.setCmt_DAY(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		List<CommuteDTO> list = mypageDAO.cmtSelectOnOff(commuteDTO);
		JSONArray ja = new JSONArray();
		JSONObject jo;
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			String cmt_status = dto.getCmt_status();
			int cmt_hour = dto.getCmt_hour();
			int cmt_minute = dto.getCmt_minute();
			jo.put("emp_no", dto.getEmp_no());
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

	@Override
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO) {
		return mypageDAO.empSelectOne(employeeDTO);
	}

	@Override
	public void empUpdate(EmployeeDTO employeeDTO) {
		mypageDAO.empUpdate(employeeDTO);
	}

	@Override
	public JSONObject salSelectOne(SalaryDTO salaryDTO) {
		JSONObject jo = new JSONObject();
		SalaryDTO dto = mypageDAO.salSelectOne(salaryDTO);
		System.out.println(dto);
		if(dto != null) {
			jo.put("sal_basic_pay",dto.getSal_basic_pay());
			jo.put("sal_food_pay",dto.getSal_food_pay());
			jo.put("sal_bonus",dto.getSal_bonus());
			jo.put("sal_total",dto.getSal_total());
			jo.put("sal_national_pension",dto.getSal_national_pension());
			jo.put("sal_health_insurance",dto.getSal_health_insurance());
			jo.put("sal_longterm_care_insurance",dto.getSal_longterm_care_insurance());
			jo.put("sal_employment_insurance",dto.getSal_employment_insurance());
			jo.put("sal_income_tax",dto.getSal_income_tax());
			jo.put("sal_local_income_tax",dto.getSal_local_income_tax());
			jo.put("sal_deducted",dto.getSal_deducted());
			jo.put("sal_real",dto.getSal_real());
		}
		return jo;
	}

	@Override
	public int empUpdatePwd(EmployeeDTO employeeDTO, String pwd) {
		int result = mypageDAO.empCheckPwd(employeeDTO);
		System.out.println("result : "+result);
		if(result > 0) {
			employeeDTO.setEmp_password(pwd);
			mypageDAO.empUpdatePwd(employeeDTO);
		} 
		return result;
	}
	
}
