package lib.admin.book.model;

import java.util.List;

public interface AdminBookDAO {
	public List<New_BookDTO> newSelect(); //신간출력
	public void newApprove(New_BookDTO dto); //신간 승인
	public void newReturn(New_BookDTO dto); //신간 승인
}	
