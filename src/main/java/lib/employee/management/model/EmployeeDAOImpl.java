package lib.employee.management.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lib.employee.mypage.model.CommuteDTO;

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
	public void empDelete(EmployeeDTO employeeDTO) {
		sqlsession.getMapper(EmployeeDAO.class).empDelete(employeeDTO);
	}

	@Override
	public List<CommuteDTO> cmtAdminSelectAll() {
		List<CommuteDTO> list = sqlsession.getMapper(EmployeeDAO.class).cmtAdminSelectAll();
		return list;
	}

	@Override
	public void cmtUpdate(CommuteDTO commuteDTO) {
		sqlsession.getMapper(EmployeeDAO.class).cmtUpdate(commuteDTO);
	}

	@Override
	public void empInsert(EmployeeDTO employeeDTO) {
		sqlsession.getMapper(EmployeeDAO.class).empInsert(employeeDTO);
	}

}
