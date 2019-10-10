package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.BoardAttachDTO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachDTO vo);
	public void delete(String uuid);
	public List<BoardAttachDTO> findByBno(Long board_no);
	
	public void deleteAll(Long board_no);
	
	//서버에 잘못 남아있는 파일 처리
	public List<BoardAttachDTO> getOldFiles();
}
