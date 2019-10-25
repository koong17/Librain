package lib.employee.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lib.employee.board.mapper.BoardAttachMapper;
import lib.employee.board.mapper.BoardMapper;
import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
//@AllArgsConstructor : 모든 파라미터를 이용하는 생성자를 만듦

@Log4j
@Service
@AllArgsConstructor	
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	//글 쓰기
	@Transactional
	@Override
	public void boardInsert(BoardDTO board) {
		mapper.insertSelectKey(board);
		
		//파일첨부
		if(board.getAttachList() == null || board.getAttachList().size() <=0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			attach.setBoard_no(board.getBoard_no());
			attachMapper.insert(attach);
		});
	}

	//글 읽기
	@Override
	public BoardDTO boardSelectOne(Long board_no) {
		return mapper.read(board_no);
	}
	
	//이전 글
	@Override
	public BoardDTO boardSelectPrev(Long board_no) {
		
		BoardDTO dto = mapper.readPrev(board_no);
		if (dto==null) {
			return mapper.read(board_no);
		}else {
			return dto;
		}
	}
	
	//다음 글
	@Override
	public BoardDTO boardSelectNext(Long board_no) {
		BoardDTO dto =  mapper.readNext(board_no);
		if(dto==null) {
			return mapper.read(board_no);
		} else {
			return dto;
		}
	}

	//글 수정
	@Transactional
	@Override
	public boolean boardUpdate(BoardDTO board) {
		attachMapper.deleteAll(board.getBoard_no());
		
		boolean modifyResult = mapper.update(board) ==1;
		if(modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {
			board.getAttachList().forEach(attach -> {
				attach.setBoard_no(board.getBoard_no());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;	//여기서 리턴한 결과를 토대로 정상종료/비정상종료 판단하여 실제 글 수정처리 여부가 결정 됨
	}

	//글 삭제
	@Override
	public boolean boardDelete(Long board_no) {
		attachMapper.deleteAll(board_no);
		return mapper.delete(board_no)==1;
	}

	//전체보기
	@Override
	public List<BoardDTO> boardSelectAll(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	//페이징처리
	@Override
	public int boardGetTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	//첨부파일
	@Override
	public List<BoardAttachDTO> getAttachList(Long board_no) {
		log.info("get Attach List by board_no" + board_no);
		return attachMapper.findByBno(board_no);
	}
}
