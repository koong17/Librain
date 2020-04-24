package lib.admin.book.model;

import java.util.List;

public interface AdminBookDAO {
	public List<New_BookDTO> newSelect(); //신간출력
	public void newApprove(New_BookDTO dto); //신간 승인
	public void newReturn(New_BookDTO dto); //신간 승인
	public List<BookRentDisDTO> disSelect(); //폐기출력
	public void disApprove(BookRentDisDTO dto); //폐기 승인
	public void disReturn(BookRentDisDTO dto); //폐기 승인
}	
