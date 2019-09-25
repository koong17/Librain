package lib.employee.board.service;

import java.util.List;

import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;

public interface BoardService {
	//글쓰기
	public void boardInsert(BoardDTO board);
	//상세보기
	public BoardDTO boardSelectOne(Long bno);
	//수정
	public boolean boardUpdate(BoardDTO board);
	//삭제
	public boolean boardDelete(Long bno);		//수정/삭제는 void타입으로 해도 되지만 엄격하게 하기 위해 boolean 사용한다
	//목록조회
//	public List<BoardVO> getList();
	public List<BoardDTO> boardSelectAll(Criteria cri);
	
	//전체 데이터 수 구하기
	public int boardGetTotal(Criteria cri);
	
	//////파일첨부 관련
	public List<BoardAttachDTO> getAttachList(Long bno);
	
	
}
