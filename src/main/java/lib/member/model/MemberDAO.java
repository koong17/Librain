package lib.member.model;

import java.util.List;

public interface MemberDAO {
	
	public List<MemberDTO> memberSelectAll();
	public void memRankModify(MemberDTO ...dtos );
	
}
