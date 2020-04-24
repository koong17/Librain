package lib.member.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.member.model.MemberDTO;

public interface MemberService {
	
	//회원가입
	public void memberjoin(MemberDTO dto);
	
	//중복확인
	public Integer memberSearchIDCount(String mem_id);
	
	//회원로그인
	public MemberDTO memberLogin(String mem_id, String mem_pw);
	
	//회원확인
	public int memberCount(String mem_id, String mem_pw);
	
	//회원수정
	public void memberUpdate(MemberDTO dto);

	//전체목록
	public JSONArray memberSelectAll();
	
	//검색
	public JSONArray memberSearch(List<MemberDTO> dtos);
	public List memberSearchCtgr(String searchCtgr, String searchWord);
	public List memberSearchID(String searchWord);
	public List memberSearchName(String searchWord);
	
	//권한수정
	public void memberRankUpdate(List<MemberDTO> dtos);

	//페이징
	public List<MemberDTO> select(int perPage, int page);

}
