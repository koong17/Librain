package lib.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lib.book.model.BookDTO;

@Component
public class BookServiceImpl implements BookService {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<BookDTO> selectBook(String str) {
		BookDAO bookDAO = sqlsession.getMapper(BookDAO.class);
		return bookDAO.selectBook(str);
	}

}
