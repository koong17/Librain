package lib.member.service;

import org.json.simple.JSONArray;

public interface MemberService {

	public JSONArray memberSelectAll();
	public void update(JSONArray ja);
	
}
