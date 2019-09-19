package lib.employee.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.employee.mypage.model.CommuteDAO;
import lib.employee.mypage.model.CommuteDTO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	CommuteDAO commuteDAO;

	@Override
	public void cmtInsert(CommuteDTO commuteDTO) {
		commuteDAO.cmtInsert(commuteDTO);
	}
	
}
