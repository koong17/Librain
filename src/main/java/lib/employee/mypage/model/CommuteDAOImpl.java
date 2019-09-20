package lib.employee.mypage.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommuteDAOImpl implements CommuteDAO {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public void cmtInsert(CommuteDTO commuteDTO) {
		sqlsession.getMapper(CommuteDAO.class).cmtInsert(commuteDTO);
	}

	@Override
	public List<CommuteDTO> cmtSelectAll(CommuteDTO commuteDTO) {
		List<CommuteDTO> list = sqlsession.getMapper(CommuteDAO.class).cmtSelectAll(commuteDTO);
		return list;
	}

}
