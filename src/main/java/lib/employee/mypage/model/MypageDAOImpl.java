package lib.employee.mypage.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lib.employee.management.model.EmployeeDTO;
import lib.employee.management.model.SalaryDTO;

@Component
public class MypageDAOImpl implements MypageDAO {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public void cmtInsert(CommuteDTO commuteDTO) {
		sqlsession.getMapper(MypageDAO.class).cmtInsert(commuteDTO);
	}

	@Override
	public List<CommuteDTO> cmtSelectAll(CommuteDTO commuteDTO) {
		List<CommuteDTO> list = sqlsession.getMapper(MypageDAO.class).cmtSelectAll(commuteDTO);
		return list;
	}

	@Override
	public List<CommuteDTO> cmtSelectOnOff(CommuteDTO commuteDTO) {
		List<CommuteDTO> list = sqlsession.getMapper(MypageDAO.class).cmtSelectOnOff(commuteDTO);
		return list;
	}

	@Override
	public EmployeeDTO empSelectOne(EmployeeDTO employeeDTO) {
		EmployeeDTO ret = sqlsession.getMapper(MypageDAO.class).empSelectOne(employeeDTO);
		return ret;
	}

	@Override
	public void empUpdate(EmployeeDTO employeeDTO) {
		sqlsession.getMapper(MypageDAO.class).empUpdate(employeeDTO);
		
	}

	@Override
	public SalaryDTO salSelectOne(SalaryDTO salaryDTO) {
		salaryDTO = sqlsession.getMapper(MypageDAO.class).salSelectOne(salaryDTO);
		return salaryDTO;
	}

	@Override
	public int empCheckPwd(EmployeeDTO employeeDTO) {
		return sqlsession.getMapper(MypageDAO.class).empCheckPwd(employeeDTO);
	}

	@Override
	public void empUpdatePwd(EmployeeDTO employeeDTO) {
		sqlsession.getMapper(MypageDAO.class).empUpdatePwd(employeeDTO);
		
	}

}
