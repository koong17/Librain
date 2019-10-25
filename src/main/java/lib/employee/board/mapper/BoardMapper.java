package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;

public interface BoardMapper {
	
	//글 목록 불러오기
	public List<BoardDTO> getList();
	public List<BoardDTO> getListWithPaging(Criteria cri);

	//글 삽입
	public Integer insertSelectKey(BoardDTO board);
	//글 읽기
	public BoardDTO read(Long board_no);
	//글 삭제
	public int delete(Long board_no);
	//글 수정	
	public int update(BoardDTO board);
	//전체 글의 수
	public int getTotalCount(Criteria cri);
	//이전글, 다음글
	public BoardDTO readPrev(Long board_no);
	public BoardDTO readNext(Long board_no);
	//공지글 불러오기
	public List<NoticeDTO> getNotices();
}
