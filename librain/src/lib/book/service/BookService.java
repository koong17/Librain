package lib.book.service;

import java.util.List;

import lib.book.model.BookDTO;


public interface BookService {
	public List<BookDTO> selectBook(String str);
}
