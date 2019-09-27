package lib.employee.mypage.service;

import org.json.simple.JSONArray;

import lib.employee.mypage.model.CommuteDTO;

public interface MypageService {
	public void cmtInsert(CommuteDTO commuteDTO);
	public JSONArray cmtSelectAll(CommuteDTO commuteDTO);
	public JSONArray cmtSelectOnOff(CommuteDTO commuteDTO);
}
