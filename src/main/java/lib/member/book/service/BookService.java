package lib.member.book.service;

import java.util.List;

import lib.member.book.model.BookDTO;


public interface BookService {
	public List<BookDTO> searchAll(String str); //전체검색
	public List<BookDTO> searchBookName(String str); //도서명검색
	public List<BookDTO> searchAuthor(String str); //저자명검색
	public List<BookDTO> searchPub(String str); //출판사검색
}
