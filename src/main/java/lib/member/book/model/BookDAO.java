package lib.member.book.model;

import java.util.List;

public interface BookDAO {
	public List<BookDTO> searchAll(String str); //전체검색
	public List<BookDTO> searchBookName(String str); //도서명검색
	public List<BookDTO> searchAuthor(String str); //저자명검색
	public List<BookDTO> searchPub(String str); //출판사검색
}
