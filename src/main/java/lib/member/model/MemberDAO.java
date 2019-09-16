package lib.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {

	//가입(직원 or 가상의 웹페이지)
	public void insertMember(MemberDTO dto);

	//수정
	public void updateMember(MemberDTO dto);
	
	//삭제(탈퇴)
	public void deleteMember(MemberDTO dto);
	
	//리스트(selectAll)
	public List<MemberDTO> getMemberList(HashMap map);
	
	//검색(select where)
	public void selectMember(MemberDTO dto);
}
