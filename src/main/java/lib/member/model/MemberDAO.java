package lib.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {

	//권한 설정(유공자나 블랙리스트 등)
	public int rankMember(int mem_rank);
	
	public MemberDTO getMember(int mem_rank);
	
	//삭제(탈퇴)
	public void deleteMember(MemberDTO dto);

	//검색(select where)
	public void selectMember(MemberDTO dto);
	
	//리스트(selectAll)
	public List<MemberDTO> getMemberList();
	
}
