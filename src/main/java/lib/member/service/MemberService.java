package lib.member.service;

import org.json.simple.JSONArray;

public interface MemberService {

	//전체목록
	public JSONArray memberSelectAll();
	
	//멤버검색
	public void memberSearch(JSONArray ja);
	
	//권한수정
	public void memberRankUpdate(JSONArray ja);
	
}
