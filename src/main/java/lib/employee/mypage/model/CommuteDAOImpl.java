package lib.employee.mypage.model;

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

}
