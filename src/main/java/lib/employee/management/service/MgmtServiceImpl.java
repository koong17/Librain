package lib.employee.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.management.model.EmployeeDAO;
import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;
import lib.employee.mypage.model.CommuteDTO;

@Service
public class MgmtServiceImpl implements MgmtService{
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public JSONArray empSelectAll() {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<EmployeeDTO> list = employeeDAO.empSelectAll();
		for (int i = 0; i < list.size(); i++) {
			// emp_no, emp_name, emp_telephone, emp_email, 
			//  emp_dept_code, emp_rank_position, emp_join_date
			jo = new JSONObject();
			EmployeeDTO dto = list.get(i);
			jo.put("emp_no",dto.getEmp_no());
			jo.put("emp_name",dto.getEmp_name());
			jo.put("emp_telephone",dto.getEmp_telephone());
			jo.put("emp_email",dto.getEmp_email());
			jo.put("emp_dept_code",dto.getDept_name());
			jo.put("emp_position",dto.getEmp_position());
			jo.put("emp_join_date",dto.getEmp_join_date().toString().substring(0,10));
			ja.add(jo);
		}
		
		return ja;
	}

	@Override
	public void empDelete(List<EmployeeDTO> employeeDTOs) {
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			employeeDAO.empDelete(employeeDTO);
		}
	}

	@Override
	public JSONArray cmtAdminSelectAll() {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<CommuteDTO> list = employeeDAO.cmtAdminSelectAll();
		for (int i = 0; i < list.size(); i++) {
			// emp_no, emp_name, emp_telephone, emp_email, 
			//  emp_dept_code, emp_rank_position, emp_join_date
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			jo.put("cmt_no",dto.getCmt_no());
			jo.put("emp_no",dto.getEmp_no());
			jo.put("cmt_status",dto.getCmt_status());
			jo.put("cmt_year",dto.getCmt_year());
			jo.put("cmt_month",dto.getCmt_month());
			jo.put("cmt_day",dto.getCmt_day());
			jo.put("cmt_hour",dto.getCmt_hour()+"");
			jo.put("cmt_minute",dto.getCmt_minute()+"");
			ja.add(jo);
		}
		
		return ja;
	}

	@Override
	public void cmtUpdate(CommuteDTO commuteDTO) {
		employeeDAO.cmtUpdate(commuteDTO);
	}

	@Override
	public void empInsert(EmployeeDTO employeeDTO) {
		employeeDAO.empInsert(employeeDTO);
	}

	@Override
	public JSONObject empSelectPay(EmployeeDTO employeeDTO) {
		SalaryDTO salaryDTO = new SalaryDTO();
		JSONObject jo = new JSONObject();
		employeeDTO = employeeDAO.empSelectPay(employeeDTO);
		if(employeeDTO != null) {
			jo.put("sal_basic_pay", employeeDTO.getEmp_basic_pay());
			jo.put("emp_no", employeeDTO.getEmp_no());
		}
		return jo;
	}

	@Override
	public JSONArray cmtAdminSelectOne(CommuteDTO commuteDTO) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<CommuteDTO> list = employeeDAO.cmtAdminSelectOne(commuteDTO);
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			String cmt_status = dto.getCmt_status();
			int cmt_hour = dto.getCmt_hour();
			int cmt_minute = dto.getCmt_minute();
			jo.put("cmt_day", dto.getCmt_day());
			jo.put("cmt_hour", cmt_hour);
			jo.put("cmt_minute", dto.getCmt_minute());
			jo.put("cmt_status", cmt_status);
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
	public void salInsert(SalaryDTO salaryDTO) {
		employeeDAO.salInsert(salaryDTO);
	}

	@Override
	public JSONArray salSelect(SalaryDTO salaryDTO) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<SalaryDTO> list = employeeDAO.salSelect(salaryDTO);
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			SalaryDTO dto = list.get(i);
			jo.put("emp_no",dto.getEmp_no());
			jo.put("sal_basic_pay",dto.getSal_basic_pay());
			jo.put("sal_food_pay",dto.getSal_food_pay());
			jo.put("sal_bonus",dto.getSal_bonus());
			jo.put("sal_total",dto.getSal_total());
			jo.put("sal_deducted",dto.getSal_deducted());
			jo.put("sal_real",dto.getSal_real());
			ja.add(jo);
		}
		
		return ja;
	}

	@Override
	public JSONArray empSearch(String searchType, String searchWord) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		Map<String, String> params = new HashMap<>();
		params.put("searchType", searchType);
		params.put("searchWord", "%"+searchWord+"%");
		List<EmployeeDTO> list = employeeDAO.empSearch(params);
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			EmployeeDTO dto = list.get(i);
			jo.put("emp_no",dto.getEmp_no());
			jo.put("emp_name",dto.getEmp_name());
			jo.put("emp_telephone",dto.getEmp_telephone());
			jo.put("emp_email",dto.getEmp_email());
			jo.put("emp_dept_code",dto.getDept_name());
			jo.put("emp_position",dto.getEmp_position());
			jo.put("emp_join_date",dto.getEmp_join_date().toString().substring(0,10));
			ja.add(jo);
		}
		return ja;
	}

	@Override
	public void empUpdate(EmployeeDTO employeeDTO) {
		employeeDAO.empUpdate(employeeDTO);
	}

	@Override
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO) {
		return employeeDAO.empSelectOne(employeeDTO);
	}

	@Override
	public JSONArray cmtSearch(CommuteDTO commuteDTO) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<CommuteDTO> list = employeeDAO.cmtSearch(commuteDTO);
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			jo.put("cmt_no",dto.getCmt_no());
			jo.put("emp_no",dto.getEmp_no());
			jo.put("cmt_status",dto.getCmt_status());
			jo.put("cmt_year",dto.getCmt_year());
			jo.put("cmt_month",dto.getCmt_month());
			jo.put("cmt_day",dto.getCmt_day());
			jo.put("cmt_hour",dto.getCmt_hour()+"");
			jo.put("cmt_minute",dto.getCmt_minute()+"");
			ja.add(jo);
		}
		return ja;
	}
	
	@Override
	public JSONArray cmtSearchOne(CommuteDTO commuteDTO) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<CommuteDTO> list = employeeDAO.cmtSearchOne(commuteDTO);
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			CommuteDTO dto = list.get(i);
			jo.put("cmt_no",dto.getCmt_no());
			jo.put("emp_no",dto.getEmp_no());
			jo.put("cmt_status",dto.getCmt_status());
			jo.put("cmt_year",dto.getCmt_year());
			jo.put("cmt_month",dto.getCmt_month());
			jo.put("cmt_day",dto.getCmt_day());
			jo.put("cmt_hour",dto.getCmt_hour()+"");
			jo.put("cmt_minute",dto.getCmt_minute()+"");
			ja.add(jo);
		}
		return ja;
	}

	@Override
	public JSONArray empSelectDept(EmployeeDTO employeeDTO) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		List<EmployeeDTO> list = employeeDAO.empSelectDept(employeeDTO);
		for (int i = 0; i < list.size(); i++) {
			jo = new JSONObject();
			EmployeeDTO dto = list.get(i);
			jo.put("emp_name",dto.getEmp_name());
			ja.add(jo);
		}
		return ja;
	}
	
}
