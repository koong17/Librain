package lib.member.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	
	//회원가입
	public void memberjoin(MemberDTO dto);
	
	//중복확인
	public int memberSearchIDCount(String mem_id);
	
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

	//페이징
	public Object selectRowNum();

	public List<MemberDTO> select(@Param(value = "startRowNum") int startRowNum, @Param(value = "endRowNum") int endRowNum);
	
}
