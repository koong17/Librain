package lib.member.book.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemBookDaoImpl implements MemBookDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<MemBookDTO> searchAll(String searchWord) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).searchAll("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<MemBookDTO> searchBookName(String searchWord) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).searchBookName("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<MemBookDTO> searchAuthor(String searchWord) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).searchAuthor("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<MemBookDTO> searchPub(String searchWord) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).searchPub("%" + searchWord + "%");
		return list;
	}

}
