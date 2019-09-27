package lib.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

	@Autowired	//bean 자동주입
	SqlSession sqlsession;
	
	@Override
	public List<MemberDTO> memberSelectAll() {
		List<MemberDTO> list = sqlsession.getMapper(MemberDAO.class).memberSelectAll();
		//List<dto이름> 변수명 = sqlsession.getMapper(DAO명.class).함수();
		return list;
	}

	@Override
	public void memberSearch(MemberDTO dto) {
		sqlsession.getMapper(MemberDAO.class).memberSearch(dto);
	}

	@Override
	public void memberRankUpdate(MemberDTO dto) {
		sqlsession.getMapper(MemberDAO.class).memberRankUpdate(dto);
	}
}


