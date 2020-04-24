package lib.member.book.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import lib.employee.book.model.Hope_BookDTO;

public interface MemBookDAO {
	public int hopeSelectRowNum(); //rownum 갯수
	public void hopeInsertBook(Hope_BookDTO dto); //희망도서 책 추가
	public int hopeMemCheck(String mem_id); //희망도서 회원 검색
	public List<Hope_BookDTO> hopeSelect(@Param(value="startRowNum") int startRowNum, @Param(value="endRowNum") int endRowNum); //희망 도서 출력
	
	public List<MemBookDTO> searchAll(String searchWord); //전체검색
	public List<MemBookDTO> searchCtgr(Map<String, String> parameters); //도서명검색
	public List<MemBookDTO> newBook(@Param(value = "startRowNum") int startRowNum,@Param(value = "endRowNum") int endRowNum); //신간도서
	public List<MemBookDTO> mostRent(@Param(value = "startRowNum") int startRowNum,@Param(value = "endRowNum") int endRowNum); //최다대여도서
}
