package lib.member.book.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<BookDTO> searchAll(String searchWord) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchAll("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<BookDTO> searchBookName(String searchWord) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchBookName("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<BookDTO> searchAuthor(String searchWord) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchAuthor("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<BookDTO> searchPub(String searchWord) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchPub("%" + searchWord + "%");
		return list;
	}

}
