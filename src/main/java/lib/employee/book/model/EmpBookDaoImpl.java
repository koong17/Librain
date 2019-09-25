package lib.employee.book.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpBookDaoImpl implements EmpBookDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<EmpBookDTO> select() {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).select();
		return list;
	}

	@Override
	public List<EmpBookDTO> searchAll(String searchWord) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchAll("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<EmpBookDTO> searchBookName(String searchWord) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchBookName("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<EmpBookDTO> searchAuthor(String searchWord) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchAuthor("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<EmpBookDTO> searchPub(String searchWord) {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).searchPub("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<EmpBookDTO> insert() {
		List<EmpBookDTO> list = sqlsession.getMapper(EmpBookDAO.class).select();
		return list;
	}
	
	
}
