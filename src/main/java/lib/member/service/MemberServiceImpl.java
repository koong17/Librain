package lib.member.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.member.book.model.MemBookDTO;
import lib.member.model.MemberDAO;
import lib.member.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	//전체검색
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
	public JSONArray memberSearch(List<MemberDTO> dtos) {
		JSONArray ja = new JSONArray();
		JSONObject jo;
		
		for(int i=0; i<dtos.size(); i++) {
			jo = new JSONObject();
			MemberDTO dto = dtos.get(i);
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
	
	//항목검색
	@Override
	public List memberSearchCtgr(String searchCtgr, String searchWord) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		if(searchCtgr.equals("전체")) {
			System.out.println("전체"+searchWord);
			list = memberDAO.memberSearchAll(searchWord);
			for(MemberDTO memberDTO : list) {
				System.out.println(memberDTO.getMem_name()+" / ");
			}
		} else if(searchCtgr.equals("회원 ID")) {
			list = memberDAO.memberSearchID(searchWord);
		} else if(searchCtgr.equals("회원명")) {
			list = memberDAO.memberSearchName(searchWord);
		}
		return list;
	}

	@Override
	public void memberRankUpdate(List<MemberDTO> dtos) {
		for (MemberDTO memberDTO : dtos) {
			memberDAO.memberRankUpdate(memberDTO);
		}
	}

}
