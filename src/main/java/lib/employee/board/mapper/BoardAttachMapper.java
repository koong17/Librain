package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.BoardAttachDTO;

public interface BoardAttachMapper {
	
	//파일 삽입
	public void insert(BoardAttachDTO vo);
	//글 등록 전 파일 삭제
	public void delete(String uuid);
	//게시글 번호 <-> 첨부파일 
	public List<BoardAttachDTO> findByBno(Long board_no);
	//글과 첨부파일 삭제
	public void deleteAll(Long board_no);
	//서버에 잘못 남아있는 파일 처리
	public List<BoardAttachDTO> getOldFiles();
}
