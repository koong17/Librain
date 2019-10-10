package lib.employee.board.service;

import java.util.List;

import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;

public interface BoardService {
	public void boardInsert(BoardDTO board);
	public BoardDTO boardSelectOne(Long board_no);
	public boolean boardUpdate(BoardDTO board);
	public boolean boardDelete(Long board_no);
	public List<BoardDTO> boardSelectAll(Criteria cri);
	public int boardGetTotal(Criteria cri);
	public List<BoardAttachDTO> getAttachList(Long board_no);
	public BoardDTO boardSelectPrev(Long board_no);
	public BoardDTO boardSelectNext(Long board_no);
}
