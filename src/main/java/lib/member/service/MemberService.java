package lib.member.service;

import java.util.List;

import org.json.simple.JSONArray;

import lib.member.model.MemberDTO;

public interface MemberService {

	//전체목록
	public JSONArray memberSelectAll();
	
	//멤버검색
	public void memberSearch(MemberDTO dto);
	
	//권한수정
	public void memberRankUpdate(List<MemberDTO> dtos);
	
}
