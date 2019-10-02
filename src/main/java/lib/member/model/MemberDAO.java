package lib.member.model;

import java.util.List;

public interface MemberDAO {
	
	//전체출력
	public List<MemberDTO> memberSelectAll();
	
	//전체검색
	public List<MemberDTO> memberSearchAll(String searchWord);
	
	//멤버ID검색
	public List<MemberDTO> memberSearchID(String searchWord);
	
	//멤버이름검색
	public List<MemberDTO> memberSearchName(String searchWord);
	
	//권한변경
	public void memberRankUpdate(MemberDTO dto);
	
}
