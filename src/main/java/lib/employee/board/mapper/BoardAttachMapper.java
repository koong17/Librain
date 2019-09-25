package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.BoardAttachDTO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachDTO vo);
	public void delete(String uuid);
	public List<BoardAttachDTO> findByBno(Long bno);
	
	public void deleteAll(Long bno);
}
