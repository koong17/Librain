package lib.employee.board.mapper;

import java.util.List;

import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;

public interface BoardMapper {
	
	public List<BoardDTO> getList();
	
	public List<BoardDTO> getListWithPaging(Criteria cri);
	
	//게시판의 PK가 자동으로 생성된다. 그런 경우에, PK를 알아야 할 경우 키를 셀렉하는 메소드를 따로 만들어준다.
//	public void insert(BoardVO board);
	public Integer insertSelectKey(BoardDTO board);
	
	//insert된 데이터 조회
	public BoardDTO read(Long bno);

	//insert/delete/update는 int형을 반환할 수 있다. 위에서 insert는 그냥 반환 안 하게 만든거고 얘네는 하게 만든거다. 고민 ㄴㄴ
	public int delete(Long bno);
	
	public int update(BoardDTO board);
	
	//전체 데이터 수 구하기
	public int getTotalCount(Criteria cri);
	
	
	

}
