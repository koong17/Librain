package lib.employee.mypage.model;

import java.util.List;

public interface CommuteDAO {
	public void cmtInsert(CommuteDTO commuteDTO);
	public List<CommuteDTO> cmtSelectAll(CommuteDTO commuteDTO);
}
