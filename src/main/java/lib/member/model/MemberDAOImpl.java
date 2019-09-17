﻿package lib.member.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlsession;

	@Override	// 권한변경 구현
	public void rankMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.rankMember(dto);
	}
	
	@Override	// 삭제(탈퇴)
	public void deleteMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.deleteMember(dto);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return sqlsession.getMapper(MemberDAO.class).getMemberList();
	}

	@Override	// 검색
	public void selectMember(MemberDTO dto) {
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		memberDAO.selectMember(dto);
	}
}


