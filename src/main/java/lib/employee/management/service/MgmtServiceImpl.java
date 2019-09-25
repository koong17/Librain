package lib.employee.management.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.management.model.EmployeeDAO;
import lib.employee.management.model.EmployeeDTO;
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
			jo.put("emp_dept_code",dto.getEmp_dept_code());
			jo.put("emp_rank_position",dto.getEmp_rank_position());
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
			jo.put("cmt_emp_no",dto.getCmt_emp_no());
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
	
}
