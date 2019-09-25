package lib.member.model;

import java.util.List;

public interface MemberDAO {
	
	//전체출력
	public List<MemberDTO> memberSelectAll();
	
	//멤버검색
	public void memberSearch(MemberDTO dto);
	
	//권한변경
	public void memberRankUpdate(MemberDTO dto);
	
}
