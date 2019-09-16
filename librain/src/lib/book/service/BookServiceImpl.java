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
	public List<BookDTO> searchAll(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> searchBookName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> searchAuthor(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> searchPub(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
