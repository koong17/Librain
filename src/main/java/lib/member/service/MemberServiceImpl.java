package lib.member.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public JSONArray memberSelectAll() {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		List<MemberDTO> list = memberDAO.memberSelectAll();
		for(int i=0; i<list.size(); i++) {
			jo = new JSONObject();
			MemberDTO dto = list.get(i);
			jo.put("mem_id", dto.getMem_id());
			jo.put("mem_pw", dto.getMem_pw());
			jo.put("mem_name", dto.getMem_name());
			jo.put("mem_jumin", dto.getMem_jumin());
			jo.put("mem_address", dto.getMem_address());
			jo.put("mem_phone", dto.getMem_phone());
			jo.put("mem_email", dto.getMem_email());
			jo.put("mem_rank", dto.getMem_rank());
			ja.add(jo);
		}
		
		return ja;
	}

	@Override
	public void update(JSONArray ja) {
		// TODO Auto-generated method stub
		
	}

}
