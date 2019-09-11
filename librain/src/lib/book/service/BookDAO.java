package lib.book.service;

import java.util.List;

import lib.book.model.BookDTO;

public interface BookDAO {
	public List<BookDTO> selectBook(String str); //도서검색
}
