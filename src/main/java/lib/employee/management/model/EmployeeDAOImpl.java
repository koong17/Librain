package lib.employee.management.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<EmployeeDTO> empSelectAll() {
		List<EmployeeDTO> list = sqlsession.getMapper(EmployeeDAO.class).empSelectAll();
		return list;
	}

	@Override
	public void empDelete(EmployeeDTO...dtos) {
		for (EmployeeDTO dto : dtos) {
			sqlsession.getMapper(EmployeeDAO.class).empDelete(dto);
		}
	}

}