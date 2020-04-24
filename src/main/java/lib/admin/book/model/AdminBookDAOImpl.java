package lib.admin.book.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminBookDAOImpl implements AdminBookDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<New_BookDTO> newSelect() {
		List<New_BookDTO> list = sqlsession.getMapper(AdminBookDAO.class).newSelect();
		return list;
	}

	@Override
	public void newApprove(New_BookDTO dto) {
		sqlsession.getMapper(AdminBookDAO.class).newApprove(dto);
	}

	@Override
	public void newReturn(New_BookDTO dto) {
		sqlsession.getMapper(AdminBookDAO.class).newReturn(dto);
	}

	@Override
	public List<BookRentDisDTO> disSelect() {
		List<BookRentDisDTO> list = sqlsession.getMapper(AdminBookDAO.class).disSelect();
		return list;
	}
	
	@Override
	public void disApprove(BookRentDisDTO dto) {
		sqlsession.getMapper(AdminBookDAO.class).disApprove(dto);
	}
	
	@Override
	public void disReturn(BookRentDisDTO dto) {
		sqlsession.getMapper(AdminBookDAO.class).disReturn(dto);
	}
	
	
}
