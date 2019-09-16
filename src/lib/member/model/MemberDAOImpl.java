package lib.member.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public void insertMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.insertMember(dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.updateMember(dto);
	}

	@Override
	public void deleteMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.deleteMember(dto);
	}

	@Override
	public List<MemberDTO> getMemberList(HashMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.selectMember(dto);
	}

}
