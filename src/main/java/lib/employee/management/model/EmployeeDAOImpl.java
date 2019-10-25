package lib.employee.management.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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

	@Override
	public EmployeeDTO empSelectPay(EmployeeDTO employeeDTO) {
		return sqlsession.getMapper(EmployeeDAO.class).empSelectPay(employeeDTO);
	}

	@Override
	public List<CommuteDTO> cmtAdminSelectOne(CommuteDTO commuteDTO) {
		return sqlsession.getMapper(EmployeeDAO.class).cmtAdminSelectOne(commuteDTO);
	}

	@Override
	public void salInsert(SalaryDTO salaryDTO) {
		sqlsession.getMapper(EmployeeDAO.class).salInsert(salaryDTO);
	}

	@Override
	public List<SalaryDTO> salSelect(SalaryDTO salaryDTO) {
		return sqlsession.getMapper(EmployeeDAO.class).salSelect(salaryDTO);
	}

	@Override
	public List<EmployeeDTO> empSearch(Map<String, String> parameters) {
		return sqlsession.getMapper(EmployeeDAO.class).empSearch(parameters);
	}

	@Override
	public void empUpdate(EmployeeDTO dto) {
		sqlsession.getMapper(EmployeeDAO.class).empUpdate(dto);
	}

	@Override
	public EmployeeDTO empSelectOne(EmployeeDTO dto) {
		return sqlsession.getMapper(EmployeeDAO.class).empSelectOne(dto);
	}

	@Override
	public List<CommuteDTO> cmtSearch(CommuteDTO commuteDTO) {
		return sqlsession.getMapper(EmployeeDAO.class).cmtSearch(commuteDTO);
	}
	
	@Override
	public List<CommuteDTO> cmtSearchOne(CommuteDTO commuteDTO) {
		return sqlsession.getMapper(EmployeeDAO.class).cmtSearchOne(commuteDTO);
	}

	@Override
	public List<EmployeeDTO> empSelectDept(EmployeeDTO dto) {
		return sqlsession.getMapper(EmployeeDAO.class).empSelectDept(dto);
	}

}
