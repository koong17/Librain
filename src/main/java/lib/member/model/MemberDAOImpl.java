package lib.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO> list = sqlsession.getMapper(MemberDAO.class).memberSelectAll();
		//List<dto이름> 변수명 = sqlsession.getMapper(DAO명.class).함수();
		return list;
	}

	//검색
	@Override
	public List<MemberDTO> memberSearchAll(String searchWord) {
		List<MemberDTO> list = sqlsession.getMapper(MemberDAO.class).memberSearchAll("%" + searchWord + "%");
		return list;
	}
	
	@Override
	public List<MemberDTO> memberSearchID(String searchWord) {
		List<MemberDTO> list = sqlsession.getMapper(MemberDAO.class).memberSearchID("%" + searchWord + "%");
		return list;
	}

	@Override
	public List<MemberDTO> memberSearchName(String searchWord) {
		List<MemberDTO> list = sqlsession.getMapper(MemberDAO.class).memberSearchName("%" + searchWord + "%");
		return list;
	}

	@Override
	public void memberRankUpdate(MemberDTO dto) {
		sqlsession.getMapper(MemberDAO.class).memberRankUpdate(dto);
	}
	
}


