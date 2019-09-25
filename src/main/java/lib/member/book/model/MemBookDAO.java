package lib.member.book.model;

import java.util.List;

public interface MemBookDAO {
	public List<MemBookDTO> searchAll(String str); //전체검색
	public List<MemBookDTO> searchBookName(String str); //도서명검색
	public List<MemBookDTO> searchAuthor(String str); //저자명검색
	public List<MemBookDTO> searchPub(String str); //출판사검색
}
