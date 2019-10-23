package lib.member.book.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lib.employee.book.model.Hope_BookDTO;

public interface MemBookDAO {
	public void hopeInsertBook(Hope_BookDTO dto); //희망도서 책 추가
	public int hopeMemCheck(String mem_id); //희망도서 회원 검색
	public List<MemBookDTO> searchAll(String str); //전체검색
	public List<MemBookDTO> searchBookName(String str); //도서명검색
	public List<MemBookDTO> searchAuthor(String str); //저자명검색
	public List<MemBookDTO> searchPub(String str); //출판사검색
	public List<MemBookDTO> newBook(@Param(value = "startRowNum") int startRowNum,@Param(value = "endRowNum") int endRowNum); //신간도서
	public List<MemBookDTO> mostRent(@Param(value = "startRowNum") int startRowNum,@Param(value = "endRowNum") int endRowNum); //최다대여도서
}
