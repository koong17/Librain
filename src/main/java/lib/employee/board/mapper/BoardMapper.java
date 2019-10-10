package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;

public interface BoardMapper {
	
	public List<BoardDTO> getList();
	public List<BoardDTO> getListWithPaging(Criteria cri);

	public Integer insertSelectKey(BoardDTO board);
	public BoardDTO read(Long board_no);
	public int delete(Long board_no);
	public int update(BoardDTO board);

	public int getTotalCount(Criteria cri);

	public BoardDTO readPrev(Long board_no);
	public BoardDTO readNext(Long board_no);
	
	public List<NoticeDTO> getNotices();
}
