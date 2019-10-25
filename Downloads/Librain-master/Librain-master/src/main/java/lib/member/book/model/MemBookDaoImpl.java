package lib.member.book.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lib.employee.book.model.EmpBookDAO;
import lib.employee.book.model.Hope_BookDTO;

@Repository
public class MemBookDaoImpl implements MemBookDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public int hopeSelectRowNum() {
		return sqlsession.getMapper(MemBookDAO.class).hopeSelectRowNum();
	}
	
	@Override
	public List<Hope_BookDTO> hopeSelect(int startRowNum, int endRowNum) {
		List<Hope_BookDTO> list = sqlsession.getMapper(MemBookDAO.class).hopeSelect(startRowNum, endRowNum);
		return list;
	}
	
	@Override
	public void hopeInsertBook(Hope_BookDTO dto) {
		sqlsession.getMapper(MemBookDAO.class).hopeInsertBook(dto);
	}
	
	
	@Override
	public int hopeMemCheck(String mem_id) {
		return sqlsession.getMapper(MemBookDAO.class).hopeMemCheck(mem_id);
	}


	@Override
	public List<MemBookDTO> searchAll(String searchWord) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).searchAll(searchWord);
		return list;
	}

	@Override
	public List<MemBookDTO> searchCtgr(Map<String, String> parameters) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).searchCtgr(parameters);
		return list;
	}


	@Override
	public List<MemBookDTO> newBook(int startRowNum, int endRowNum) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).newBook(startRowNum, endRowNum);
		return list;
	}
	
	@Override
	public List<MemBookDTO> mostRent(int startRowNum, int endRowNum) {
		List<MemBookDTO> list = sqlsession.getMapper(MemBookDAO.class).mostRent(startRowNum, endRowNum);
		return list;
	}
	
}
