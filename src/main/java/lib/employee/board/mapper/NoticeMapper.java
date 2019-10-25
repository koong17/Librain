package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;

public interface NoticeMapper {
	
	//글 등록
	public Integer insertSelectKey(NoticeDTO notice);
	//글 읽기
	public NoticeDTO read(Long board_no);
	//글 삭제
	public int delete(Long board_no);
	//글 수정
	public int update(NoticeDTO board);
	//전체 글 개수	
	public int getTotalCount(Criteria cri);
	//공지사항 리스트
	public List<NoticeDTO> getNotices();
	//이전 글 다음글
	public NoticeDTO readPrev(Long board_no);
	public NoticeDTO readNext(Long board_no);

}
