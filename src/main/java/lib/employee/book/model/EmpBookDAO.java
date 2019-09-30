package lib.employee.book.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface EmpBookDAO {
	
	public int selectRowNum(); //rownum 갯수
	public List<EmpBookDTO> select(@Param(value = "startRowNum") int startRowNum,@Param(value = "endRowNum") int endRowNum); //전체출력
	public List<EmpBookDTO> searchAll(String str); //전체검색
	public List<EmpBookDTO> searchBookName(String str); //도서명검색
	public List<EmpBookDTO> searchAuthor(String str); //저자명검색
	public List<EmpBookDTO> searchPub(String str); //출판사검색
	public void insertBook(EmpBookDTO dto); //책 추가
	public void deleteBook(EmpBookDTO dto); //책 삭제
	public void updateBook(EmpBookDTO dto); //책 수정
}
