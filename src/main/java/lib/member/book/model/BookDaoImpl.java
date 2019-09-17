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
	public List<BookDTO> searchAll(String str) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchAll(str);
		return list;
	}

	@Override
	public List<BookDTO> searchBookName(String str) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchBookName(str);
		return list;
	}

	@Override
	public List<BookDTO> searchAuthor(String str) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchAuthor(str);
		return list;
	}

	@Override
	public List<BookDTO> searchPub(String str) {
		List<BookDTO> list = sqlsession.getMapper(BookDAO.class).searchPub(str);
		return list;
	}

}
