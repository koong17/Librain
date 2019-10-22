package lib.employee.login.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.login.model.LoginDAO;
import lib.employee.management.model.EmployeeDTO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO dao;
	
	@Override
	public boolean loginCheck(EmployeeDTO dto, HttpSession session) {
		boolean result = dao.loginCheck(dto);
		if(result == true) {
			dto = dao.loginInfo(dto);
			session.setAttribute("emp_no",  dto.getEmp_no());
			session.setAttribute("emp_name",  dto.getEmp_name());
			session.setAttribute("emp_position",  dto.getEmp_position());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}

	@Override
	public JSONArray bookCount() {
		List<Map> list = dao.bookCount();
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			jo.put(list.get(i).get("CTGR"), list.get(i).get("COUNT"));
			total += ((BigDecimal)list.get(i).get("COUNT")).intValue();
		}
		jo.put("total", total);
		ja.add(jo);
		return ja;
	}
	
}
