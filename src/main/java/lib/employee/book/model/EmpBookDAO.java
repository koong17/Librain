package lib.employee.book.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import lib.member.model.MemberDTO;


public interface EmpBookDAO {
	
	public void returnBook(RentalDTO dto); //반납
	public void addRentCnt(int book_num); //대여 횟수 증가
	public void rentBook(RentalDTO dto); //대여
	public List<EmpBookDTO> rentMemBookCheck(String mem_id); //멤버의 대여중인 책 검색
	public List<MemberDTO> rentMemCheck(String mem_id); //대여할 회원 검색
	public EmpBookDTO rentBookCheck(int book_num); //대여할 도서번호 검색
	
	public int selectRowNum(); //rownum 갯수
	public List<EmpBookDTO> select(@Param(value="startRowNum") int startRowNum, @Param(value="endRowNum") int endRowNum); //전체출력
	public List<EmpBookDTO> searchAll(String str); //전체검색
	public List<EmpBookDTO> searchCtgr(Map<String, String> parameters); //도서명검색
	
	public void insertBook(EmpBookDTO dto); //책 추가
	public void deleteBook(EmpBookDTO dto); //책 삭제
	public void updateBook(EmpBookDTO dto); //책 수정

	public int hopeSelectRowNum(); //rownum 갯수
	public void hopeApprove(Hope_BookDTO dto); //희망 도서 승인
	public void hopeReturn(Hope_BookDTO dto); //희망 도서 반려
	public void hopeDelete(Hope_BookDTO dto); //일주일 이전 항목 삭제
	public List<Hope_BookDTO> hopeSelect(@Param(value="startRowNum") int startRowNum, @Param(value="endRowNum") int endRowNum); //희망 도서 출력
	
	public List<New_BookDTO> newSelect(); //신간출력
	public List<New_BookDTO> newSelectBook(); //신간요청 승인 출력
	public void newInsertBook(New_BookDTO dto); //신간 책 추가
	public int newMaxBookNum();
	public void newDeleteBook(New_BookDTO dto); //신간 책 삭제
	public void newUpdateBook(New_BookDTO dto); //신간 책 수정
	
	public BookRentDisDTO disSearch(int book_num);
	public List<BookRentDisDTO> disSelect(); //폐기출력
	public List<BookRentDisDTO> disSelectBook(); //폐기요청 승인출력
	public void disInsertBook(BookRentDisDTO dto);//폐기 책 추가
	public void disDeleteBook(BookRentDisDTO dto); //폐기 책 삭제
}
